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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author saleh
 */
public class NewGameDialogController implements Initializable {

    private MainApplication application;
    
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
        System.out.println("Not yet implemented");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fighterSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(fighterSPLabel));
        pilotSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(pilotSPLabel));
        traderSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(traderSPLabel));
        engineerSPSlider.valueProperty().addListener(
            new LabelUpdaterOnSliderChangeListener(engineerSPLabel));
    }
    
    public void setMainApplication(MainApplication application) {
        this.application = application;
    }
    
    private class LabelUpdaterOnSliderChangeListener implements ChangeListener<Number> {
        private Label label;

        public LabelUpdaterOnSliderChangeListener(Label label) {
            this.label = label;
        }

        @Override
        public void changed(ObservableValue<? extends Number> ov,
            Number oldValue, Number newValue) {
                label.setText(String.format("%.0f", newValue));
        }
    }
}
