package javafxtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.esprit.Entity.User;
import com.esprit.Service.UserServicee;
import javafx.scene.control.TextField;
import javax.print.DocFlavor;
import javax.swing.JOptionPane;

public class FXMLRegister implements Initializable {

    ToggleGroup group = new ToggleGroup();
    @FXML
    RadioButton r1 = new RadioButton("visiterur");

    @FXML
    RadioButton r2 = new RadioButton("client pro");

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    
    String roles;

    @FXML
    private void AjoutUser(ActionEvent event) {
        r1.setToggleGroup(group);
        r1.setSelected(true);
        r2.setToggleGroup(group);

        if (r1.isSelected()) {
            roles = "Visiteur";
        } else if (r2.isSelected()) {
            roles = "client pro";
        }

        UserServicee es = new UserServicee();
        User e = new User();

        e.setUsername(username.getText());
        e.setEmail(email.getText());
        e.setPassword(password.getText());
        e.setRoles(roles.toString());

        if (username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vérifier votre Formulaire");
        } else {
            es.createUser(e);
            username.clear();
            email.clear();
            password.clear();
            System.out.println("Ajout effectué");
            JOptionPane.showMessageDialog(null, "Votre inscription est terminé avec succée");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
