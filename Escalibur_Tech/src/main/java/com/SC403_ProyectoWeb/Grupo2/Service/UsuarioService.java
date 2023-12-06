/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Service;

import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;


/**
 *
 * @author RouryR
 */

public interface UsuarioService {
    Usuario autenticarUsuario(String correo, String password);
}


