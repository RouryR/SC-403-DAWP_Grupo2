/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Controller;


import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ROURY
 */
//@Controller
//@RequestMapping("/sesion") //nombre de la carpeta
//public class SesionController {

//    @GetMapping("/InicioSesion") //nombre del html
//    public String acercade() {
//
//        return "/sesion/InicioSesion"; //Ruta completa
//    }


@Controller
@RequestMapping("/sesion")
public class SesionController {

    @Autowired
    private UsuarioService authService;

    @GetMapping("/InicioSesion")
    public String mostrarPaginaLogin(Model model) {
        model.addAttribute("usuarioAutenticado", false);
        return "/sesion/InicioSesion";  
    }

    @PostMapping("/login")
public String autenticar(@RequestParam String correo, @RequestParam String password, Model model) {
    Usuario usuarioAutenticado = authService.autenticarUsuario(correo, password);

    if (usuarioAutenticado != null) {
        model.addAttribute("usuarioAutenticado", true);
        return "redirect:/usuario/UsuarioPage";
    } else {
        model.addAttribute("error", "Credenciales inválidas");
        return "/sesion/InicioSesion";
    }
}
}


