package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos") //nombre de la carpeta
public class ImportacionesController {
    @GetMapping("/Importaciones") //nombre del html
    public String acercade() {

        return "/productos/Importaciones"; //Ruta completa
    }
}
