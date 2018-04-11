package javafxtest;

import com.esprit.Entity.AppelOffre;
import com.esprit.Service.AppelOffreService;
import com.esprit.utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppelOffreModifController implements Initializable {
    public int id;
    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;
    
    @FXML
    private TextField sujet;
    @FXML
    private DatePicker date;
    @FXML
    private TextField description;
    @FXML
    private Button bt;



    AppelOffre u ;
    public AppelOffreModifController(AppelOffre u)
    {this.u=u;}

    public void initialize(URL url, ResourceBundle rb) {
        
        AppelOffreService us = new AppelOffreService();
        sujet.setText(u.getSujet());
        description.setText(u.getDescription());
        date.setValue(LocalDate.parse(u.getDate()));

    }    

    @FXML
    private void modifer(ActionEvent event) {
        
        u.setSujet(sujet.getText());
        u.setDescription(description.getText());
        u.setDate(date.getValue().toString());
        
        AppelOffreService cv = new AppelOffreService();
        cv.update(u);
        
        
        //Parent root = FXMLLoader.load(getClass().getResource(""))

    }
    
}
