package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/acercade") //nombre de la carpeta
public class acercadeController {
    @GetMapping("/nosotros") //nombre del html
    public String acercade() {

        return "/acercade/nosotros"; //Ruta completa
    }
}
