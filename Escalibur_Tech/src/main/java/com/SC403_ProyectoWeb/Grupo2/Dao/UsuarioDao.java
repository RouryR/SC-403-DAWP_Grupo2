/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Dao;

import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RouryR
 */

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoAndPassword(String correo, String password);
}

