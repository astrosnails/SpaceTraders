/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * this class creates the alert dialog
 * @author team 6
 * @version 1.0
 */
public class AlertDialog {
    /*
    * popup window appears when showalert is called
    * @param String message
    */
    public static void showAlert(String message) {
        Stage dialogStage = new Stage();
        Button ok = new Button("OK");

        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create().
            children(new Text(message), ok).
            alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.show();
        ok.setOnAction((ActionEvent okEvent) -> {
            dialogStage.close();
        });
    }

    public static void showYesNo(String message, EventHandler<ActionEvent> yesHandler, EventHandler<ActionEvent> noHandler) {
        Stage dialogStage = new Stage();
        Button yes = new Button("Yes");
        Button no = new Button("No");

        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(
            new Scene(
                VBoxBuilder.create()
                    .children(new Text(message),
                    HBoxBuilder.create()
                        .children(yes, no)
                        .alignment(Pos.CENTER)
                        .padding(new Insets(5))
                        .build())
            .alignment(Pos.CENTER).padding(new Insets(5)).build()));

        dialogStage.show();

        yes.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (yesHandler != null) {
                    yesHandler.handle(event);
                }

                dialogStage.close();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (noHandler != null) {
                    noHandler.handle(event);
                }

                dialogStage.close();
            }
        });
    }
}
