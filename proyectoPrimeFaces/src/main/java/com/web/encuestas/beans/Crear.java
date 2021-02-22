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
import javax.enterprise.context.SessionScoped;
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
public class Crear implements Serializable{    
    
    private static final long serialVersionUID = 6529685098257757690L;
    
    private String username;
    private String ideuser;
    
    private ToEncuesta encuestaNueva;
    
    @Inject
    private EncuestaService encuestaService;
    
    @PostConstruct
    public void init(){
        username = SessionUtils.getUserName();
        ideuser = (String) SessionUtils.getUserId();
        encuestaNueva = new ToEncuesta();
    }
    
    
    
    public String crearEncuestaNueva() {
        //this.encuestaNueva.setIdeusuario(Integer.valueOf(ideuser));
        System.out.println("TO ideusuario::::::::::::: " + this.encuestaNueva.getIdeusuario());
        System.out.println("TO marcapc::::::::::::: " + this.encuestaNueva.getIdemarcapc());
        this.encuestaService.setEncuesta(this.encuestaNueva);
        this.encuestaService.insertarEncuesta();
        
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

    public ToEncuesta getEncuestaNueva() {
        return encuestaNueva;
    }

    public void setEncuestaNueva(ToEncuesta encuestaNueva) {
        this.encuestaNueva = encuestaNueva;
    }
    
    
}
