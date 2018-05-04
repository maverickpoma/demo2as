

package com.demo2.beans;

import com.demo2.dao.UsuarioDAO;
import com.demo2.models.Usuarios;
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
       
        Usuarios usuario = new Usuarios(nombres, apellidos, areaDeTrabajo, correo, password);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.addUsuario(usuario);
        limpiarCampos();
    }

    public void returnUsuarioById(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuarios usuario = usuarioDAO.findUsuarioByID(getIdUsuarios());
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
        Usuarios newUsuario = new Usuarios(getNombres(), getAreaDeTrabajo(),getApellidos(),getCorreo(),getPassword());       
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
    
    /**
     * @return the idUsuarios
     */
    public int getIdUsuarios() {
        return idUsuarios;
    }

    /**
     * @param idUsuarios the idUsuarios to set
     */
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the areaDeTrabajo
     */
    public String getAreaDeTrabajo() {
        return areaDeTrabajo;
    }

    /**
     * @param areaDeTrabajo the areaDeTrabajo to set
     */
    public void setAreaDeTrabajo(String areaDeTrabajo) {
        this.areaDeTrabajo = areaDeTrabajo;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
    

