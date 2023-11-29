package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ROURY
 */
@Controller
@RequestMapping("/casoExito") //nombre de la carpeta
public class CasosExitoController {
    @GetMapping("/CasosExito") //nombre del html
    public String acercade() {

        return "/casoExito/CasosExito"; //Ruta completa
    }
}
