/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Cathy
 */
public class PoopController {
    private static int playerWidth = 100;
    private static final int playerHeight = 100;
    private static final int KEYBOARD_DELTA = 5;
    private static final Duration MOVEMENT_DURATION = Duration.seconds(0.25);
    private final static Image PLAYER = new Image(MainApplication.class.getResource("Player.gif").toString());
    private final static Image BACKGROUND = new Image(MainApplication.class.getResource("Game1.png").toString());
    private final MiniGameLauncher miniGameLauncher;
    
    final ImageView background = setBackground(BACKGROUND);
    final ImageView player = createPlayer(PLAYER);
    final Rectangle obstacle1 = new Rectangle(0, 250, 50, 50);
    final Rectangle Tester = new Rectangle(100, 50, 50, 50);
    //going to be adding obstacles in the group later.
    final Group group = new Group(background, instructions(), player, obstacle1, Tester); //should add the group of hings you want on scene
    final Scene scene = new Scene(group, 600, 400, Color.BLACK);

    private static int lifeCount = 0;
   
    
    public PoopController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        movePlayer(scene, player); 
        moveObst(obstacle1);
    }
    
        /**
     *
     * @param rectangle
     */
    
    //need to know how to retreive x and y of rectangle
    public void moveObst(Rectangle rectangle) {
        rectangle.setFill(Color.GREY);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        final KeyValue kv = new KeyValue(rectangle.xProperty(), 550);
        final KeyFrame kf = new KeyFrame(Duration.millis(800), kv);
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
    //creating final instructions for user
    private Text instructions() {
        Text instructions = new Text(8, 380, "Avoid the Obstacles! You have 3 lives!\n");
        instructions.setFont(Font.font ("Verdana", 30));
        instructions.setFill(Color.WHITE);
        return instructions;
    }
    //keyboard event handler
    private void movePlayer(Scene scene, final ImageView player) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: player.setY(player.getY() - KEYBOARD_DELTA);
                            if(player.getY() <= 0) {
                                player.setY(player.getY() + KEYBOARD_DELTA);
                            }
                            break;
                    case DOWN: player.setY(player.getY() + KEYBOARD_DELTA); 
                            if(player.getY() >= 300) {
                                player.setY(player.getY() - KEYBOARD_DELTA);
                            }
                            break;
                    case RIGHT: player.setX(player.getX() + KEYBOARD_DELTA);
                            if(player.getX() >= 500) {
                                player.setX(player.getX() - KEYBOARD_DELTA);
                            }
                            break;
                    case LEFT: player.setX(player.getX() - KEYBOARD_DELTA);
                                if(player.getX() <= 0) {
                                    player.setX(player.getX() + KEYBOARD_DELTA);
                            }
                            break;
                    case ESCAPE:
                    {
                        try {
                            lifeCount = 0;
                            miniGameLauncher.exitMinigame();
                        } catch(IOException exception) {
                            System.err.println("ERROR: " + exception.getMessage());
                        }
                    }
                    break;
                }
                
                //if a collision happens...
                if(player.getBoundsInParent().intersects(obstacle1.getBoundsInParent())) {
                    //start from the beginning!
                    player.setX(0);
                    player.setY(0);

                    //checking amount of lives
                    if(lifeCount < 3) {
                        lifeCount++;
                    }
                    //if you reach max amount, exit game
                    else {
                        try {
                            lifeCount = 0;
                            miniGameLauncher.exitMinigame();
                        } catch(IOException exception) {
                            System.err.println("ERROR: " + exception.getMessage());
                        }
                    }
                }
            }
        });
    }
    //x,y of origin of player/ x,y of origin of obstacle
    private boolean collision(int row1, int col1,
            int row2, int col2, int height2, int width2) { //will be passing in origin
	int width = playerWidth; //x
      	int height = playerHeight; //y

      	int x1Min = col1;
      	int x1Max = col1 + width;
      	int y1Min = row1;
      	int y1Max = row1 + height;

      	int x2Min = col2;
      	int x2Max = col2 + width2;
      	int y2Min = row2;
      	int y2Max = row2+ height2;
      	if (x1Max < x2Min || x1Min > x2Max) {
        	return false;
        }
      	if (y1Max < y2Min || y1Min > y2Max) {
        	return false;
        }
      	return true;
    }
    public Scene getScene() {
        return scene;
    }
}
