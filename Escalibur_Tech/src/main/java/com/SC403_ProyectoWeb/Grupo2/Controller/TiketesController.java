package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tiketes") //nombre de la carpeta
public class TiketesController {
    @GetMapping("/FormularioTiketes") //nombre del html
    public String acercade() {

        return "/tiketes/FormularioTiketes"; //Ruta completa
    }
}

