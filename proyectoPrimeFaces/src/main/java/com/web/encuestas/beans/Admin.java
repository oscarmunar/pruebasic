/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.beans;

import com.web.encuestas.beans.utils.SessionUtils;
import com.web.encuestas.models.Encuesta;
import com.web.encuestas.services.EncuestaService;
import com.web.encuestas.tos.ToEncuesta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;

/**
 *
 * @author oscar
 */
@Named
@SessionScoped
public class Admin implements Serializable{
    
    private static final long serialVersionUID = 6529685098267757690L;
    
    private String username;
    private String ideuser;
    
    private List<ToEncuesta> encuestas;
    
    private List<ToEncuesta> selectedEncuestas;
    
    
    private ToEncuesta selectedEncuesta;
    
    private Boolean mostrarTabla;
    private Boolean mostrarPanel;
    
    @Inject
    private EncuestaService encuestaService;
    
    @PostConstruct
    public void init() {
        //this.setEncuestas(this.encuestasService.getEncuestas());
        //HttpSession session = SessionUtils.getSession();
        //session.setAttribute("username", user);
        //session.getAttribute(msg)
        username = SessionUtils.getUserName();
        ideuser = (String) SessionUtils.getUserId();
        this.mostrarTabla = false;
        this.mostrarPanel = false;
        //this.encuestas = this.encuestaService.getEncuestas();
        this.selectedEncuesta = new ToEncuesta();
        this.selectedEncuesta.setNombreusuario(username);
    }    
    
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
    public String volverInicio() {        
        this.mostrarTabla = false;
        return "admin";
    }
    
    
    public String consultarEncuestas(){
//        this.encuestaService.consultarEncuestas();
//        this.encuestas = this.encuestaService.getEncuestas();
//        this.mostrarTabla = true;
//        this.mostrarPanel = false;
        return "consultarEncuestas";
    }
    
//    public void openNew() {
//        this.selectedEncuesta = new ToEncuesta();
//    }
    
     public String crearEncuesta() {
         this.mostrarPanel = true;
         this.mostrarTabla = false;
        //this.selectedEncuesta = new ToEncuesta();
        //this.encuestas = this.encuestaService.getEncuestas();        
        return "crearEncuesta";
    }

    public String eliminarEncuesta() {
         this.mostrarPanel = true;
         this.mostrarTabla = false;
        //this.selectedEncuesta = new ToEncuesta();
        //this.encuestas = this.encuestaService.getEncuestas();        
        return "eliminarEncuesta";
    }  
     
    public String insertarEncuesta(){
        this.selectedEncuesta.setIdeusuario(Integer.valueOf(ideuser));
        System.out.println("TO ideusuario::::::::::::: " + this.selectedEncuesta.getIdeusuario());
        System.out.println("TO marcapc::::::::::::: " + this.selectedEncuesta.getIdemarcapc());
        this.encuestaService.setEncuesta(this.selectedEncuesta);
        this.encuestaService.insertarEncuesta();
        return "admin";
    }
    
    

    
    public List<ToEncuesta> getEncuestas() {
        return new ArrayList<>(encuestas);
    }    

    public ToEncuesta getSelectedEncuesta() {
        return selectedEncuesta;
    }
    public void setSelectedEncuesta(ToEncuesta selectedEncuesta) {
        this.selectedEncuesta = selectedEncuesta;
    }
    
    
    public List<ToEncuesta> getSelectedEncuestas() {
        return selectedEncuestas;
    }    
    public void setSelectedEncuestas(List<ToEncuesta> selectedEncuestas) {
        this.selectedEncuestas = selectedEncuestas;
    }
    
    
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

    public Boolean getMostrarTabla() {
        return mostrarTabla;
    }

    public void setMostrarTabla(Boolean mostrarTabla) {
        this.mostrarTabla = mostrarTabla;
    }

    public Boolean getMostrarPanel() {
        return mostrarPanel;
    }

    public void setMostrarPanel(Boolean mostrarPanel) {
        this.mostrarPanel = mostrarPanel;
    }
    
    
}
