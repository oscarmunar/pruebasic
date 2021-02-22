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
import java.util.List;
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
public class Consultar implements Serializable{    
    
    private static final long serialVersionUID = 6529687098257757690L;
    
    private String username;
    private String ideuser;
    
    
    private List<ToEncuesta> encuestas;
    
    private List<ToEncuesta> selectedEncuestas;
    public List<ToEncuesta> getSelectedEncuestas() {
        return selectedEncuestas;
    }
    public void setSelectedEncuestas(List<ToEncuesta> selectedEncuestas) {
        this.selectedEncuestas = selectedEncuestas;
    }
    
    private ToEncuesta selectedEncuesta;
    public ToEncuesta getSelectedEncuesta() {
        return selectedEncuesta;
    }
    public void setSelectedEncuesta(ToEncuesta selectedEncuesta) {
        this.selectedEncuesta = selectedEncuesta;
    }
    
    
    
    @Inject
    private EncuestaService encuestasService;
    
    @PostConstruct
    public void init() {
        this.encuestasService.consultarEncuestas();
        this.setEncuestas(this.encuestasService.getEncuestas());
        //HttpSession session = SessionUtils.getSession();
        //session.setAttribute("username", user);
        //session.getAttribute(msg)
        username = SessionUtils.getUserName();
        ideuser = (String) SessionUtils.getUserId();
        
        //this.encuestas = this.encuestaService.getEncuestas();
//        this.selectedEncuesta = new ToEncuesta();
//        this.selectedEncuesta.setNombreusuario(username);
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

    public List<ToEncuesta> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<ToEncuesta> encuestas) {
        this.encuestas = encuestas;
    }
    
    
    
    
    
    
    
    
}
