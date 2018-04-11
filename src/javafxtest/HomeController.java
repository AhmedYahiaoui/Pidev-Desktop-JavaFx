package javafxtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HomeController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private Button stat2;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void Ajout(ActionEvent event) {
        load("AppelOffre");
    }

    @FXML
    private void Affiche(ActionEvent event) {
        load("afficheappel");
    }
        @FXML
    private void affichetouts(ActionEvent event) {
                load("ToutlesAppel");
    }
    
    
    private void load(String ui)
    {
        Parent root =null ;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (Exception e) {
        }
     
        borderpane.setCenter(root);
    }

    @FXML
    private void lesdemandes(ActionEvent event) {
        load("Lesdemandes");
    }

    @FXML
    private void mesparticipations(ActionEvent event) {
        load("MesParticipation");
    }

    @FXML
    private void stat(ActionEvent event) {
        load("stat");
    }

    @FXML
    private void sta2(ActionEvent event) {
         load("stat2");
    }


}
