package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/servicios") //nombre de la carpeta
public class callcenterController {
    @GetMapping("/callcenter") //nombre del html
    public String callcenter() {

        return "/servicios/callcenter"; //Ruta completa
    }
}