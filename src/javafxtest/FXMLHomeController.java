package javafxtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class FXMLHomeController implements Initializable {
        
    @FXML
    private BorderPane anchorpane;
    
    //////////////////CATEGORIE////////////////////
    @FXML
    private void hundleCategorie(javafx.event.ActionEvent event) {
        makeFadeOut();}
       private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImpl());
        fadeTransition.play();
    }
    private void loadNextScren() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("categorie.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {}
    }
    private class EventHandlerImpl implements EventHandler<javafx.event.ActionEvent> {
        public EventHandlerImpl() {
        }
        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScren();
        }}     
    /////////////////VERS RECETTE/////////////////////
    @FXML
    private void hundleRecette(javafx.event.ActionEvent event) {
        makeFadeOutRecette();}
       private void makeFadeOutRecette() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImplRecette());
        fadeTransition.play();
    }
    private void loadNextScrenRecette() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("RecetteFront.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {}
    }
    private class EventHandlerImplRecette implements EventHandler<javafx.event.ActionEvent> {
        public EventHandlerImplRecette() {
        }
        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScrenRecette();
        }}
            
    @FXML
    private void LoginAction(javafx.event.ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
        @FXML
    private void accueil(ActionEvent event) throws IOException {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        }
}

   

