package javafxtest;

import com.esprit.Entity.AppelOffre;
import com.esprit.Entity.User;
import com.esprit.Service.AppelOffreService;
import com.esprit.Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AfficheappelController implements Initializable {

  
    ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    private TableView<AppelOffre> table;
    @FXML
    private TableColumn<AppelOffre,String> sujet;
    @FXML
    private TableColumn<AppelOffre,String> datemax;
    @FXML
    private TableColumn<AppelOffre,String> description;
    
     AppelOffreService es = new AppelOffreService();
    ObservableList<AppelOffre> list = FXCollections.observableArrayList(es.getAll());
    @FXML
    private AnchorPane pane;
   
    User u = new User();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppelOffreService es = new AppelOffreService();
        //tableview
     
        
        ObservableList<AppelOffre> list = FXCollections.observableArrayList(es.getAll());
                table.setItems(list);

        sujet.setCellValueFactory(new PropertyValueFactory("sujet"));
     datemax.setCellValueFactory(new PropertyValueFactory("datemax"));
        description.setCellValueFactory(new PropertyValueFactory("description"));
        

                        table.setItems(list);

        /*listView
        l.setItems(items);
        es.getAll().forEach(a -> items.add(a.toString()));
*/
    }    

    @FXML
    private void delete(ActionEvent event) {
        AppelOffreService s =new AppelOffreService();
        AppelOffre e = table.getSelectionModel().getSelectedItem();
        s.delete(e.id);
        list.remove(e);
        
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        //AppelOffreService s =new AppelOffreService();
        AppelOffre e = table.getSelectionModel().getSelectedItem();

        AppelOffreModifController cont = new AppelOffreModifController(e);
        final  FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("AppelOffreModif.fxml"));
        loader.setController(cont);
        final Parent root= loader.load();
        AnchorPane pane = new AnchorPane();
        pane =(AnchorPane) table.getParent();
        pane.getChildren().setAll(root);
        
                
        
    }
    
    
}
