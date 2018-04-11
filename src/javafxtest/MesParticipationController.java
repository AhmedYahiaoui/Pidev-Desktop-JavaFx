/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.demandeoffre;
import com.esprit.Service.AppelOffreService;
import com.esprit.Service.demandeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PACKARDBELL
 */
public class MesParticipationController implements Initializable {

    @FXML
    private TableColumn<AppelOffre,String> sujet;
    @FXML
    private TableColumn<AppelOffre,String> etat;

    
     AppelOffreService es = new AppelOffreService();
     ObservableList<AppelOffre> list = FXCollections.observableArrayList(es.getAll2());
    @FXML
    private TableView<AppelOffre> table2;
    @FXML
    private Button annuler;
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         AppelOffre a= new AppelOffre();
        AppelOffreService es = new AppelOffreService();        
        sujet.setCellValueFactory(new PropertyValueFactory("sujet"));      
        etat.setCellValueFactory(new PropertyValueFactory("statut")); 
         
        
       
        table2.setItems(list);
    }    
           
     
    } 

    
 
    

