/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetraders;

import java.io.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import spacetraders.model.Planet;
import spacetraders.model.Player;

/**
*This class implements the WelcomeScreenController
*to set up and create the welcome screen
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class PlanetPopoverController extends Controller {
    
    private Planet planet;
    
    @FXML
    private Label planetName;
    @FXML
    private Button travelButton;

    /**
    * this method is the button action listener 
    * and handles the button action
    * @param ActionEvent event
    * @return info
    */
    @FXML
    private void handleTravelButtonAction(ActionEvent event) throws IOException {
        Player player = application.getPlayer();
        
        if (planet.equals(player.getLocation())) {
            AlertDialog.showAlert("You are already on " + planet.getName());
        } else {
            if (player.hasEnoughFuelToTravelTo(planet)) {
                player.travelTo(planet);
            } else {
                AlertDialog.showAlert("Not enough fuel.");
            }
        }
    }
    
    /**
     * Set planet
     *@param planet - the planet for which the information will be shown
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
        planetName.setText(planet.getName());
    }
}
