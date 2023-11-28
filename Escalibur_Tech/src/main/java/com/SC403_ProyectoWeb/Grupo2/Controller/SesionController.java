/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ROURY
 */
@Controller
@RequestMapping("/sesion") //nombre de la carpeta
public class SesionController {
    @GetMapping("/InicioSesion") //nombre del html
    public String acercade() {

        return "/sesion/InicioSesion"; //Ruta completa
    }
}