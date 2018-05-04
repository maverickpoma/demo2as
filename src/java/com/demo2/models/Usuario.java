package com.demo2.models;
// Generated 04/05/2018 01:16:09 AM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuarios;
     private String nombres;
     private String apellidos;
     private String areaDeTrabajo;
     private String correo;
     private String password;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String areaDeTrabajo, String correo, String password) {
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.areaDeTrabajo = areaDeTrabajo;
       this.correo = correo;
       this.password = password;
    }
   
    public Integer getIdUsuarios() {
        return this.idUsuarios;
    }
    
    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getAreaDeTrabajo() {
        return this.areaDeTrabajo;
    }
    
    public void setAreaDeTrabajo(String areaDeTrabajo) {
        this.areaDeTrabajo = areaDeTrabajo;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

