/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.tos;

import java.io.Serializable;

/**
 *
 * @author oscar
 */
public class ToEncuesta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idencuesta;
    private int ideusuario;
    private String nombreusuario;
    private String email;
    private String comentarios;
    private int idemarcapc;
    private String nombremarcapc;
    private String fecha;
    
    
    public ToEncuesta() {}
    
       
    public ToEncuesta(int idencuesta, int ideusuario, String nombreusuario, String email, 
            String comentarios, int idemarcapc, String nombremarcapc, String fecha) {
        this.idencuesta = idencuesta;
        this.ideusuario = ideusuario;
        this.nombreusuario = nombreusuario;
        this.email = email;
        this.comentarios = comentarios;
        this.idemarcapc = idemarcapc;
        this.nombremarcapc = nombremarcapc;
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

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
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

    public String getNombremarcapc() {
        return nombremarcapc;
    }

    public void setNombremarcapc(String nombremarcapc) {
        this.nombremarcapc = nombremarcapc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
