package javafxtest;

import com.esprit.Entity.Categorie;
import com.esprit.Service.CategorieService;
import com.esprit.Service.RecetteService;
import com.esprit.Service.UserServicee;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CategorieController implements Initializable {

    @FXML
    AnchorPane anchorpane;

    @FXML
    private ListView<String> list_categorie;
    ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    TableView<String> table = new TableView<>();
    //@FXML
    //private Button choisie;

///////////////// TO Nos Patteserie ///////////////////// 
    @FXML
    private void hundleHome(javafx.event.ActionEvent event) {
        makeFadeOut();
    }

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
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {
        }
    }

    private class EventHandlerImpl implements EventHandler<javafx.event.ActionEvent> {

        public EventHandlerImpl() {
        }

        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScren();
        }
    }

///////////////// TO Nos Patteserie ///////////////////// 
    @FXML
    private void hundlePatteserie(javafx.event.ActionEvent event) {
        makeFadeOutRecette();
    }

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
            Parent secondView = FXMLLoader.load(getClass().getResource("recette.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {
        }
    }

    private class EventHandlerImplRecette implements EventHandler<javafx.event.ActionEvent> {

        public EventHandlerImplRecette() {
        }

        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScrenRecette();
        }
    }

//////////////////BACK to LOG OUT ///////////////////////
    @FXML
    private void LoginAction(javafx.event.ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
///////////////////////////////////////////////////////////
 
        @Override
    public void initialize(URL url, ResourceBundle rb) {

        CategorieService es = new CategorieService();
        RecetteService rs =new RecetteService();

        // table.getColumns().addAll(one,two);
        // table.setItems(items);
        list_categorie.setItems(items);
        es.getAll().forEach(a -> items.add(a.getNom()));
//list_categorie.getSelectionModel().select(items.size() - 1);        

    }
    
    @FXML
    private void buttonclicked(javafx.event.ActionEvent event){
    String message="";
        ObservableList<String>categories;
        categories= list_categorie.getSelectionModel().getSelectedItems();
        RecetteService rs =new RecetteService();
        
        for(String m: categories){
            
        list_categorie.setItems(items);
        //rs.getAll().forEach(a -> items.add(a.getNom()));
       // rs.getRecette_categorie().forEach(e->e.getNom());
        
        }
        System.out.println(items);
    }


}
