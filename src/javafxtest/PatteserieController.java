/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Service.CategorieService;
import com.esprit.Service.RecetteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class PatteserieController implements Initializable {

    @FXML
    private ListView<String> listview;
    //private ListView<String> list_categorie;
    ObservableList<String> items = FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        RecetteService rs =new RecetteService();
        listview.setItems(items);
        rs.get_Nom_Recette().forEach(a -> items.add(a.getNom()));
        
    }
}
