/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.beans.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oscar
 */
public class SessionUtils {
    
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                        .getExternalContext().getRequest();
    }
    
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }
    
    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("ideuser");
        else
            return null;
    }
    
}
