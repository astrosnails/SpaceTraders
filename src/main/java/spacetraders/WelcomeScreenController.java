/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author saleh
 */
public class WelcomeScreenController implements Initializable {
    
    private Stage mainStage;

    public void setMainStage(Stage stage){
         this.mainStage = stage;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Pane dialogPane = FXMLLoader.load(getClass().getResource("Dialog.fxml"));
        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
