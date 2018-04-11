package com.esprit.Service;

import com.esprit.Iservice.IRecetteService;
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

public class RecetteService implements IRecetteService {

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    @Override
    public void createRecette(Recette r) {
        try {
            String req = "INSERT INTO Recette (nom,duree,besoin,preparation,BN,nom_image) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, r.getNom());
            st.setInt(2, r.getDuree());
            st.setString(3, r.getBesoin());
            st.setString(4, r.getPreparation());
            st.setString(5, r.getBN());
            st.setString(6, r.getNom_image());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Recette> getAll() {
        ArrayList<Recette> listRecettes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Recette");
            while (rs.next()) {
            //    System.out.println(rs.getString(1) + " (" + rs.getInt(2) + ")" + " (" + rs.getString(3) + ")"
             //           + " (" + rs.getString(4) + ")" + " (" + rs.getString(5) + ")" + "(" + rs.getString(6) + ")"
             //   );
                listRecettes.add(
                        new Recette(
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRecettes;
    }

    @Override
    public void update(Recette r) {
        try {
            String req = "UPDATE `recette` SET `nom` = ?, "
                    + "`duree`= ?,`besoin`= ?,`preparation`= ?,`BN`= ?,`nom_image`= ?"
                    + " WHERE `id` = ?";
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, r.getNom());
            st.setInt(2, r.getDuree());
            st.setString(3, r.getBesoin());
            st.setString(4, r.getPreparation());
            st.setString(5, r.getBN());
            st.setString(6, r.getNom_image());
            st.setInt(7, r.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String req = "DELETE FROM `recette` WHERE `recette`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Recette> get_Nom_Recette() {
        ArrayList<Recette> listRecettes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `nom` FROM `recette`");
            while (rs.next()) {
                listRecettes.add(
                        new Recette(
                                rs.getString(1)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRecettes;
    }

    @Override
    public List<Recette> getRecette_Admin() {
        ArrayList<Recette> listRecettes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select `id`,`nom`,`duree`,`besoin`,`preparation`,`BN`,`nom_image`,`likee`,`dislike` from Recette");
            while (rs.next()) {
                listRecettes.add(
                        new Recette(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getInt(8),
                                rs.getInt(9)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRecettes;
    }

    @Override
    public Recette AfficherRecetteId(int id) {
        ArrayList<Recette> list = new ArrayList<Recette>();
        Recette u = new Recette(id);
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select `id_categorie`,`nom`,`duree`,`besoin`,`preparation`,"
                    + "`BN`,`nom_image` from recette where recette.`id`='" + id + "'");
            while (rs.next()) {
               // u.setId_categorie(rs.getInt(1));
                u.setNom(rs.getString(1));
                u.setDuree(rs.getInt(2));
                u.setBesoin(rs.getString(3));
                u.setPreparation(rs.getString(4));
                u.setBN(rs.getString(5));
                u.setNom_image(rs.getString(5));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public List<Recette> get_image_Recette() {
        ArrayList<Recette> listRecettes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `nom_image` FROM `recette`");
            while (rs.next()) {
                listRecettes.add(
                        new Recette(
                                rs.getString(1)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRecettes;
    }

    @Override
    public List<Recette> getAll2() {
        ArrayList<Recette> listRecettes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `recette`");
            while (rs.next()) {
                listRecettes.add(
                        new Recette(
                                rs.getString(1)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRecettes;
    }

    @Override
    public Recette AfficherRecetteCategorie(int id) {
        ArrayList<Recette> list = new ArrayList<Recette>();
        Recette u = new Recette(id);
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select `nom`,`duree`,`besoin`,`preparation`,"
                    + "`BN`,`nom_image` From recette where categorie.`id`=recette.`id_categorie`");
            while (rs.next()) {
                u.setNom(rs.getString(1));
                u.setDuree(rs.getInt(2));
                u.setBesoin(rs.getString(3));
                u.setPreparation(rs.getString(4));
                u.setBN(rs.getString(5));
                u.setNom_image(rs.getString(5));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    
    
    
    
   
    
        
            public void updateLike(Recette r) {
        try {
            String req = "UPDATE `recette` SET `likee` = ?,  WHERE `id` = ?";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, r.getLikee()+1);
            st.setInt(2, r.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
