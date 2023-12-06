/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Service;

import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import java.util.List;

public interface TiquetesService {
    //Se obtiene un listado de categorias en un list
    public List<Tiquetes> getTiquetes (boolean activos);
    
  // Se obtiene un Arbol, a partir del id de un categoria
    public Tiquetes getTiquetes(Tiquetes categoria);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Tiquetes categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Tiquetes categoria);
    
}
