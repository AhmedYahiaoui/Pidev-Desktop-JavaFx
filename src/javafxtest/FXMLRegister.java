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
import com.esprit.Service.UserService;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.util.Duration;
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
    
    @FXML
    private AnchorPane rootanchor;
    
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

        UserService es = new UserService();
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
    
    
        @FXML
    private void hundlelogin(javafx.event.ActionEvent event) {
        makeFadeOut();}
    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootanchor);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImpl());
        fadeTransition.play();
    }
    private void loadNextScren() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) rootanchor.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {}
    }
    private class EventHandlerImpl implements EventHandler<javafx.event.ActionEvent> {
        public EventHandlerImpl() {
        }
        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScren();}}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
