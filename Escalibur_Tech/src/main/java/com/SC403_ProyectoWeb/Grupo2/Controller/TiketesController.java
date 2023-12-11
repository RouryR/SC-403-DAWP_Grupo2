package com.SC403_ProyectoWeb.Grupo2.Controller;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;



@Controller
@RequestMapping("/tiketes") //nombre de la carpeta
public class TiketesController {
    @Autowired
    private TiquetesService tiqueteService;

    @GetMapping("/FormularioTiketes") //nombre del html
    public String acercade() {

        return "/tiketes/FormularioTiketes"; //Ruta completa
    }

    @PostMapping("/crear")
    public String crearTiquete(@RequestParam String titulo, @RequestParam String descripcion, HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {

            return "redirect:/login"; 
        }

        Tiquetes nuevoTiquete = new Tiquetes();
        nuevoTiquete.setTitulo(titulo);
        nuevoTiquete.setDescripcion(descripcion);
        nuevoTiquete.setFechaApertura(LocalDate.now()); 
        nuevoTiquete.setUsuario(usuario); 
        nuevoTiquete.setActivo(true);
        tiqueteService.save(nuevoTiquete);
        Long idTiquete = nuevoTiquete.getId();
        model.addAttribute("idTiquete", idTiquete);

        try {
        // Agrega un delay de 2 segundos (ajusta el tiempo según tus necesidades)
        TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
        // Maneja la excepción si es necesario
        e.printStackTrace();
    }

        return "redirect:/usuario/UsuarioPage";
    }

}

