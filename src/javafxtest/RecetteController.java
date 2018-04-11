/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Entity.Recette;
import com.esprit.Service.RecetteService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RecetteController implements Initializable {

    private TableView<Recette> tableimage;
    @FXML
    private AnchorPane anchorpane;
    private TableColumn<Recette, Image> image;
        
    RecetteService s = new RecetteService();
    RecetteService service = new RecetteService();
    
     ObservableList<Recette> listrecette = FXCollections.observableArrayList(service.getRecette_Admin());
    @FXML
    private VBox vboxRecette;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    tableimage.setItems(listrecette);
        image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Recette, Image>, ObservableValue<Image>>() {
            public ObservableValue<Image> call(TableColumn.CellDataFeatures<Recette, Image> p) {
                //System.out.println("C:\\wamp64\\www\\SoukLemdina2\\web\\uploads\\images"+p.getValue().getNom_image());
                return new SimpleObjectProperty<>(
new Image("file:C:\\xampp\\htdocs\\PiDev\\web\\images\\" + p.getValue().getNom_image(), 100, 100, true, true, true));
            }
        });
            image.setCellFactory(new Callback<TableColumn<Recette, Image>, TableCell<Recette, Image>>() {

            public TableCell<Recette, Image> call(TableColumn<Recette, Image> p) {
                return new TableCell<Recette, Image>() {

                    @Override
                    protected void updateItem(Image i, boolean empty) {
                        super.updateItem(i, empty);
                        setText(null);
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        ImageView imageView = (i == null || empty) ? null : ImageViewBuilder.create().image(i).build();
                        setGraphic(imageView);
                    }
                };
            }
        });
            
            
            
    }    

    private void DetailRecette(ActionEvent event) throws IOException {
          
            Recette e = tableimage.getSelectionModel().getSelectedItem();
//            s.AfficherRecetteId(e.id);
            //listrecette.(e);
            Recette r = tableimage.getSelectionModel().getSelectedItem();
        
            DetailRecetteController cont= new DetailRecetteController(r);
  
final FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("DetailRecette.fxml"));
        loader.setController(cont);
        final Parent root = loader.load();
        AnchorPane pane = new AnchorPane();
        pane = (AnchorPane) tableimage.getParent();
        pane.getChildren().setAll(root);
            
    }

    @FXML
    private void hundleCategorie(ActionEvent event) {
                makeFadeOut();}
       private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new RecetteController.EventHandlerImpl());
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
    
/////////////
    @FXML
    private void logout(ActionEvent event) throws IOException {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
//
    /*
    @FXML
    private void hundleHome(javafx.event.ActionEvent event) {
        makeFadeOuthome();
    }

    private void makeFadeOuthome() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImpl());
        fadeTransition.play();
    }

    private void loadNextScrenhome() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {
        }
    }

    private class EventHandlerImplhome implements EventHandler<javafx.event.ActionEvent> {

        public EventHandlerImplhome() {
        }

        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScren();
        }
    }
*/
    
    ///////////////// TO --> Home ///////////////////// 
    /*
    @FXML
    private void hundleHome(javafx.event.ActionEvent event) {
        makeFadeOutHome();
    }

    private void makeFadeOutHome() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandlerImpl());
        fadeTransition.play();
    }

    private void loadNextScrenHome() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            //secondView = (StackPane) 
            Scene newScene = new Scene(secondView);
            Stage curStage = (Stage) anchorpane.getScene().getWindow();
            curStage.setScene(newScene);
        } catch (IOException ex) {
        }
    }

    private class EventHandlerImplHome implements EventHandler<javafx.event.ActionEvent> {
        public EventHandlerImplHome() {
        }
        @Override
        public void handle(javafx.event.ActionEvent event) {
            loadNextScrenHome();
        }
    }
    */
    
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
            Parent secondView = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
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
    
    
}