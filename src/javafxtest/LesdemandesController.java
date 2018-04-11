/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.User;
import com.esprit.Entity.demandeoffre;
import com.esprit.Service.AppelOffreService;
import com.esprit.Service.UserService;
import com.esprit.Service.demandeService;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PACKARDBELL
 */
public class LesdemandesController implements Initializable {

    @FXML
    private TableColumn<AppelOffre, String> suu;
    @FXML
    private TableColumn<AppelOffre, String> etat;
    @FXML
    private TableColumn<User, String> pati;
    @FXML
    private TableView<AppelOffre> table1;
    
      AppelOffreService ds = new AppelOffreService(); 
      UserService us = new UserService();
    ObservableList<AppelOffre> list = FXCollections.observableArrayList(ds.getAll2());
    ObservableList<User> list1 = FXCollections.observableArrayList(us.getAllName());
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AppelOffre de = new AppelOffre();
        AppelOffreService ds = new AppelOffreService(); 
        User u = new User();
        UserService us = new UserService();
        suu.setCellValueFactory(new PropertyValueFactory("sujet"));      
        pati.setCellValueFactory(new PropertyValueFactory("username"));
        etat.setCellValueFactory(new PropertyValueFactory("statut"));
        
       
            
       
        table1.setItems(list); 
    
        
        
        
    }    
    
}
