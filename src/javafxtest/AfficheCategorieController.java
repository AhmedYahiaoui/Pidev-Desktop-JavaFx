package javafxtest;

import com.esprit.Entity.Categorie;
import com.esprit.Service.CategorieService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;

import javafx.util.Callback;


public class AfficheCategorieController implements Initializable {
    

    @FXML
    private TableColumn<Categorie, String> nom;
    @FXML
private TableColumn<Categorie, Image> image;
    
    @FXML
    private TableView<Categorie> tableCategorie;
    @FXML
    private AnchorPane anchorpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    CategorieService service = new CategorieService();
    ObservableList<Categorie> listcategorie = FXCollections.observableArrayList(service.getAll());
        
       tableCategorie.setItems(listcategorie);
       nom.setCellValueFactory(new PropertyValueFactory("nom"));     
       image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Categorie, Image>, ObservableValue<Image>>() {
            public ObservableValue<Image> call(TableColumn.CellDataFeatures<Categorie, Image> p) {
                return new SimpleObjectProperty<>(
new Image("file:C:\\xampp\\htdocs\\PiDev\\web\\images\\" + p.getValue().getImage(), 100, 100, true, true, true));
            }
        });
            image.setCellFactory(new Callback<TableColumn<Categorie, Image>, TableCell<Categorie, Image>>() {
            public TableCell<Categorie, Image> call(TableColumn<Categorie, Image> p) {
                return new TableCell<Categorie, Image>() {
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
       
       
       
       
    tableCategorie.setItems(listcategorie);

    }
    
    
        @FXML
    private void ModifierCategorie(ActionEvent event) throws IOException {            
        
        Categorie r = tableCategorie.getSelectionModel().getSelectedItem();
        
        ModifierCategorieController cont= new ModifierCategorieController(r);
        final FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("modifierCategorie.fxml"));
        loader.setController(cont);
        final Parent root = loader.load();
        AnchorPane pane = new AnchorPane();
        pane = (AnchorPane) tableCategorie.getParent();
        pane.getChildren().setAll(root);
            
    }
    
    
}
