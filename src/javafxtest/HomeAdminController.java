/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class HomeAdminController implements Initializable {

    

    @FXML
    private Label user;
    @FXML
    private Label commentaire;
    @FXML
    private Button ajoute_categorie;
    @FXML
    private Button modif_categorie;
    @FXML
    private Button ajoute_recette;
    @FXML
    private Button affiche_recette;
    @FXML
    private BorderPane borderpane;
    @FXML
    private AnchorPane anchorpane;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void user(MouseEvent event) {
    }

    @FXML
    private void commentaire(MouseEvent event) throws IOException {
            loadUI("Commentaire");

    }

    @FXML
    private void ajout_categorie(MouseEvent event) {
        loadUI("ajoute categorie");

    }

    @FXML
    private void affiche_categorie(MouseEvent event) {
        loadUI("affiche categorie");

    }

    @FXML
    private void ajout_recette(MouseEvent event) {
        loadUI("ajout recette");

    }

    @FXML
    private void affiche_recette(MouseEvent event) {
        loadUI("affiche recette");

    }

    @FXML
    private void logout(MouseEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
        private void loadUI(String ui)
    {
    Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(HomeAdminController.class.getName()).log(Level.SEVERE,null,e);
        }
        borderpane.setCenter(root);
    }
}
