package com.SC403_ProyectoWeb.Grupo2.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/HomePage") //nombre de la carpeta
public class HomePageController {
    @GetMapping("/Home") //nombre del html
    public String acercade(Model model, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);
            model.addAttribute("rol", usuario.getRol());
        }

        return "/HomePage/Home"; //Ruta completa
    }
}
