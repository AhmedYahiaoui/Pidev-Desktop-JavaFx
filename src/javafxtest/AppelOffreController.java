package javafxtest;

import com.esprit.Entity.AppelOffre;
import com.esprit.Service.AppelOffreService;
import com.esprit.Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AppelOffreController implements Initializable {

    @FXML
    private TextField sujet;
    @FXML
    private TextField description;
    @FXML
    private DatePicker date;
    @FXML
    private Button bt;
    ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    UserService us= new UserService();
    

    @FXML
    private void ajoutAppeloffre(ActionEvent event) throws IOException {
        
  
        //UserService.userconnected=;

        if (valider()) {
            
            AppelOffreService es = new AppelOffreService();
            AppelOffre e = new AppelOffre(sujet.getText(), date.getValue().toString(), description.getText());
            es.createAo(e);
            sujet.clear();
            description.clear();
            System.out.println("Ajout effectué");
            items.clear();
        }
    }

    private boolean valider() {

        String errorMessage = "";

        if (sujet.getText() == null || sujet.getText().length() == 0) {
            errorMessage += "sujet invalide!\n";
        }

        if (date.getValue().toString() == null || date.getValue().toString().length() == 0) {
            errorMessage += "date non valide!\n";
        }
        if (description.getText() == null || description.getText().length() == 0) {
            errorMessage += "description non valive!\n";
        }
        if (errorMessage.length() == 0) {
            return true;

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur ,svp corriger");
            alert.setContentText(errorMessage);
            alert.show();
            return false;

        }

    }
}
