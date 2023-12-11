package com.SC403_ProyectoWeb.Grupo2.Controller;

import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioPageController {

    @Autowired
    private TiquetesService tiqueteService;
    
     @Autowired
    private UsuarioService usuarioService; 

    @GetMapping("/UsuarioPage")
    public String inicio(Model model, HttpSession session) {

        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);
            List<Tiquetes> tiquetesUsuario = tiqueteService.getTiquetesByUsuario(usuario.getId());
            model.addAttribute("tiquetes", tiquetesUsuario);
            model.addAttribute("totalTiquetes", tiquetesUsuario.size());
        }

        return "/usuario/UsuarioPage";
    }
    
    
    @GetMapping("/UsuarioSettings")
public String Settings(Model model, HttpSession session){
    if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);
            List<Tiquetes> tiquetesUsuario = tiqueteService.getTiquetesByUsuario(usuario.getId());
            model.addAttribute("tiquetes", tiquetesUsuario);
            model.addAttribute("totalTiquetes", tiquetesUsuario.size());
        }
     return "/usuario/UsuarioSettings";
}

@PostMapping("/editar")
public String editarUsuario(@ModelAttribute Usuario usuarioForm, HttpSession session) {
    if (session.getAttribute("usuarioAutenticado") != null) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuarioForm.getNombre() != null) {
            usuario.setNombre(usuarioForm.getNombre());
        }

        if (usuarioForm.getPassword() != null) {
            usuario.setPassword(usuarioForm.getPassword());
        }

        if (usuarioForm.getApellidos() != null) {
            usuario.setApellidos(usuarioForm.getApellidos());
        }

        if (usuarioForm.getTelefono() != null) {
            usuario.setTelefono(usuarioForm.getTelefono());
        }

        if (usuarioForm.getCorreo() != null) {
            usuario.setCorreo(usuarioForm.getCorreo());
        }

        // Guarda 
        usuarioService.save(usuario);
    }

    return "redirect:/usuario/UsuarioSettings";
}

    @GetMapping("/creartiquete") //nombre del html
    public String creartiquete() {

        return "/usuario/creartiquete"; //Ruta completa
    }

     @GetMapping("/GestionEmpleados") //nombre del html
    public String Gestionusuarios() {

        return "/usuario/GestionEmpleados"; //Ruta completa
    }

}

