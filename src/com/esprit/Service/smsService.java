/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.User;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PACKARDBELL
 */
public class smsService {
     Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;
     public List<String> getAll3() {
                    ArrayList<String> listUser = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select numero from User");
            while (rs.next()) {  
                listUser.add(
            rs.getString(1));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUser;  
    }
    }
    
