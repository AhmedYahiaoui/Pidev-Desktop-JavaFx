package javafxtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FxmlController implements Initializable {

    @FXML
    private AnchorPane rootanchor;
       @FXML
    private BorderPane borderPane; 
    
    
    
    
        @FXML
    private void hundlePage(javafx.event.ActionEvent event) {
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
            Parent secondView = FXMLLoader.load(getClass().getResource("fxml_1.fxml"));
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
        // TODO
    }    
    
}
