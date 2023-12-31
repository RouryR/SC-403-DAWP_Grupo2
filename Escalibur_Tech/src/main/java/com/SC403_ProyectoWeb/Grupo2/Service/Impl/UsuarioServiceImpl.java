/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Service.Impl;

import com.SC403_ProyectoWeb.Grupo2.Dao.EmpleadosDao;
import com.SC403_ProyectoWeb.Grupo2.Dao.TiquetesDao;
import com.SC403_ProyectoWeb.Grupo2.Dao.UsuarioDao;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author RouryR
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private EmpleadosDao empleadoDao;

    @Autowired
    private TiquetesDao tiquetesService;

    @Override
    public Usuario autenticarUsuario(String correo, String password) {

        return usuarioDao.findByCorreoAndPassword(correo, password);
    }
    
    @Override
    public Usuario save(Usuario usuario) {
        usuarioDao.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioDao.findAll();
    }
    
    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        // Eliminar empleados relacionados
        empleadoDao.deleteByUsuarioId(id);

        // Eliminar usuario
        usuarioDao.deleteById(id);

        tiquetesService.deleteByUsuarioId(id);
    }
}

