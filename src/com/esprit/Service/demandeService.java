/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.demandeoffre;
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
 * @author PACKARDBELL
 */
public class demandeService {

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    public void participerOffre(demandeoffre e) {
        try {

            String req = "INSERT INTO demandeoffre (username,appel_id,statut) VALUES (?,?,?)";
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1,e.getUser().getUsername());
            st.setInt(2, e.getAppel().getId_owner());
            st.setInt(3, e.getStatut());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<demandeoffre> getAll4() {
        ArrayList<demandeoffre> listdemande = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * appeldoffre");
            while (rs.next()) {
                //System.out.println(rs.getString(2) + " (" + rs.getString(3) + ")");
                listdemande.add(new demandeoffre(
                        rs.getString("user_id.username"),
                        rs.getInt("appel_id.sujet"),
                        rs.getInt("statut")
                       
                ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listdemande ;
    }
    
    
    
    
    
    
}
