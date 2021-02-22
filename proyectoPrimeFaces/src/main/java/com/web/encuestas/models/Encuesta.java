/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.models;

import java.io.Serializable;

/**
 *
 * @author oscar
 */
public class Encuesta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idencuesta;
    private int ideusuario;
    private String email;
    private String comentarios;
    private int idemarcapc;
    private String fecha;
    
    
    public Encuesta() {}
    
    public Encuesta(int idencuesta, int ideusuario, String email, String comentarios, int idemarcapc, String fecha) {
        this.idencuesta = idencuesta;
        this.ideusuario = ideusuario;
        this.email = email;
        this.comentarios = comentarios;
        this.idemarcapc = idemarcapc;
        this.fecha = fecha;
    }
    

    public int getIdencuesta() {
        return idencuesta;
    }

    public void setIdencuesta(int idencuesta) {
        this.idencuesta = idencuesta;
    }

    public int getIdeusuario() {
        return ideusuario;
    }

    public void setIdeusuario(int ideusuario) {
        this.ideusuario = ideusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getIdemarcapc() {
        return idemarcapc;
    }

    public void setIdemarcapc(int idemarcapc) {
        this.idemarcapc = idemarcapc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }   
    
    
    
    
}
