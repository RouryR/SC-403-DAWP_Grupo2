package com.SC403_ProyectoWeb.Grupo2.Service.Impl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SC403_ProyectoWeb.Grupo2.Dao.EmpleadosDao;
import com.SC403_ProyectoWeb.Grupo2.Domain.Empleados;
import com.SC403_ProyectoWeb.Grupo2.Service.EmpleadosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosDao empleadosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getEmpleados(boolean activos) {
        List<Empleados> lista = empleadosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getEmpleados(Empleados categoria) {
        return empleadosDao.findById(categoria.getIdEmpleado()).orElse(null);
    }

   
    @Override
    @Transactional
    public void save(Empleados empleado) {
        empleadosDao.save(empleado);
    }

    @Override
    @Transactional
    public void deleteEmpleado(Long empleadoId) {
        // Buscar el empleado por su ID
        Empleados empleado = empleadosDao.findById(empleadoId).orElse(null);

        // Verificar si el empleado existe antes de eliminarlo
        if (empleado != null) {
            // Eliminar el empleado
            empleadosDao.delete(empleado);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getEmpleadosByUsuario(Long usuarioId) {
        return empleadosDao.findByUsuarioId(usuarioId);
    }
    
    @Override
    @Transactional
    public void updateEmpleado(Empleados empleado) {
        // Verificar que el ID no sea nulo antes de actualizar
        if (empleado.getIdEmpleado() != null) {
            // Update the existing employee
            empleadosDao.save(empleado);
        } else {
            // Manejar el caso en que el ID es nulo, por ejemplo, lanzar una excepción o loggear un error
        }
    }

}

