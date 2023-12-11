/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Dao;


import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiquetesDao extends JpaRepository<Tiquetes, Long> {
    List<Tiquetes> findByUsuarioId(Long usuarioId);
}

