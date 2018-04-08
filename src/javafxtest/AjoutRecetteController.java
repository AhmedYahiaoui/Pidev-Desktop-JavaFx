package javafxtest;

import com.esprit.Entity.Recette;
import com.esprit.Service.RecetteService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class AjoutRecetteController implements Initializable {

    @FXML
    private TextArea preparation;
    @FXML
    private TextField nom;
    @FXML
    private TextField duree;
    @FXML
    private TextField ingredients;
    @FXML
    private TextField image;   
    @FXML   
    private TextField Besoin;

    File file;
    Stage stage;

    @FXML
    private void AjoutCategorie(ActionEvent event) {

        RecetteService es = new RecetteService();
        Recette e =new Recette(nom.getText(),Integer.parseInt(duree.getText()),
                Besoin.getText(),preparation.getText(),ingredients.getText(),image.getText());
        
        es.createRecette(e);
        
        //Notification
        Notifications notificationBuilder = Notifications.create()
                
                .title("Salut Admin")
                .text("votre Recette a été ajouté")
                 .graphic(null)
                .hideAfter(Duration.seconds(10))
                .position(Pos.BOTTOM_RIGHT)
                .onAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                        }
                });
         notificationBuilder.darkStyle();
         notificationBuilder.showConfirm();
         
         // clear the textfield ba3ed l khedma
         nom.clear();
         preparation.clear();
         duree.clear();
         ingredients.clear();
         Besoin.clear();
        image.clear();
    }
    

    
    @FXML
    private void ajoutPhoto(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
            String path = "C:/xampp/htdocs/PiDev/web/images/";

     /*   String path = "C:/wamp64/www/PIDEV/web/uploads/";
            
                Files.copy(file.toPath(),
                        (new File(path + file.getName())).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
*/
        file = fileChooser.showOpenDialog(stage);
        if (file!=null) {
            try {
                String img = file.getName().toString();
                System.out.println(img);
                System.out.println("jawek béhi");
                image.setText(img);
                Files.copy(file.toPath(),
                        (new File(path + file.getName())).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(AjouteCategorieController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }    
    }
             
    void setStage(Stage primaryStage) {
        this.stage = primaryStage;  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
