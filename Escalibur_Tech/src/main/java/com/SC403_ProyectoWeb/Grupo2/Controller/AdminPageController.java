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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @GetMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        usuarioService.eliminarUsuario(id);
        redirectAttributes.addFlashAttribute("exito", true);
        return "redirect:/admin/AdminPage";
    }

    @GetMapping("/AdminPageTiquetes")
    public String listaTiquetes(Model model, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);

            List<Tiquetes> tiquetes = tiqueteService.getTiquetes(true); // Puedes ajustar el booleano según tus necesidades
            model.addAttribute("tiquetes", tiquetes);
        }

        return "/admin/AdminPageTiquetes";
    }

    @PostMapping("/AdminPageCrearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario,@RequestParam("rol") int rol,Model model,RedirectAttributes redirectAttributes) {
       model.addAttribute("usuario", usuario);
        usuario.setActivo(true); 
        usuario.setRol(rol); 
    

        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("exito", true);

        return "redirect:/admin/AdminPageCrearUsuario";
    }

   
    @GetMapping("/AdminPageCrearUsuario")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/AdminPageCrearUsuario";
    }






}
