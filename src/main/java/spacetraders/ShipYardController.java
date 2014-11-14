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
import spacetraders.model.GadgetType;
import spacetraders.model.GadgetsInfo;
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
    private Map<String, GadgetType> gadgetsAvailable;
    private GadgetType selectedGadget;

    @FXML private ListView shipsList;
    @FXML private ListView gadgetsList;
    @FXML private TextArea shipInfoTextArea;
    @FXML private Label currentMoney;
    private ListView lastSelectedList;

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
        if (lastSelectedList == shipsList) {
            ShipsInfo shipsInformation = ShipsInfo.getInstance();
            Player player = application.getPlayer();
            Ship currentShip = player.getShip();

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
                    (ActionEvent yesEvent) -> {
                        if (currentShip.getCargo().calculateTotalResources()
                                > shipsInformation.getCargoSpace(selectedShipType)) {
                            AlertDialog.showAlert("Your resources do not fit in the new ship.");
                        } else if (player.getMoney().getValue() < selectedShipPrice) {
                            AlertDialog.showAlert("You do not have enough money.");
                        } else {
                            buyShip(selectedShipType);
                        }
                    }, null);
            }
        } else if (lastSelectedList == gadgetsList) {
            GadgetsInfo gadgetsInformation = GadgetsInfo.getInstance();
            Player player = application.getPlayer();
            Ship ship = player.getShip();

            String selectedGadgetName = gadgetsInformation.getName(selectedGadget);
            int selectedGadgetPrice = gadgetsInformation.getPrice(selectedGadget);

            AlertDialog.showYesNo(
                new StringBuilder().append("Are you sure you want to buy ")
                    .append(selectedGadgetName)
                    .append(" for ")
                    .append(selectedGadgetPrice)
                    .append("?")
                    .toString(),
                (ActionEvent yesEvent) -> {
                    if (!ship.hasAvailableSlot()) {
                        AlertDialog.showAlert("Your ship does not have available gadget slots.");
                    } else if (player.getMoney().getValue() < selectedGadgetPrice) {
                        AlertDialog.showAlert("You do not have enough money.");
                    } else {
                        buyGadget(selectedGadget);
                    }
                }, null);
        }
    }
    /**
     * Method to buy ship
     * @param selectedShip
     */
    private void buyShip(ShipType selectedShip) {
        Player player = application.getPlayer();
        Ship oldShip = player.getShip();
        Ship newShip = new Ship(selectedShip);
        newShip.getCargo().setResources(oldShip.getCargo().getResources());
        player.setShip(newShip);

        int newShipPrice = ShipsInfo.getInstance().getPrice(selectedShip);
        player.decreaseMoney(newShipPrice);
    }
    /**
     * Method to buy gadget
     * @param selectedGadget
     */
    private void buyGadget(GadgetType selectedGadget) {
        Player player = application.getPlayer();
        player.getShip().addGadget(selectedGadget);

        int price = GadgetsInfo.getInstance().getPrice(selectedGadget);
        player.decreaseMoney(price);
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
        GadgetsInfo gadgetsInformation = GadgetsInfo.getInstance();
        ObservableList<String> shipNames = FXCollections.observableArrayList();
        ObservableList<String> gadgetNames = FXCollections.observableArrayList();

        shipsAvailable = new HashMap<>();
        for (ShipType shipType : player.getLocation().getShipsInShipyard()) {
            shipsAvailable.put(shipsInformation.getName(shipType), shipType);
        }

        gadgetsAvailable = new HashMap<>();
        for (GadgetType gadget : player.getLocation().getGadgetsInShipyard()) {
            gadgetsAvailable.put(gadgetsInformation.getName(gadget), gadget);
        }

        shipNames.add("Current Ship");
        shipNames.addAll(shipsAvailable.keySet());
        shipsList.setItems(shipNames);

        gadgetNames.addAll(gadgetsAvailable.keySet());
        gadgetsList.setItems(gadgetNames);

        currentMoney.textProperty().bind(player.getMoney().asString());

        shipsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                StringBuilder shipDetails = new StringBuilder();
                if (new_val.equals("Current Ship")) {
                    selectedShipType = player.getShip().getType();

                    GadgetType[] gadgets = player.getShip().getGadgets();
                    if (gadgets.length > 0) {
                        shipDetails.append("Gadgets\n-------\n");
                        for (int i = 0; i < gadgets.length; i++) {
                            shipDetails.append("Slot ").append(i).append(": ")
                                    .append(gadgets[i] != null ? gadgetsInformation.getName(gadgets[i]) : "")
                                    .append("\n");
                        }
                    }
                } else {
                    selectedShipType = shipsAvailable.get(new_val);
                }

                shipDetails.insert(0, shipsInformation.getInformationAsText(selectedShipType) + "\n");

                shipInfoTextArea.setText(shipDetails.toString());
                lastSelectedList = shipsList;
            }
        });

        gadgetsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {

                selectedGadget = gadgetsAvailable.get(new_val);
                shipInfoTextArea.setText(gadgetsInformation.getInformationAsText(selectedGadget));

                lastSelectedList = gadgetsList;
            }
        });
    }
}
