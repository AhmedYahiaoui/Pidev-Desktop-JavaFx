/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.Likerecette;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
}
