package javafxtest;

import com.esprit.Entity.Categorie;
import com.esprit.Entity.Recette;
import com.esprit.Service.CategorieService;
import com.esprit.Service.RecetteService;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AfficheRecetteController implements Initializable {
    @FXML
    private TableView<Recette> tableRecette;
    @FXML
    private TableColumn<Recette, String> id;
    @FXML
    private TableColumn<Recette, String> nom;
    @FXML
    private TableColumn<Recette, String> duree;
    @FXML
    private TableColumn<Recette, String> besoin;
    @FXML
    private TableColumn<Recette, String> prepation;
    @FXML
    private TableColumn<Recette, String> ingedient;
   // @FXML    
    //private TableColumn<Recette, ImageView> image;
    
    @FXML
    private TableColumn<Recette, Image> image;
    
    @FXML
    private AnchorPane anchorpane;
    RecetteService s = new RecetteService();

        
    


 RecetteService service = new RecetteService();
     ObservableList<Recette> listrecette = FXCollections.observableArrayList(service.getRecette_Admin());
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //
//       RecetteService service = new RecetteService();
//     ObservableList<Recette> listrecette = FXCollections.observableArrayList(service.getRecette_Admin());
  
    //
    tableRecette.setItems(listrecette);
    
    id.setCellValueFactory(new PropertyValueFactory("id"));
    nom.setCellValueFactory(new PropertyValueFactory("nom"));
    duree.setCellValueFactory(new PropertyValueFactory("duree"));
    besoin.setCellValueFactory(new PropertyValueFactory("besoin"));
    prepation.setCellValueFactory(new PropertyValueFactory("preparation"));
    ingedient.setCellValueFactory(new PropertyValueFactory("BN"));
    //image.setCellValueFactory(new PropertyValueFactory("nom_image"));
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

    tableRecette.setItems(listrecette);
    }
    @FXML
    private void SupprimerRecette(ActionEvent event) {
          
            Recette e = tableRecette.getSelectionModel().getSelectedItem();
            s.delete(e.id);
            listrecette.remove(e);
    }
    
    
        @FXML
    private void ModifierRecette(ActionEvent event) throws IOException {
        Recette r = tableRecette.getSelectionModel().getSelectedItem();
        
        ModifierRecetteController cont= new ModifierRecetteController(r);
        final FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("Modifier Recette.fxml"));
        loader.setController(cont);
        final Parent root = loader.load();
        AnchorPane pane = new AnchorPane();
        pane = (AnchorPane) tableRecette.getParent();
        pane.getChildren().setAll(root);
    }
}

