/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.controlsfx.control.PopOver;
import spacetraders.model.Coordinates;
import spacetraders.model.Planet;
import spacetraders.model.Player;
import spacetraders.model.Universe;

/**
 * FXML Controller class
 *
 * @author saleh
 *@version 1.0
 */
public class DashboardController extends Controller {
    
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
    @FXML
    private Pane mapPane;

    /**
     * Update player information
     * @param none
     * @return none
    */
    
    private void updatePlayerInformation() {
        Player player = application.getPlayer();
        
        playerName.setText(player.getName());
        fighterPoints.setText(Integer.toString(player.getFighterSkill()));
        traderPoints.setText(Integer.toString(player.getTraderSkill()));
        pilotPoints.setText(Integer.toString(player.getPilotSkill()));
        engineerPoints.setText(Integer.toString(player.getEngineerSkill()));
    }
    
    /**
     * initializes the Map Pane
     * @param none
     * @return none
    */
    private void initializeMapPane() {
        Universe universe = application.getUniverse();
        List<Planet> planets = universe.getPlanets();
        
        Circle[] circles = new Circle[planets.size()];
        double radius = 3.0;
        for (int i = 0; i < planets.size(); i++) {
            Planet planet = planets.get(i);
            Coordinates coordinates = planet.getCoordinates();
            double x = coordinates.getX() * mapPane.getPrefWidth() / universe.getWidth();
            double y = coordinates.getY() * mapPane.getPrefHeight() / universe.getHeight();
            Color color = application.getPlayer().getLocation().equals(planet) ?
                Color.RED :Color.SKYBLUE;
            
            circles[i] = new Circle(x, y, radius, color);
            
            final Circle circle = circles[i];
            circles[i].setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    PopOver popover = new PopOver();
                    popover.show(circle);
                }
            
            });
        }
        
        mapPane.getChildren().addAll(circles);
    }
    
    /**
     * The button listener for selling stuff
     * @param ActionEvent event
     * @return none
    */
    @FXML
    private void onBuySellButtonClicked(ActionEvent event) throws IOException {
        application.goToMarketPlace();
    }
    
    /**
     * Set main application
     *@param application - main application 
     */
    @Override
    public void setMainApplication(MainApplication application) {
        this.application = application;
        
        updatePlayerInformation();
        initializeMapPane();
    }
}
