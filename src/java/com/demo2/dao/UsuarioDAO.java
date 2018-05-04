/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo2.dao;

import com.demo2.utils.NewHibernateUtil;
import com.demo2.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    public void addUsuario(Usuario usuario){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally{
            session.flush();
            session.close();
        } 
    }
    
    public void deleteUsuario(int idUsuario){
        Transaction trns = null;
         Session session = NewHibernateUtil.getSessionFactory().openSession();
         try{
             trns = session.beginTransaction();
             Usuario usuario = (Usuario) session.load(Usuario.class, new Integer (idUsuario));
             session.delete(usuario);
             session.getTransaction().commit();
         }catch(RuntimeException e){
             trns.rollback();
         } finally{
             session.flush();
             session.close();
         }
    }
    
    public void updateUsuario(int idUsuario, Usuario newUsuario){
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            Usuario oldUsuario = (Usuario) session.load(Usuario.class, (idUsuario));
            oldUsuario.setNombres(newUsuario.getNombres());
            oldUsuario.setApellidos(newUsuario.getApellidos());
            oldUsuario.setAreaDeTrabajo(newUsuario.getAreaDeTrabajo());
            oldUsuario.setCorreo(newUsuario.getCorreo());
            oldUsuario.setPassword(newUsuario.getPassword());
            
            session.update(oldUsuario);
            trns.commit();
        } catch(RuntimeException e){
            trns.rollback();
        } finally{
            session.flush();
            session.close();
        }
    }
    
    public Usuario findUsuarioByID(int idUsuario){
        Usuario usuario = null;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Alumno where codigo = :idToFind";
            Query query = session.createQuery(queryString);
            query.setInteger("idToFind", idUsuario);
            usuario = (Usuario) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return usuario;
    }
    
    public List<Usuario> listaUsuarioTodos(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql = " from Libro";        
        List<Usuario> listaUsuario= new ArrayList<>();
        try{
            Query query = session.createQuery(hql);
            listaUsuario = (List<Usuario>) query.list();
            
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return listaUsuario;
    }
}
