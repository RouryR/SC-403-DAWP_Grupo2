package com.SC403_ProyectoWeb.Grupo2.Service;

import java.util.List;

import com.SC403_ProyectoWeb.Grupo2.Domain.Empleados;

public interface EmpleadosService {
    //Se obtiene un listado de categorias en un list
    public List<Empleados> getEmpleados (boolean activos);
    
  // Se obtiene un Arbol, a partir del id de un categoria
    public Empleados getEmpleados(Empleados empleado);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Empleados empleado);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void deleteEmpleado(Long empleadoId);
    
    // Obtener tiquetes por usuario
    List<Empleados> getEmpleadosByUsuario(Long usuarioId);

    void updateEmpleado(Empleados empleado);
    

    
}
