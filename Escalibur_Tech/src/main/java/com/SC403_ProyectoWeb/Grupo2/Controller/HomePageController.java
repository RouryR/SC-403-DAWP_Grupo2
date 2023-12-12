package com.SC403_ProyectoWeb.Grupo2.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HomePage") //nombre de la carpeta
public class HomePageController {
    @GetMapping("/Home") //nombre del html
    public String acercade() {

        return "/HomePage/Home"; //Ruta completa
    }
}
