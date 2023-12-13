package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin") //nombre de la carpeta
public class AdminPageController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TiquetesService tiqueteService;

    @GetMapping("/AdminPage")
    public String adminPage(Model model, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);

            // Retrieve all users from the service
            List<Usuario> usuarios = usuarioService.getAllUsers();
            model.addAttribute("usuarios", usuarios);
        }

        return "/admin/AdminPage";
    }

    @GetMapping("/AdminPageTiquetes")
    public String listaTiquetes(Model model, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);

            // Recupera todos los tiquetes desde el servicio
            List<Tiquetes> tiquetes = tiqueteService.getTiquetes(true); // Puedes ajustar el booleano según tus necesidades
            model.addAttribute("tiquetes", tiquetes);
        }

        return "/admin/AdminPageTiquetes";
    }

    @PostMapping("/AdminPageCrearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar el usuario
        usuario.setActivo(true); // Por ejemplo, establecer el usuario como activo por defecto
        usuario.setRol(1); // Asignar un rol por defecto
    

        usuarioService.save(usuario);
        return "redirect:/admin/AdminPageCrearUsuario"; // Redirigir a la página de creación de usuario
    }

    // Agregar método para manejar solicitudes GET si es necesario
    @GetMapping("/AdminPageCrearUsuario")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/AdminPageCrearUsuario";
    }






}
