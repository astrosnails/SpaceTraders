/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author Cathy
 */
public class PoopController {
    private static final int KEYBOARD_DELTA = 5;
    private static final Duration MOVEMENT_DURATION = Duration.seconds(0.25);
    private final static Image PLAYER = new Image(MainApplication.class.getResource("Player.jpg").toString());
    private MiniGameLauncher miniGameLauncher;
   
    final ImageView player = createPlayer();
    final Group group = new Group(instructions(), player); //should add the group of hings you want on scene
    final Scene scene = new Scene(group, 600, 400, Color.BLACK);
    
    public PoopController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        movePlayer(scene, player);
    }
    
    private ImageView createPlayer() {
        final ImageView player = new ImageView(PLAYER);
        player.setEffect(new BoxBlur());
        return player;
    }
    //creating final instructions for user
    private Label instructions() {
        Label instructions = new Label(
                "Avoid the falling Poop!\n"
        );
        instructions.setTextFill(Color.BLACK);
        return instructions;
    }
    //keyboard event handler
    private void movePlayer(Scene scene, final ImageView player) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: player.setY(player.getY() - KEYBOARD_DELTA);
                            //if(player.getCenterY() >)
                    break;
                    case DOWN: player.setY(player.getY() + KEYBOARD_DELTA); break;
                    case RIGHT: player.setX(player.getX() + KEYBOARD_DELTA); break;
                    case LEFT: player.setX(player.getX() - KEYBOARD_DELTA); break;
                    case ESCAPE:
                    {
                        try {
                            miniGameLauncher.exitMinigame();
                        } catch(IOException exception) {
                            System.err.println("ERROR: " + exception.getMessage());
                        }
                    }
                    break;
                }
            }
        });
    }
    
    public Scene getScene() {
        return scene;
    }
}
