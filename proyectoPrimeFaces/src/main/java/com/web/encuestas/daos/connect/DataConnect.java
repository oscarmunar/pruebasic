/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.daos.connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author oscar
 */
public class DataConnect {
    
    public static Connection getConnection() {
        
        String url="jdbc:mysql://localhost:3306/encuestasdb";
        String user = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Class.forName("com.mysql.jdbc.Driver");            
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");
            Connection con = DriverManager.getConnection(url,user,password);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->"
                            + ex.getMessage());
            return null;
        }
    }
    
    public static void close(Connection con) {
        try {
                con.close();
        } catch (Exception ex) {
        }
    }
}
