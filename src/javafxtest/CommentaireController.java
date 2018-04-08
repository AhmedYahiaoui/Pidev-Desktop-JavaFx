/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Entity.Commentaire;
import com.esprit.Entity.Recette;
import com.esprit.Service.CommentaireService;
import com.esprit.Service.RecetteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class CommentaireController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TableView<Commentaire> tableCommentaire;
    @FXML
    private TableColumn<Commentaire, String> id;
    @FXML
    private TableColumn<Commentaire, String> contenu;
    @FXML
    private TableColumn<Commentaire, String> id_recette;
    @FXML
    private TableColumn<Commentaire, String> id_user;
        CommentaireService s = new CommentaireService();


    CommentaireService service = new CommentaireService();
     ObservableList<Commentaire> listCommentaire = FXCollections.observableArrayList(service.getAll());
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   id.setCellValueFactory(new PropertyValueFactory("id"));
   contenu.setCellValueFactory(new PropertyValueFactory("contenu"));
   id_recette.setCellValueFactory(new PropertyValueFactory("id_recette"));
   id_user.setCellValueFactory(new PropertyValueFactory("id_user"));
    
       tableCommentaire.setItems(listCommentaire);

    }

    @FXML
    private void Banir(ActionEvent event) {
                    Commentaire e = tableCommentaire.getSelectionModel().getSelectedItem();
            s.delete(e.id);
            listCommentaire.remove(e);
    }
    
}
