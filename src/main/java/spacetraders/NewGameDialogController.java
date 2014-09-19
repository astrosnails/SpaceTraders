/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import spacetraders.model.*;

/**
 *
 * @author saleh
 */
public class NewGameDialogController implements Initializable {

    private final int MAX_SKILL_POINTS = 15;
    private MainApplication application;
    
    @FXML
    private TextField playerNameTextEdit;
    @FXML
    private Slider fighterSPSlider;
    @FXML
    private Label fighterSPLabel;
    @FXML
    private Slider pilotSPSlider;
    @FXML
    private Label pilotSPLabel;
    @FXML
    private Slider traderSPSlider;
    @FXML
    private Label traderSPLabel;
    @FXML
    private Slider engineerSPSlider;
    @FXML
    private Label engineerSPLabel;

    @FXML
    private void handleCancelAction(ActionEvent event) throws IOException {
        application.goToWelcomeScreen();
    }

    @FXML
    private void handleContinueAction(ActionEvent event) throws IOException {
        String playerName = playerNameTextEdit.getText();
        if (playerName.equals("")) {
            AlertDialog.showAlert("Please enter a player name.");
        } else {
            int fighterSkill = (int) fighterSPSlider.getValue();
            int pilotSkill = (int) pilotSPSlider.getValue();
            int traderSkill = (int) traderSPSlider.getValue();
            int engineerSkill = (int) engineerSPSlider.getValue();
            
            application.startNewGame(new Player(playerName, fighterSkill, pilotSkill,
                traderSkill, engineerSkill));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fighterSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(fighterSPSlider, fighterSPLabel));
        pilotSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(pilotSPSlider, pilotSPLabel));
        traderSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(traderSPSlider, traderSPLabel));
        engineerSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(engineerSPSlider, engineerSPLabel));
    }
    
    public void setMainApplication(MainApplication application) {
        this.application = application;
    }
    
    private class LabelUpdaterOnSliderChangeListener implements ChangeListener<Number> {
        private Label label;

        public LabelUpdaterOnSliderChangeListener(Slider slider, Label label) {
            this.label = label;
        }

        @Override
        public void changed(ObservableValue<? extends Number> ov,
                Number oldValue, Number newValue) {
            int pointsUsed = 0;
            pointsUsed += (int) fighterSPSlider.getValue();
            pointsUsed += (int) pilotSPSlider.getValue();
            pointsUsed += (int) traderSPSlider.getValue();
            pointsUsed += (int) engineerSPSlider.getValue();
            
            int pointsRemaining = MAX_SKILL_POINTS - pointsUsed;
            
            fighterSPSlider.setMax((int)fighterSPSlider.getValue() + pointsRemaining);
            pilotSPSlider.setMax((int)pilotSPSlider.getValue() + pointsRemaining);
            traderSPSlider.setMax((int)traderSPSlider.getValue() + pointsRemaining);
            engineerSPSlider.setMax((int)engineerSPSlider.getValue() + pointsRemaining);
            
            label.setText(String.format("%.0f", newValue));
        }
    }
}
