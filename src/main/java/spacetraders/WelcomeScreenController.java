/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetraders;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
*This class implements the WelcomeScreenController
*to set up and create the welcome screen
* @author Team 6, CS 2340 - Fall 2014 M5
*
*/
public class WelcomeScreenController extends Controller {

    /**
    * this method is the button action listener
    * and handles the button action
    * @param ActionEvent event
    * @return info
    */
    @FXML
    private void onNewGameButtonClicked(ActionEvent event) throws IOException {
        application.goToNewGameDialog();
    }

    @FXML
    private void onLoadGameButtonClicked(ActionEvent event) {
        try {
            application.loadGame();
        } catch (IOException exception) {
            AlertDialog.showAlert("ERROR: Cannot load game!");
        } catch (ClassNotFoundException exception) {
            AlertDialog.showAlert("ERROR: Saved game is corrupted!");
        }
    }
}
