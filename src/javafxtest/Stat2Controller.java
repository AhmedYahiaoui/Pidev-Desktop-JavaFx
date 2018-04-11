/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author PACKARDBELL
 */
public class Stat2Controller implements Initializable {

    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private LineChart<?, ?> Semaine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Semaine 1",2));
        set1.getData().add(new XYChart.Data("Semaine 2",6));
        set1.getData().add(new XYChart.Data("Semaine 2",0));
        set1.getData().add(new XYChart.Data("Semaine 2",0));
        set1.getData().add(new XYChart.Data("Semaine 2",0));
        set1.getData().add(new XYChart.Data("Semaine 2",0));
        Semaine.getData().addAll(set1);
    }    
    
}
