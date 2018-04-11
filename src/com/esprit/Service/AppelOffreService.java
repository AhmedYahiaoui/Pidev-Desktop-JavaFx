/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Iservice.IAppeloffreService;
import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.User;
//import static com.esprit.Service.UserService.userconnected;
//import javax.sql.DataSource;
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
public class AppelOffreService implements IAppeloffreService {

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    public void createAo(AppelOffre e) {
        try {
            String req = "INSERT INTO appeldoffre (sujet,datemax,description) VALUES (?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, e.getDate());
            st.setString(2, e.getSujet());
            st.setString(3, e.getDescription());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AppelOffre> getAll() {
        ArrayList<AppelOffre> listAppelOffres = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from appeldoffre");
            while (rs.next()) {
                //System.out.println(rs.getString(2) + " (" + rs.getString(3) + ")");
                listAppelOffres.add(new AppelOffre(rs.getInt("id"),
                        rs.getString("datemax"),
                        rs.getString("sujet"),
                        rs.getString("description")
                ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAppelOffres;
    }

    public void update(AppelOffre a) {
        try {
            String req = "UPDATE `appeldoffre` SET `sujet` = ?, `description`= ?, `datemax`= ? WHERE `id` = ?";
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, a.getSujet());
            st.setString(2, a.getDescription());
            st.setString(3, a.getDate());

            st.setInt(4, a.getId());

            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AppelOffre> getAll2() {
        ArrayList<AppelOffre> listAppelOffres = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from appeldoffre");
            while (rs.next()) {
                //System.out.println(rs.getString(2) + " (" + rs.getString(3) + ")");
                listAppelOffres.add(new AppelOffre(rs.getInt("id"),
                        rs.getString("datemax"),
                        rs.getString("sujet"),
                        rs.getString("description"),
                        rs.getInt("statut")
                       
                ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAppelOffres;
    }

    @Override
    public void delete(int id) {
        try {
            String req = "DELETE FROM `appeldoffre` WHERE `appeldoffre`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AppelOffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
