package javafxtest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NewFXMain extends Application {
    public static int userConnected=6;
    
    @Override
    public void start(Stage stage) {
   Parent root;
        try {
           // root = FXMLLoader.load(getClass().getResource("RecetteFront.fxml"));
            //Parent 
            root = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
             Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }

//Parent root = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));  
//Parent root = FXMLLoader.load(getClass().getResource("ListeRecetteVrai.fxml"));  
//Parent root = FXMLLoader.load(getClass().getResource("HomeAdmin.fxml"));  

       
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}