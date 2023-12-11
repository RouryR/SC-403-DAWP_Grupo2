// package com.SC403_ProyectoWeb.Grupo2.Domain;

// import java.sql.Date;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;


// @Entity
// public class Empleados {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_empleado")  // Nombre real de la columna en la base de datos
//     private Long idEmpleado;
//     private String nombre;
//     private String password;
//     private String correo;
//     private String empresa;
//     private String puesto;
//     private double salario;
//     private String telefono;
//     private Date fechaContratacion;
//     private boolean activo;
//     private int idUsuario;
   


//     @ManyToOne
//     @JoinColumn(name = "id_usuario")
//     private Usuario usuario;

//     public Empleados() {
//     }

//     public Long getIdEmpleado() {
//         return idEmpleado;
//     }

//     public void setIdEmpleado(Long idEmpleado) {
//         this.idEmpleado = idEmpleado;
//     }

//     public String getNombre() {
//         return nombre;
//     }

//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getCorreo() {
//         return correo;
//     }

//     public void setCorreo(String correo) {
//         this.correo = correo;
//     }

//     public String getEmpresa() {
//         return empresa;
//     }

//     public void setEmpresa(String empresa) {
//         this.empresa = empresa;
//     }

//     public String getPuesto() {
//         return puesto;
//     }

//     public void setPuesto(String puesto) {
//         this.puesto = puesto;
//     }

//     public double getSalario() {
//         return salario;
//     }

//     public void setSalario(double salario) {
//         this.salario = salario;
//     }

//     public String getTelefono() {
//         return telefono;
//     }

//     public void setTelefono(String telefono) {
//         this.telefono = telefono;
//     }

//     public Date getFechaContratacion() {
//         return fechaContratacion;
//     }

//     public void setFechaContratacion(Date fechaContratacion) {
//         this.fechaContratacion = fechaContratacion;
//     }

//     public boolean isActivo() {
//         return activo;
//     }

//     public void setActivo(boolean activo) {
//         this.activo = activo;
//     }

//     public int getIdUsuario() {
//         return idUsuario;
//     }

//     public void setIdUsuario(int idUsuario) {
//         this.idUsuario = idUsuario;
//     }

//     public Usuario getUsuario() {
//         return usuario;
//     }

//     public void setUsuario(Usuario usuario) {
//         this.usuario = usuario;
//     }

//     public Empleados(Long idEmpleado, String nombre, String password, String correo, String empresa, String puesto,
//             double salario, String telefono, Date fechaContratacion, boolean activo, int idUsuario, Usuario usuario) {
//         this.idEmpleado = idEmpleado;
//         this.nombre = nombre;
//         this.password = password;
//         this.correo = correo;
//         this.empresa = empresa;
//         this.puesto = puesto;
//         this.salario = salario;
//         this.telefono = telefono;
//         this.fechaContratacion = fechaContratacion;
//         this.activo = activo;
//         this.idUsuario = idUsuario;
//         this.usuario = usuario;
//     }

    
    
    
// }

