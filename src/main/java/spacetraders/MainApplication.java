/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author saleh
 */
public class MainApplication extends Application {
    
    private Stage mainStage;
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        goToWelcomeScreen();
        mainStage.show();
    }
    
    public void goToWelcomeScreen() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("WelcomeScreen.fxml"));
        Parent root = myLoader.load();
        
        WelcomeScreenController controller = (WelcomeScreenController) myLoader.getController();
        controller.setMainApplication(this);
        
        Scene scene = new Scene(root);
        
        mainStage.setScene(scene);
    }
    
    public void goToNewGameDialog() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        Pane dialogPane = myLoader.load();

        NewGameDialogController controller = (NewGameDialogController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
