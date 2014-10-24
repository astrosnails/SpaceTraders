/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetraders;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spacetraders.model.Player;
import spacetraders.model.Ship;
import spacetraders.model.ShipType;
import spacetraders.model.ShipsInfo;

/**
*This class implements the WelcomeScreenController
*to set up and create the welcome screen
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class ShipYardController extends Controller {
    
    Map<String, ShipType> shipsAvailable;
    private ShipType selectedShipType;

    @FXML private ListView shipsList;
    @FXML private TextArea shipInfoTextArea;
    @FXML private Label currentMoney;
    
    /**
    * this method is the button action listener 
    * and handles the button action
    * @param ActionEvent event
    * @return info
    */
    @FXML
    private void onBackButtonClicked(ActionEvent event) throws IOException {
        application.goToDashboard();
    }
    
    /**
    * this method is the button action listener 
    * and handles the button action
    * @param ActionEvent event
    * @return info
    */
    @FXML
    private void onBuyButtonClicked(ActionEvent event) throws IOException {
        ShipsInfo shipsInformation = ShipsInfo.getInstance();
        Ship currentShip = application.getPlayer().getShip();
        if (selectedShipType == currentShip.getType()) {
            AlertDialog.showAlert("This is the same as your ship!");
        } else {
            String selectedShipName = shipsInformation.getName(selectedShipType);
            int selectedShipPrice = shipsInformation.getPrice(selectedShipType);
            
            AlertDialog.showYesNo(
                new StringBuilder().append("Are you sure you want to buy ")
                    .append(selectedShipName)
                    .append(" for ")
                    .append(selectedShipPrice)
                    .append("?")
                    .toString(),
                null, null);
        }
    }
    
    /**
    * Sets the main application
    * @param MainApplication application
    */
    @Override
    public void setMainApplication(MainApplication application) {
        this.application = application;
        
        final Player player = application.getPlayer();
        ShipsInfo shipsInformation = ShipsInfo.getInstance();
        ObservableList<String> names = FXCollections.observableArrayList();
        
        shipsAvailable = new HashMap<>();
        for (ShipType shipType : player.getLocation().getShipsInShipyard()) {
            shipsAvailable.put(shipsInformation.getName(shipType), shipType);
        }
        
        names.add("Current Ship");
        names.addAll(shipsAvailable.keySet());
        shipsList.setItems(names);    
        
        currentMoney.textProperty().bind(player.getMoney().asString());
        
        shipsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                if (new_val.equals("Current Ship")) {
                    selectedShipType = player.getShip().getType();
                } else {
                    selectedShipType = shipsAvailable.get(new_val);
                }
                
                shipInfoTextArea.setText(shipsInformation.getInformationAsText(selectedShipType));
            }
        });
    }
}
