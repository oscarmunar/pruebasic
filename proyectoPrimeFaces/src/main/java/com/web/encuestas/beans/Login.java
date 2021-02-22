/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.beans;

import com.web.encuestas.beans.utils.SessionUtils;
import com.web.encuestas.daos.LoginDAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


@Named
@ViewScoped//@RequestScoped//@SessionScoped
public class Login implements Serializable{
    
    private String pwd;
    private String msg;
    private String user;
    private String ide;
    
    
    @PostConstruct
    public void init() {
        //this.setEncuestas(this.encuestasService.getEncuestas());
    }
    
    
    public String validateUsernamePassword() {
        int idevalidado = LoginDAO.validate(user, pwd);
        if (idevalidado != 0) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            session.setAttribute("ideuser", String.valueOf(idevalidado));
            //session.getAttribute(msg)
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Passowrd",
                                "Please enter correct username and Password"));
            return "login";
        }
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }    
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }
    
}
