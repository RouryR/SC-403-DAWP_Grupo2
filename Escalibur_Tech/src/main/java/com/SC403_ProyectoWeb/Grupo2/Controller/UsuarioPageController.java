package com.SC403_ProyectoWeb.Grupo2.Controller;

import com.SC403_ProyectoWeb.Grupo2.Domain.Empleados;
import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import com.SC403_ProyectoWeb.Grupo2.Domain.Usuario;
import com.SC403_ProyectoWeb.Grupo2.Service.EmpleadosService;
import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;
import com.SC403_ProyectoWeb.Grupo2.Service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/usuario")
public class UsuarioPageController {

    @Autowired
    private TiquetesService tiqueteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpleadosService empleadoService;

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
    public String Settings(Model model, HttpSession session) {
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
    public String GestionEmpleados(Model model, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            model.addAttribute("usuario", usuario);
            List<Empleados> empleadosUsuario = empleadoService.getEmpleadosByUsuario(usuario.getId());
            model.addAttribute("empleados", empleadosUsuario);
            model.addAttribute("totalempleados", empleadosUsuario.size());
        }

        return "/usuario/GestionEmpleados"; //Ruta completa
    }

    @PostMapping("/eliminarEmpleado")
    public String eliminarEmpleado(@RequestParam Long empleadoId, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            // Verificar si el usuario tiene permisos para eliminar empleados (puedes agregar más lógica según tus requisitos)

            // Llamar al servicio para eliminar el empleado
            empleadoService.deleteEmpleado(empleadoId);
        }

        return "redirect:/usuario/GestionEmpleados";
    }

    @PostMapping("/actualizarEmpleado")
    public String actualizarEmpleado(@ModelAttribute Empleados empleadoForm,
            @RequestParam("empleadoId") Long idEmpleado,
            HttpSession session,
            HttpServletRequest request) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");

            // Set the ID from the request parameter
            empleadoForm.setIdEmpleado(idEmpleado);

            // Fetch the existing employee by ID
            Empleados existingEmpleado = empleadoService.getEmpleados(empleadoForm);
            

            // Check if the employee exists and belongs to the current user
            if (existingEmpleado != null && existingEmpleado.getUsuario().getId().equals(usuario.getId())) {
                // Update employee details only if the form fields are not blank
                if (empleadoForm.getIdEmpleado() != null) {
                    existingEmpleado.setIdEmpleado(empleadoForm.getIdEmpleado());
                }

                if (empleadoForm.getNombre() != null && !empleadoForm.getNombre().isEmpty()) {
                    existingEmpleado.setNombre(empleadoForm.getNombre());
                }
                if (empleadoForm.getCorreo() != null && !empleadoForm.getCorreo().isEmpty()) {
                    existingEmpleado.setCorreo(empleadoForm.getCorreo());
                }
                if (empleadoForm.getPuesto() != null && !empleadoForm.getPuesto().isEmpty()) {
                    existingEmpleado.setPuesto(empleadoForm.getPuesto());
                }
                if (empleadoForm.getSalario() != 0.0) {
                    existingEmpleado.setSalario(empleadoForm.getSalario());
                }
                if (empleadoForm.getTelefono() != null && !empleadoForm.getTelefono().isEmpty()) {
                    existingEmpleado.setTelefono(empleadoForm.getTelefono());
                }

                empleadoService.updateEmpleado(existingEmpleado);
            }
        }

        return "redirect:/usuario/GestionEmpleados";
    }

    
    @RequestMapping(value = "/CrearEmpleado", method = { RequestMethod.GET, RequestMethod.POST })
    public String crearEmpleado(@ModelAttribute Empleados empleadoForm, HttpSession session) {
        if (session.getAttribute("usuarioAutenticado") != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
      

            // Crea un nuevo empleado solo si los campos obligatorios no están vacíos
            if (empleadoForm.getNombre() != null && !empleadoForm.getNombre().isEmpty()
                    && empleadoForm.getCorreo() != null && !empleadoForm.getCorreo().isEmpty()
                    && empleadoForm.getPuesto() != null && !empleadoForm.getPuesto().isEmpty()
                    && empleadoForm.getSalario() != 0.0
                    && empleadoForm.getTelefono() != null && !empleadoForm.getTelefono().isEmpty()) {

                        

                Empleados nuevoEmpleado = new Empleados();
                nuevoEmpleado.setNombre(empleadoForm.getNombre());
                nuevoEmpleado.setCorreo(empleadoForm.getCorreo());
                nuevoEmpleado.setPuesto(empleadoForm.getPuesto());
                nuevoEmpleado.setSalario(empleadoForm.getSalario());
                nuevoEmpleado.setTelefono(empleadoForm.getTelefono());
                // Asigna el ID del usuario al empleado

                nuevoEmpleado.setUsuario(usuario);
                nuevoEmpleado.setActivo(true);

                // Guarda el nuevo empleado
                empleadoService.save(nuevoEmpleado);
            }
        }
        

        return "/usuario/CrearEmpleado";
    }

}

