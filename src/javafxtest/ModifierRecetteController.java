package javafxtest;

import com.esprit.Entity.Recette;
import com.esprit.Service.RecetteService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ModifierRecetteController implements Initializable {

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
    Recette u;

    public ModifierRecetteController(Recette u) {
        this.u = u;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RecetteService us = new RecetteService();
        nom.setText(u.getNom());
        preparation.setText(u.getPreparation());
        ingredients.setText(u.getBN());
        image.setText(u.getNom_image());
        Besoin.setText(u.getBesoin());
        duree.setText(Integer.toString(u.getDuree()));
    }

    @FXML
    private void ajoutPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
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

    @FXML
    @SuppressWarnings("empty-statement")
    public void ModifierRecette(ActionEvent event) throws IOException {
        RecetteService us = new RecetteService();
        /*if(nom.getText().equals(""))
            u.setNom(u.getNom());
        else u.setNom(nom.getText());
        if(preparation.getText().equals(""))
            u.setPreparation(u.getPreparation());
        else u.setPreparation(preparation.getText());
        if(ingredients.getText().equals(""))
            u.setBN(u.getBN());
        else u.setBN(ingredients.getText());
        if(Besoin.getText().equals(""))
            u.setBesoin(u.getBesoin());
        else u.setBesoin(Besoin.getText());
        if(image.getText().equals(""))
            u.setNom_image(u.getNom_image());
        else u.setNom_image(image.getText());
        if(duree.getText().equals(""))
            u.setDuree(u.getDuree());
        else u.setDuree(Integer.parseInt(duree.getText()));
         */
        us.update(new Recette(u.id, nom.getText(), Integer.parseInt(duree.getText()),
                 Besoin.getText(), preparation.getText(), ingredients.getText(), image.getText()));
    }
}
