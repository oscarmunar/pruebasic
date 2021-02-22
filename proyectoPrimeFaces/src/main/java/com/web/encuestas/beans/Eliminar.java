/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.beans;

import com.web.encuestas.beans.utils.SessionUtils;
import com.web.encuestas.services.EncuestaService;
import com.web.encuestas.tos.ToEncuesta;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oscar
 */
@Named
@ViewScoped
public class Eliminar implements Serializable{    
    
    private static final long serialVersionUID = 6529685098257757680L;
    
    private String username;
    private String ideuser;
    
    private ToEncuesta encuestaEliminar;
    
    @Inject
    private EncuestaService encuestaService;
    
    @PostConstruct
    public void init(){
        setUsername(SessionUtils.getUserName());
        setIdeuser((String) SessionUtils.getUserId());
        setEncuestaEliminar(new ToEncuesta());
    }
    
    
    
    public String eliminarEncuesta() {
        //this.encuestaNueva.setIdeusuario(Integer.valueOf(ideuser));
        System.out.println("TO ideusuario::::::::::::: " + this.encuestaEliminar.getIdeusuario());
        System.out.println("TO idencuesta::::::::::::: " + this.encuestaEliminar.getIdencuesta());
        this.encuestaService.setEncuesta(this.encuestaEliminar);
        this.encuestaService.eliminarEncuesta();
        
        return "admin";
        
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
    public String volverInicio() {        
        
        return "admin";
    }
    
    
    
    
    //Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdeuser() {
        return ideuser;
    }

    public void setIdeuser(String ideuser) {
        this.ideuser = ideuser;
    }

    public ToEncuesta getEncuestaEliminar() {
        return encuestaEliminar;
    }

    public void setEncuestaEliminar(ToEncuesta encuestaEliminar) {
        this.encuestaEliminar = encuestaEliminar;
    }
    
}
