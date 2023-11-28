package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/servicios") //nombre de la carpeta
public class capacitacionController {
    @GetMapping("/capacitacion") //nombre del html
    public String capacitacion() {

        return "/servicios/capacitacion"; //Ruta completa
    }
}