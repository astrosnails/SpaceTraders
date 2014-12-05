package spacetraders.minigames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import spacetraders.MainApplication;
import spacetraders.minigames.MiniGameLauncher;

public class ShootingGameController {
    private static int playerWidth = 50;
    private static int playerHeight = 50;
    final static Image PLAYER = new Image(MainApplication.class.getResource("Player.gif").toString());
   final static Image BACKGROUND = new Image(MainApplication.class.getResource("background4.png").toString());
    final ImageView background = setBackground(BACKGROUND);
    final ImageView player = createPlayer(PLAYER);
    private static final int WIDTH = 600 ;
    private static final int HEIGHT = 600 ;
    private static final int NUM_TARGETS = 30 ;
    private static final int GUN_RADIUS = 50 ;
    private static final Random RNG = new Random();
    private MiniGameLauncher miniGameLauncher;
    private Scene scene;
    private final Image GUN = new Image(MainApplication.class.getResource("green_alien.gif").toString());
    int numTarget = NUM_TARGETS/2;
    int money;
    
    public ShootingGameController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
   	
		final Pane root = new Pane();
		final ImageView  gun = new ImageView(GUN);
                                          final ImageView  background = new ImageView(BACKGROUND);  
                                         gun.setX(275);
                                         gun.setY(550);
                                         root.getChildren().add(background);
		root.getChildren().add(gun);
		
		final List<Shape> targets = createTargets();
		root.getChildren().addAll(targets);
		
		scene = new Scene(root, WIDTH, HEIGHT, Color.SKYBLUE);
                                            
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                fireBullet(root, targets);
            }
        });}
	
	
	private List<Shape> createTargets() {
	    List<Shape> targets = new ArrayList<>();
	    	    
	    for (int i=0; i<NUM_TARGETS; i++) {
	        int size = 2* WIDTH / ( 2 * NUM_TARGETS) ;
	        int centerX = size * (2 * i + 1) ;
	        int type = RNG.nextInt(3);
	        final Shape shape ;
	        switch (type) {
                    
                            // Change to a picture of an alien  
	        case 0: shape = createSquare(size, centerX) ;
	        break ;
                    
                            // Change to a picture of an alien
	        case 1: shape = createCircle(size, centerX) ;
	        break ; 
                    
                            //Change to a picture of an alien
	        default: shape = createTriangle(size, centerX) ;
	        break ;
	        }
	        shape.setFill(Color.BLUE);
	        targets.add(shape);
	    }	    
	    return targets ;
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
        
	private Shape createSquare(int size, int centerX) {
	    return new Rectangle(centerX - size / 2, size, size, size);
	}
	
	private Shape createCircle(int size, int centerX) {
	    return new Circle(centerX, size*1.5, size/2);
	}
	
	private Shape createTriangle(int size, int centerX) {
	    Path triangle = new Path(
	            new MoveTo(centerX - size/2,  size * 2), 
	            new LineTo(centerX + size/2, size * 2), 
	            new LineTo(centerX, size), 
	            new ClosePath());
	    triangle.setStroke(Color.TRANSPARENT);
	    return triangle ;
	}
	
	private void fireBullet(final Pane root, final List<Shape> targets) {
	    final Shape bullet = new Circle(10, Color.RED);
	    root.getChildren().add(bullet);
	    final TranslateTransition bulletAnimation = new TranslateTransition(Duration.seconds(1), bullet);
	    final int bulletTargetX = RNG.nextInt(WIDTH);
	    bulletAnimation.setFromX(WIDTH/2);
	    bulletAnimation.setFromY(HEIGHT-GUN_RADIUS);
                         bulletAnimation.setToX(bulletTargetX);
	    bulletAnimation.setToY(0);
	    bullet.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable,
                    Bounds oldValue, Bounds newValue) {
                for (final Shape target : new ArrayList<Shape>(targets)) {
                    if (((Path)Shape.intersect(bullet, target)).getElements().size() > 0) {
                        System.out.println("Hit!");
                        targets.remove(target);
                        numTarget--;
                        if(numTarget == 0) {
                            try {
                                miniGameLauncher.exitMinigame(money*100);
                              } catch(IOException exception) {
                                  System.err.println("ERROR: " + exception.getMessage());
                              }
                        }
                        root.getChildren().remove(target);
                        bulletAnimation.stop();
                        root.getChildren().remove(bullet);
                    }
                }
            }
        });
	    bulletAnimation.setOnFinished(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            root.getChildren().remove(bullet);
        }
        });
        bulletAnimation.play();
        }

        public static void main(String[] args) {
                Application.launch(args);
        }
        public Scene getScene() {
        return scene;
        }
}