/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import spacetraders.model.Player;

/**
 * FXML Controller class
 *
 * @author saleh
 *@version 1.0
 */
public class DashboardController implements Initializable {
    
    private MainApplication application;
    
    @FXML
    private GridPane playerInformation;
    @FXML
    private Label playerName;
    @FXML
    private Label fighterPoints;
    @FXML
    private Label traderPoints;
    @FXML
    private Label pilotPoints;
    @FXML
    private Label engineerPoints;

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
        
        updatePlayerInformation();
    }
    /**
     * Update player information
     */
    public void updatePlayerInformation() {
        Player player = application.getPlayer();
        
        playerName.setText(player.getName());
        fighterPoints.setText(Integer.toString(player.getFighterSkill()));
        traderPoints.setText(Integer.toString(player.getTraderSkill()));
        pilotPoints.setText(Integer.toString(player.getPilotSkill()));
        engineerPoints.setText(Integer.toString(player.getEngineerSkill()));
    }
}
