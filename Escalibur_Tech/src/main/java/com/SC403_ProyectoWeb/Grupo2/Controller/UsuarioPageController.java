package com.SC403_ProyectoWeb.Grupo2.Controller;

import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioPageController {

    @Autowired
    private TiquetesService tiqueteService;

    @GetMapping("/UsuarioPage")
    public String inicio(Model model) {
        var tiquete = tiqueteService.getTiquetes(false);
        model.addAttribute("tiquetes", tiquete);
        model.addAttribute("totalTiquetes", tiquete.size());
        return "/usuario/UsuarioPage";
    }
}




