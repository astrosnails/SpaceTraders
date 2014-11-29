/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders;

import spacetraders.minigames.MiniGameLauncher;
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
import spacetraders.Abstract.PersistenceProvider;
import spacetraders.Persistence.DatabasePersistenceProvider;
import spacetraders.Persistence.LocalPersistenceProvider;
import spacetraders.model.Planet;
import spacetraders.model.Player;
import spacetraders.model.Universe;

/**
 * The main application class. This class is run when the user opens the
 * application.
 * @author Team Astrosnails
 */
public class MainApplication extends Application {

    private PersistenceProvider persistenceProvider;
    private Stage mainStage;
    private Player player;
    private Universe universe;

    public MainApplication() {
        persistenceProvider = new DatabasePersistenceProvider();
    }
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
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("WelcomeScreen.fxml"));
        Parent root = myLoader.load();

        WelcomeScreenController controller =
                (WelcomeScreenController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(root);

        mainStage.setScene(scene);
    }

    /**
    *  Opens the new game dialog.
    * @param none
    */
    public void goToNewGameDialog() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("Dialog.fxml"));
        Pane dialogPane = myLoader.load();

        NewGameDialogController controller
            = (NewGameDialogController) myLoader.getController();
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
        
        //Add the MiniGameLauncher to the player's travel listeners
        player.addTravelListener(new MiniGameLauncher(this));

        Planet playerLocation = planets.get(
                (int) (Math.random() * planets.size()));
        this.player.setLocation(playerLocation);

        goToDashboard();
    }

    /**
    *  Goes to dashboard
    * @param: none
    * @return none
    */
    public void goToDashboard() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("Dashboard.fxml"));
        Pane dialogPane = myLoader.load();

        DashboardController controller =
                (DashboardController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }

    /**
    *  Goes to marketplace
    * @param: Player player
    */
    public void goToMarketPlace() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("MarketPlace.fxml"));
        Pane dialogPane = myLoader.load();

        MarketPlaceController controller =
                (MarketPlaceController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }

    /**
    *  Goes to ship yard
    * @param: Player player
    */
    public void goToShipYard() throws IOException {
        FXMLLoader myLoader = new FXMLLoader(
                getClass().getResource("ShipYard.fxml"));
        Pane dialogPane = myLoader.load();

        ShipYardController controller =
                (ShipYardController) myLoader.getController();
        controller.setMainApplication(this);

        Scene scene = new Scene(dialogPane);
        mainStage.setScene(scene);
    }
    
    public void setScene(Scene scene) {
        mainStage.setScene(scene);
    }

    public void saveGame() throws Exception {
        persistenceProvider.saveGame(this);
    }

    public void loadGame() throws Exception {
        persistenceProvider.loadGame(this);
        
        // Add the planets to the players travel listners
        for(Planet p : universe.getPlanets()) {
            player.addTravelListener(p);
        }
        
        //Add the MiniGameLauncher to the player's travel listeners
        player.addTravelListener(new MiniGameLauncher(this));

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
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Get the univese
     * @param none
     * @return Universe universe
    */
    public Universe getUniverse() {
        return universe;
    }
    
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }
}
