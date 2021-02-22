/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.services;

import com.web.encuestas.beans.utils.SessionUtils;
import com.web.encuestas.daos.connect.DataConnect;
import com.web.encuestas.models.Encuesta;
import com.web.encuestas.tos.ToEncuesta;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author oscar
 */
@Named
@SessionScoped//@ApplicationScoped
public class EncuestaService implements Serializable{
    
    private String ideuser;

    private ToEncuesta encuesta;
    
    List<ToEncuesta> encuestas;    
    
    @PostConstruct
    public void init() {
        ideuser = (String) SessionUtils.getUserId();        
        encuestas = new ArrayList<>();
        setEncuesta(new ToEncuesta());
//        encuestas.add(new Encuesta(1,4,"user4@correo.com","comentario user 4",100));
//        encuestas.add(new Encuesta(2,1,"user3@correo.com","comentario user 3",101));
//        encuestas.add(new Encuesta(3,2,"user2@correo.com","comentario user 2",102));
//        encuestas.add(new Encuesta(4,1,"user1@correo.com","comentario user 1",103));  
        //consultarEncuestas();
    }
    
    public void consultarEncuestas(){
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            
            String queryConsulta = "select enc.ide_encuesta ide_encuesta,"
                    + "enc.ide_usuario ide_usuario,us.nom_user nom_user,enc.email email, "
                    + "enc.comentarios comentarios,"
                    + "mpc.ide_marca_pc ide_marca_pc,mpc.nom_marca_pc nom_marca_pc,enc.fecha fecha "
                    + "from encuestas enc join usuarios us "
                    + "on enc.ide_usuario = us.ide_user "
                    + "join marcaspc mpc "
                    + "on enc.ide_marca_pc = mpc.ide_marca_pc "
                    + "where us.ide_user = ? ";            
            ps = con.prepareStatement(queryConsulta);
            ps.setString(1, ideuser);            
            //System.out.println("Se seteó SQL::::::::::::::::: \n" + queryConsulta);           

            ResultSet rs = ps.executeQuery();
            System.out.println("Se ejcutó consulta:::::::::::::::: \n" + queryConsulta);

            while (rs.next()) {
                 encuestas.add(
                         new ToEncuesta(rs.getInt("ide_encuesta"),rs.getInt("ide_usuario"),
                                rs.getString("nom_user"),rs.getString("email"),rs.getString("comentarios"),
                                rs.getInt("ide_marca_pc"),rs.getString("nom_marca_pc"),
                                String.valueOf(rs.getDate("fecha"))));                 
            }
        } catch (SQLException ex) {
            System.out.println("Encuestas error SQL Consultar-->" + ex.getMessage());            
        } finally {
            DataConnect.close(con);
        }        
    }
    
    public Boolean insertarEncuesta(){
        Connection con = null;
        Statement st = null;

        try {
            con = DataConnect.getConnection();
            
            st = con.createStatement();
            String query = "insert into encuestas "
                    + "(ide_usuario, email, comentarios, ide_marca_pc) "
                    + "values("+ ideuser +","
                    + "\""+getEncuesta().getEmail()+"\","
                    + "\""+getEncuesta().getComentarios()+"\","
                    + getEncuesta().getIdemarcapc()+")";
            
            System.out.println("SQL insertar::::::::::::::::::::::: \n" + query);
            
            st.execute(query);

            System.out.println("Se ejcutó Inserción:::::::::::::::::\n" + query);
           
        } catch (SQLException ex) {
            System.out.println("Encuestas error SQL Insertar-->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return true;
    }
    
    public Boolean eliminarEncuesta(){
        Connection con = null;
        Statement st = null;

        try {
            con = DataConnect.getConnection();
            
            st = con.createStatement();
            String query = "delete from encuestas "
                    + "where ide_usuario = " + ideuser + " and ide_encuesta = "                    
                    + getEncuesta().getIdencuesta();
            
            st.execute(query);

            System.out.println("Se ejcutó eliminar:::::::::::::::::\n" + query);
           
        } catch (SQLException ex) {
            System.out.println("Encuestas error SQL Eliminar-->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return true;
    }
    
    
    public List<ToEncuesta> getEncuestas() {
        return new ArrayList<>(encuestas);
    }
    
    public String getIdeuser() {
        return ideuser;
    }

    public void setIdeuser(String ideuser) {
        this.ideuser = ideuser;
    }

    public ToEncuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(ToEncuesta encuesta) {
        this.encuesta = encuesta;
    }
    
    
}
