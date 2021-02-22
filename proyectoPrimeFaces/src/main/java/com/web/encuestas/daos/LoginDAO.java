/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.encuestas.daos;

import com.web.encuestas.daos.connect.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class LoginDAO {
    
    public static int validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select ide_user,nom_user,pass_user from usuarios where nom_user = ? and pass_user = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                    //result found, means valid inputs
                    return rs.getInt("ide_user");
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return 0;
        } finally {
            DataConnect.close(con);
        }
        return 0;
    }
    
    
    
}
