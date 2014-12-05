/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders.minigames;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import spacetraders.MainApplication;

/**
 *
 * @author Cathy
 */
public class PoopController {
    private static int playerWidth = 100;
    private static final int playerHeight = 100;
    private static final int KEYBOARD_DELTA = 5;
    private static final Duration MOVEMENT_DURATION = Duration.seconds(0.25);
    private final static Image PLAYER = 
            new Image(MainApplication.class.getResource("Player.gif").toString());
    private final static Image BACKGROUND = 
            new Image(MainApplication.class.getResource("Game1.png").toString());
    private final static Image MOON = 
            new Image(MainApplication.class.getResource("moon.gif").toString());
    private final static Image MOON2 = 
            new Image(MainApplication.class.getResource("moon.gif").toString());
    
    private final MiniGameLauncher miniGameLauncher;
    
    final ImageView background = setBackground(BACKGROUND);
    final ImageView player = createPlayer(PLAYER);
    final Rectangle obstacle1 = new Rectangle(0, 200, 50, 50);
    final Rectangle obstacle2 = new Rectangle(150, 0, 50, 50);
    final ImageView moon = setMoon(MOON);
    final ImageView moon2 = setMoon(MOON2);

    final Circle planetDest = new Circle(550, 350, 50);
    Text planetLabel = new Text(520, 340, "PLANET");
    final Group group = new Group(background, obstacle1,
        obstacle2, moon, moon2, player, planetDest, instructions(), planetLabel);
    final Scene scene = new Scene(group, 600, 400, Color.BLACK);

    private static int lifeCount = 0;
   
    
    public PoopController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        planetDest.setFill(Color.SALMON);
        planetLabel.setFont(Font.font ("Verdana", 20));
        planetLabel.setFill(Color.CORNSILK);
        movePlayer(scene, player); 
        moveObst1(obstacle1);
        moveObst2(obstacle2);
    }
    
     /**
     *
     * @param rectangle
     */
    
    //need to know how to retreive x and y of rectangle
    public void moveObst1(Rectangle rectangle) {
        rectangle.setFill(Color.GREY);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectangle.xProperty(), 550);
        final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    //need to know how to retreive x and y of rectangle
    public void moveObst2(Rectangle rectangle) {
        rectangle.setFill(Color.LIGHTGOLDENRODYELLOW);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectangle.yProperty(), 350);
        final KeyFrame kf = new KeyFrame(Duration.millis(1300), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    
    
    private ImageView createPlayer(Image PLAYER) {
        final ImageView player = new ImageView(PLAYER);
        player.setEffect(new BoxBlur());
        return player;
    }
    private ImageView setBackground(Image BACKGROUND) {
        final ImageView background = new ImageView(BACKGROUND);
        background.setEffect(new BoxBlur());
        return background;
    }
    
    private ImageView setMoon(Image Moon) {
        final ImageView moon = new ImageView(Moon);
        moon.setEffect(new BoxBlur());
        if(Moon == MOON) {
            moon.setX(350);
            moon.setY(10);
        }
        else {
            moon.setX(400);
            moon.setY(300);
        }

        return moon;
    }
    //creating final instructions for user
    private Text instructions() {
        Text instructions = 
                new Text(8, 380, "Get to the Planet! Avoid the Obstacles! You have 3 lives!\n");
        instructions.setFont(Font.font ("Verdana", 20));
        instructions.setFill(Color.WHITE);
        return instructions;
    }
    //keyboard event handler
    private void movePlayer(Scene scene, final ImageView player) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: player.setY(player.getY() - KEYBOARD_DELTA);
                            if(player.getY() <= 0 ||
                                player.getBoundsInParent().intersects(moon.getBoundsInParent()) ||
                                player.getBoundsInParent().intersects(moon2.getBoundsInParent())) {
                                player.setY(player.getY() + KEYBOARD_DELTA);
                            }
                            break;
                    case DOWN: player.setY(player.getY() + KEYBOARD_DELTA); 
                            if(player.getY() >= 300 ||
                                player.getBoundsInParent().intersects(moon.getBoundsInParent()) ||
                                player.getBoundsInParent().intersects(moon2.getBoundsInParent())) {
                                player.setY(player.getY() - KEYBOARD_DELTA);
                            }
                            break;
                    case RIGHT: player.setX(player.getX() + KEYBOARD_DELTA);
                            if(player.getX() >= 500 ||
                                player.getBoundsInParent().intersects(moon.getBoundsInParent()) ||
                                player.getBoundsInParent().intersects(moon2.getBoundsInParent())) {
                                player.setX(player.getX() - KEYBOARD_DELTA);
                            }
                            break;
                    case LEFT: player.setX(player.getX() - KEYBOARD_DELTA);
                                if(player.getX() <= 0 ||
                                    player.getBoundsInParent().intersects(moon.getBoundsInParent()) ||
                                    player.getBoundsInParent().intersects(moon2.getBoundsInParent())) {
                                    player.setX(player.getX() + KEYBOARD_DELTA);
                            }
                            break;
                    case ESCAPE:
                    {
                        try {
                            lifeCount = 0;
                            miniGameLauncher.exitMinigame(0);
                        } catch(IOException exception) {
                            System.err.println("ERROR: " + exception.getMessage());
                        }
                    }
                    break;
                }
                if(player.getBoundsInParent().intersects(planetDest.getBoundsInParent())) {
                    try {
                        miniGameLauncher.exitMinigame(0);
                    } catch (IOException exception) {
                        System.err.println("ERROR: " + exception.getMessage());
                    }
                }
                //if a collision happens...
                if(player.getBoundsInParent().intersects(obstacle1.getBoundsInParent()) ||
                        player.getBoundsInParent().intersects(obstacle2.getBoundsInParent())) {
                    //start from the beginning!
                    player.setX(0);
                    player.setY(0);

                    //checking amount of lives
                    if(lifeCount < 2) {
                        lifeCount++;
                    }
                    //if you reach max amount, exit game
                    else {
                        try {
                            lifeCount = 0;
                            miniGameLauncher.exitMinigame(0);
                        } catch(IOException exception) {
                            System.err.println("ERROR: " + exception.getMessage());
                        }
                    }
                }
            }
        });
    }
    public Scene getScene() {
        return scene;
    }
}
