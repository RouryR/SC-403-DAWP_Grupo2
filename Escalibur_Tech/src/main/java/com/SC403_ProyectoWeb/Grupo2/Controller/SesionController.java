/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Controller;


import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ROURY
 */

@Controller
@RequestMapping("/sesion")
public class SesionController {

    @Autowired
    private UsuarioService authService;

    @GetMapping("/InicioSesion")
    public String mostrarPaginaLogin(HttpSession session, Model model) {
        boolean usuarioAutenticado = session.getAttribute("usuarioAutenticado") != null && (boolean) session.getAttribute("usuarioAutenticado");
        model.addAttribute("usuarioAutenticado", usuarioAutenticado);
        return "/sesion/InicioSesion";
    }


    @PostMapping("/login")
public String autenticar(@RequestParam String correo, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
    Usuario usuarioAutenticado = authService.autenticarUsuario(correo, password);

    if (usuarioAutenticado != null) {
        // Establecer en la sesión
        session.setAttribute("usuarioAutenticado", true);
        session.setAttribute("usuario", usuarioAutenticado);
        redirectAttributes.addFlashAttribute("username", usuarioAutenticado.getUsuario());
        redirectAttributes.addFlashAttribute("usuarioAutenticado", true);

        // Imprimir mensajes para la depuración
        System.out.println("Usuario autenticado: " + usuarioAutenticado.getUsuario());
        System.out.println("Sesión autenticada: " + session.getAttribute("usuarioAutenticado"));

        return "redirect:/usuario/UsuarioPage";
    } else {
        // Limpiar la sesión en caso de autenticación fallida
        session.removeAttribute("usuarioAutenticado");
        session.invalidate();
        redirectAttributes.addFlashAttribute("error", "Credenciales inválidas");
        return "redirect:/sesion/InicioSesion";
    }
}


    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        session.removeAttribute("usuarioAutenticado");
        session.invalidate();
        return "redirect:/";
    }


}



