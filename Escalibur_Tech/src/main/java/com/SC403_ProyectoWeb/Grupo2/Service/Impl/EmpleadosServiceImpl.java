// package com.SC403_ProyectoWeb.Grupo2.Service.Impl;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.SC403_ProyectoWeb.Grupo2.Dao.EmpleadosDao;
// import com.SC403_ProyectoWeb.Grupo2.Domain.Empleados;
// import com.SC403_ProyectoWeb.Grupo2.Service.EmpleadosService;

// @Service
// public class EmpleadosServiceImpl implements EmpleadosService {

//     @Autowired
//     private EmpleadosDao empleadosDao;

//     @Override
//     @Transactional(readOnly = true)
//     public List<Empleados> getTiquetes(boolean activos) {
//         List<Empleados> lista = empleadosDao.findAll();
//         if (activos) {
//             lista.removeIf(e -> !e.isActivo());
//         }
//         return lista;
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public Empleados getTiquetes(Empleados categoria) {
//         return empleadosDao.findById(categoria.getId()).orElse(null);
//     }

//     @Override
//     @Transactional
//     public void save(Empleados categoria) {
//         empleadosDao.save(categoria);
//     }

//     @Override
//     @Transactional
//     public void delete(Empleados categoria) {
//         empleadosDao.delete(categoria);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<Empleados> getTiquetesByUsuario(Long usuarioId) {
//         return empleadosDao.findByUsuarioId(usuarioId);
//     }
// }

