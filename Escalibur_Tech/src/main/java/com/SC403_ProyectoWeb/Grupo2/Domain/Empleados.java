package com.SC403_ProyectoWeb.Grupo2.Domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")  // Nombre real de la columna en la base de datos
    private Long idEmpleado;
    private String nombre;
    private String correo;
    private String puesto;
    private double salario;
    private String telefono;
    private boolean activo;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Empleados() {
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empleados(Long idEmpleado, String nombre, String correo, String puesto,
            double salario, String telefono, boolean activo, Usuario usuario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
        this.puesto = puesto;
        this.salario = salario;
        this.telefono = telefono;
        this.activo = activo;
        this.usuario = usuario;
    }

}

