package com.esprit.Service;
import com.esprit.Iservice.ICategorieService;
import com.esprit.Iservice.IRecetteService;
import com.esprit.Entity.Categorie;
import com.esprit.Entity.Recette;
import com.esprit.Entity.User;
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
import javafx.scene.control.TableView;

public class CategorieService implements ICategorieService {
 
    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;
    @Override
    public void createCategorie(Categorie cat) {
        try {
            String req = "INSERT INTO Categorie (nom,image) VALUES (?,?)";
            
            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, cat.getNom());
            st.setString(2, cat.getImage());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Categorie> getAll() {
        
        ArrayList<Categorie> listCategories = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Categorie");
            while (rs.next()) {
                listCategories.add(
            new Categorie
                       (rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("image")
                       ));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategories;
    }
    
    @Override
    public List<Categorie> getAllName() {
        ArrayList<Categorie> listCategories = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select nom from Categorie");
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                listCategories.add(new Categorie
        (rs.getString("nom")));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategories;
    }   

    @Override
    public void update(Categorie cat) {
        try {
            String req = "UPDATE `Categorie` SET `nom` = ? , `image` = ? WHERE `id` = ?";            
            PreparedStatement st = conn.prepareStatement(req);
            
            st.setString(1, cat.getNom());
            st.setString(2, cat.getImage());
            st.setInt(3, cat.getId());      

            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
