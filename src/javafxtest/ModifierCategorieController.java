package javafxtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import com.esprit.Entity.Categorie;
import com.esprit.Entity.Recette;
import com.esprit.Service.CategorieService;
import com.esprit.Service.RecetteService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class ModifierCategorieController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField image;
    @FXML
    private AnchorPane anchorepane;
    Categorie u;

    File file;
    Stage stage;

      public ModifierCategorieController(Categorie u) {
          this.u = u;
      }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
           CategorieService us= new CategorieService();
        nom.setText(u.getNom());
        image.setText(u.getImage());

    }
    
        @FXML
    public void ModifierCategorie(ActionEvent event) {
        CategorieService us =new CategorieService();
        us.update(new Categorie(u.id,nom.getText(), image.getText()));
        
        
        
        
            Notifications notificationBuilder = Notifications.create()
                .title("Salut Admin")
                .text("modification efféctuer")
                 .graphic(null)
                .hideAfter(Duration.seconds(10))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    System.out.println("Exemple(Question validée)");
                        }
                });
         notificationBuilder.darkStyle();
         notificationBuilder.showConfirm();   
    }

    @FXML
    private void ajoutPhoto(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file!=null) {
            try {
                String img = file.toURI().toURL().toString();
                System.out.println(img);
                System.out.println("jawek béhi");
                image.setText(img);
            } catch (MalformedURLException ex) {
                Logger.getLogger(AjouteCategorieController.class.getName()).log(Level.SEVERE, null, ex);
            }
         } 
    }
}
