/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;


import com.esprit.Service.LikerecetteService;
import com.esprit.Service.RecetteService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class RecetteFrontController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private VBox vboxRecette;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirRecette();
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void hundleCategorie(ActionEvent event) {
    }

    @FXML
    private void hundlePatteserie(ActionEvent event) {
    }
    
    public void remplirRecette(){
        vboxRecette.getChildren().clear();
        vboxRecette.setSpacing(20);
        
        RecetteService rs=new RecetteService();
          rs.getAll().forEach(e->{
            try {
                AnchorPane ap=FXMLLoader.load(getClass().getResource("UneRecette.fxml"));
                TextArea preparation=(TextArea) ap.getChildren().get(11);
                TextField besoin= (TextField) ap.getChildren().get(10);
                TextField ing= (TextField) ap.getChildren().get(12);
                TextField duree= (TextField) ap.getChildren().get(13);
                ImageView img=(ImageView) ap.getChildren().get(1);
                
                preparation.setText(e.getPreparation());
                besoin.setText(e.getBesoin());
                ing.setText(e.getBN());
                duree.setText(String.valueOf(e.getDuree()));
                Image imgTemp = new Image("file:C:/xampp/htdocs/PiDev/web/images/"+e.getNom_image());
                //Image imgTemp = new Image("http://localhost/PiDev/web/images/" + e.nom_image,700,700, false, false);
                img.setImage(imgTemp);
                vboxRecette.getChildren().add(ap);
                ///////////
         /*       
                 //lIKE DISLIKE OPERATION
                Button likeBtn = (Button) ap.getChildren().get(6);
                LikerecetteService js = new LikerecetteService();
                if (js.getAll(e.getId()).contains(FXMain.userConnected)) {
                    likeBtn.setOnAction(b -> {
                        js.delete(a.getId(), FXMain.userConnected);
                    });
                    imageButton("dislike", likeBtn, 40);
                    heart.setVisible(true);
                    likeBtn.setOnMouseClicked(value -> {
                        if (js.getLove(a.getId()).contains(FXMain.userConnected)) {
                            likeBtn.setOnAction(b -> {
                                js.delete(a.getId(), FXMain.userConnected);
                            });
                            imageButton("dislike", likeBtn, 40);
                            heart.setVisible(true);
                        } else {
                            likeBtn.setOnAction(b -> {
                                js.createJaime(a.getId(), FXMain.userConnected);
                            });
                            imageButton("like", likeBtn, 40);
                            heart.setVisible(false);
                        }
                    });
                } else {
                    likeBtn.setOnAction(b -> {
                        js.createJaime(a.getId(), FXMain.userConnected);
                    });
                    imageButton("like", likeBtn, 40);
                    heart.setVisible(false);
                    likeBtn.setOnMouseClicked(value -> {
                        if (js.getLove(a.getId()).contains(FXMain.userConnected)) {
                            likeBtn.setOnAction(b -> {
                                js.delete(a.getId(), FXMain.userConnected);
                            });
                            imageButton("dislike", likeBtn, 40);
                            heart.setVisible(true);
                        } else {
                            likeBtn.setOnAction(b -> {
                                js.createJaime(a.getId(), FXMain.userConnected);
                            });
                            imageButton("like", likeBtn, 40);
                            heart.setVisible(false);
                        }
                    });
                }
*/
                //End like_Dislike operation
                
                
                ////////////
            } catch (IOException ex) {
                Logger.getLogger(RecetteFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }
    
}
