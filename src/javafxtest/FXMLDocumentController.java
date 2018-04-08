package javafxtest;
import com.esprit.Entity.User;
import com.esprit.Service.RecetteService;
import com.esprit.Service.UserServicee;
import com.esprit.utils.DataSource;
import java.awt.Button;
import java.awt.Dialog;
//import java.awt.TextField;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.RootPaneUI;
public class FXMLDocumentController implements Initializable {
    
    private Connection connection;
    
    @FXML
    private AnchorPane rootanchor;
    @FXML
    private TextField login;
    @FXML
    private TextField pass;
    
    @FXML
    private void LoginAction(javafx.event.ActionEvent event) throws IOException {
    
        
        
        UserServicee service =new UserServicee();
        
        if (pass.getText().equals("admin") && (login.getText().equals("admin"))) {
            JOptionPane.showMessageDialog(null, " Bienvenu Admin ");
        
            
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("HomeAdmin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        } else 
        if (pass.getText().equals("client") && (login.getText().equals("client"))) {
                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Votre Login incorrect ");
        }
        pass.clear();
        login.clear();
    }
    // Navigation entre deux pages
    @FXML
    private void hundleRegister(javafx.event.ActionEvent event) {
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
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
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
/*
    @FXML
    private void toregister(javafx.event.ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
   }
    */ 