/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import com.esprit.Entity.User;
import com.esprit.Service.UserService;
import com.esprit.Service.smsService;
import com.esprit.utils.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PACKARDBELL
 */
public class SmsController implements Initializable {

    @FXML
    private TextField cle;
    @FXML
    private TextField env;
  
    @FXML
    private TextArea msg;
     @FXML
    private ComboBox num;

    
    
    

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
  

    @FXML
    private void envoyer(ActionEvent event) {
        	try {
                    
                   
			// Construct data
			String apiKey = "apikey=" + cle.getText();
			String message = "&message=" + msg.getText();
			String sender = "&sender=" + env.getText();
			String numbers = "&numbers=" + num.getSelectionModel().getSelectedItem();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers  + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				//stringBuffer.append(line);
                                JOptionPane.showMessageDialog(null," message"+line);
			}
			rd.close();
			
			//return stringBuffer.toString();
		} catch (Exception e) {
			//System.out.println("Error SMS "+e);
                        JOptionPane.showMessageDialog(null,e);
			//return "Error "+e;
		}
    }

    @FXML
    private void afficherComboBox(MouseEvent event) {
    smsService us = new smsService();
    ObservableList<String> list = FXCollections.observableArrayList(us.getAll3());
    us.getAll3();
    num.setItems(list);
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
          Parent home_page_parent = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
    }

 
    }
    

