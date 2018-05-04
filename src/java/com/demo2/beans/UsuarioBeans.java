

package com.demo2.beans;

import com.demo2.dao.UsuarioDAO;
import com.demo2.models.Usuario;
import com.demo2.models.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.activation.DataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author SISTEMAS
 */
@Named(value = "usuarioBeans")
@SessionScoped
public class UsuarioBeans implements Serializable {

    private int idUsuarios;
     private String nombres;
     private String apellidos;
     private String areaDeTrabajo;
     private String correo;
     private String password;
     
    public UsuarioBeans() {
  
    }
    
    public void addUsuario(){
       
        Usuario usuario = new Usuario(nombres, apellidos, areaDeTrabajo, correo, password);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.addUsuario(usuario);
        limpiarCampos();
    }

    public void returnUsuarioById(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.findUsuarioByID(getIdUsuarios());
        if(usuario != null){
            System.out.println(usuario.getIdUsuarios());
            System.out.println(usuario.getNombres());
            setIdUsuarios(usuario.getIdUsuarios());
            setNombres(usuario.getNombres());
            setApellidos(usuario.getApellidos());
            setAreaDeTrabajo(usuario.getAreaDeTrabajo());
            setCorreo(usuario.getCorreo());
            setPassword(usuario.getPassword());
        }else{
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Alumno no encontrado"));
        }
    }
    
    public void updateUsuario(){
        Usuario newUsuario = new Usuario(getNombres(), getAreaDeTrabajo(),getApellidos(),getCorreo(),getPassword());       
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.updateUsuario(getIdUsuarios(), newUsuario);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("usuario actualizado correctamente"));   
    }
    
    public void deleteUsuario(){
       UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deleteUsuario(idUsuarios);
        limpiarCampos();
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("usuario eliminado"));
    }
    
    public void limpiarCampos(){
        setIdUsuarios(0);
        setNombres("");
        setApellidos("");
        setCorreo("");
        setAreaDeTrabajo("");
        setPassword("");
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    public void setAreaDeTrabajo(String areaDeTrabajo) {
        this.areaDeTrabajo = areaDeTrabajo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    

}
    

