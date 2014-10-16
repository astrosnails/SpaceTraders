/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import spacetraders.model.*;

/**
 * The main application class. This class is run when the user opens the application.
 * @author Team Astrosnails
 */
public class MainApplication extends Application {
    
    private Stage mainStage;
    private Player player;
    private Universe universe;
    
    /**
    * Starts the application.
    * @param stage The JavaFX stage of the application
    */
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        goToWelcomeScreen();
        mainStage.show();
    }
    
    /**
    *  Opens in the welcome screen
    *   @param none
    */
    public void goToWelcomeScreen() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("WelcomeScreen.fxml"));
        Parent root = myLoader.load();
        
        WelcomeScreenController controller = (WelcomeScreenController) myLoader.getController();
        controller.setMainApplication(this);
        
        Scene scene = new Scene(root);
        
        mainStage.setScene(scene);
    }
    
    /**
    *  Opens the new game dialog.
    * @param none
    */
    public void goToNewGameDialog() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        Pane dialogPane = myLoader.load();

        NewGameDialogController controller = (NewGameDialogController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    /**
    *  Initializes the game models and opens the game dashboard.
    * @param: Player player
    */
    public void startNewGame(Player player) throws IOException {
        this.player = player;
        universe = Universe.getInstance();
        List<Planet> planets = universe.getPlanets();
        for (Planet planet : planets) {
            player.addTravelListener(planet);
        }
        
        Planet playerLocation = planets.get((int) (Math.random() * planets.size()));
        this.player.setLocation(playerLocation);
        
        goToDashboard();
    }
    
    /**
    *  Goes to dashboard
    * @param: none
    * @return none
    */
    public void goToDashboard() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Pane dialogPane = myLoader.load();

        DashboardController controller = (DashboardController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    /**
    *  Goes to marketplace
    * @param: Player player
    */
    public void goToMarketPlace() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MarketPlace.fxml"));
        Pane dialogPane = myLoader.load();

        MarketPlaceController controller = (MarketPlaceController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    public void saveGame() throws IOException {
        OutputStream file = new FileOutputStream("game.data");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(universe);
        output.writeObject(player);
        
        output.close();
    }
    
    public void loadGame() throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream("game.data");
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        universe = (Universe) input.readObject();
        player = (Player) input.readObject();
        
        //Set singleton instance to the loaded universe
        Universe.setInstance(universe);
        
        goToDashboard();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    *  Get the Player
    *  @return The player
    */
    public Player getPlayer() {
        return player;
    }
    /**
     * Get the univese
     * @param none
     * @return Universe universe 
    */
    public Universe getUniverse() {
        return universe;
    }
}
