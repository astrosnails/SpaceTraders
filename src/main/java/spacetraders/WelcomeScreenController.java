/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetraders;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
*This class implements the WelcomeScreenController
*to set up and create the welcome screen
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class WelcomeScreenController extends Controller {
    
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    /**
    * this method is the button action listener 
    * and handles the button action
    * @param ActionEvent event
    * @return info
    */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        application.goToNewGameDialog();
    }
}
