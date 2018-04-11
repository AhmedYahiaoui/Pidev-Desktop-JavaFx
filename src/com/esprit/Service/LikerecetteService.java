/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.Likerecette;
import com.esprit.Entity.Recette;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class LikerecetteService {
        Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

   // @Override
    public void ajouteLike(Likerecette com) {
        try {
            String req = "INSERT INTO likerecette (valeur,recette_id) VALUES (?,?)";
            
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1,com.getValeur());
            st.setInt(2,com.getRecette_id().getId());
            //st.setInt(2,com.getUser_id().getId());

            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LikerecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //////////////////////
    
        public void ajouteLike2(Likerecette com,int user) {
        try {
            String req = "INSERT INTO likerecette (valeur,recette_id) VALUES (?,?)";
            
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1,com.getValeur());
            st.setInt(2,com.getRecette_id().getId());
            //st.setInt(2,com.getUser_id().getId());

            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LikerecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //////////////////////
    
        //@Override
    public List<Likerecette> get_user_like(int id) {
        ArrayList<Likerecette> listeUser = new ArrayList<>();
        try {
            stmt = conn.createStatement();
        //    ResultSet rs = stmt.executeQuery("Select `user_id` from Likerecette Where ");
     ResultSet rs = stmt.executeQuery("Select `user_id` from Likerecette where Likerecette.`id`='" + String.valueOf(id));
        while (rs.next()) {
                listeUser.add(
                        new Likerecette(
                                rs.getInt(1)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUser;
    }
    
    

    ////
        //@Override
    public void delete(int id,int user) {
        try {
            String req = "DELETE FROM `Likerecette` WHERE `Likerecette`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
