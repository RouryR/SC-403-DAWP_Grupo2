package com.SC403_ProyectoWeb.Grupo2.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;


@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        Boolean usuarioAutenticado = (Boolean) session.getAttribute("usuarioAutenticado");
        model.addAttribute("usuarioAutenticado", usuarioAutenticado);
        
    }
}