package com.esprit.Service;

import com.esprit.Iservice.ICommentaireService;
import com.esprit.Entity.Commentaire;
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

public class CommentaireService implements ICommentaireService {
 
    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    @Override
    public void createCommentair(Commentaire com) {
        try {
            String req = "INSERT INTO Commentaire (contenu,recette_id) VALUES (?,?)";
            
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1,com.getContenu());
            st.setInt(2,com.getRecette_id().getId());

            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Commentaire> getAll() {
        ArrayList<Commentaire> listCommentaires = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Commentaire");
            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " (" + rs.getString(2) + ")");
                listCommentaires.add(
            new Commentaire
                       (rs.getInt(1),
                        rs.getString(2)
                     //  rs.getInt(3)
                       )
                );
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCommentaires;
    }

    @Override
    public void update(Commentaire com) {
        try {
            String req = "UPDATE `Commentaire` SET `conetu` = ?  WHERE `id` = ?";
            
            PreparedStatement st = conn.prepareStatement(req);
            
            st.setString(1, com.getContenu());
            st.setInt(2, com.getId());

            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        @Override
    public void delete(int id) {
        try {
            String req= "DELETE FROM `Commentaire` WHERE `Commentaire`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public List<Commentaire> AfficherCommentaire(int r) {
        ArrayList<Commentaire> listN = new ArrayList<Commentaire>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select contenu from commentaire WHERE commentaire.`recette_id` = '" + r + "'");
            while (rs.next()) {
                //System.out.println("id " + rs.getString(1) + "contenu  " + rs.getString(4) );
                listN.add(new Commentaire(
                        rs.getString(1)
                        //rs.getInt(3)
                        ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Recette.class.getName()).log(Level.SEVERE, null, ex);
        } return listN;   }

    
}
