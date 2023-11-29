package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuario") //nombre de la carpeta
public class UsuarioPageController {
    @GetMapping("/UsuarioPage") //nombre del html
    public String UserPage() {

        return "/usuario/UsuarioPage"; //Ruta completa
    }
    
    @GetMapping("/UsuarioSettings") //nombre del html
    public String Settings() {

        return "/usuario/UsuarioSettings"; //Ruta completa
    }
    
    
}
