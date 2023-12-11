package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ERPController {
    @GetMapping("/ERP")
    public String ERP() {
        return "/productos/ERP"; // La ruta relativa a la carpeta "templates"
    }
}
