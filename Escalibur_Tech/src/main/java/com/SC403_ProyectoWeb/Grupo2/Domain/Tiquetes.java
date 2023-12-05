/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="tiquetes")
public class Tiquetes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tiquete")
    private Long id_tiquete;
    private String descripcion;
    private Date fecha_apertura;
    private boolean activo;
    
    public Tiquetes() {
    }
    public Tiquetes(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }
}
