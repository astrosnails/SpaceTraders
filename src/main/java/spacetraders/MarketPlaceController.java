/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import spacetraders.model.Player;

/**
 * FXML Controller class
 *
 * @author saleh
 *@version 1.0
 */
public class MarketPlaceController implements Initializable {
    
    private MainApplication application;
    
    @FXML
    private void onBackButtonClicked(ActionEvent event) throws IOException {
        application.goToDashboard();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /**
     * Set main application
     *@param application - main application 
     */
    public void setMainApplication(MainApplication application) {
        this.application = application;
    }
}
