/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders.minigames;
//package fxtimer;

import java.io.IOException;
import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import spacetraders.MainApplication;
import spacetraders.minigames.MiniGameLauncher;
/**
 *
 * @author Hifza
 */
public class TransitionController { 
    private final Image BACKGROUND = new Image(MainApplication.class.getResourceAsStream("background_transition.png"));
    private int counter;
    private Random rand;
    private final static int WIDTH = 600;
    private final static int HEIGHT = 400;
    private static int num;
    private int x;
    private int y;
    private MiniGameLauncher miniGameLauncher;
    private Scene scene;
    int money;
    
    public TransitionController (MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        counter = 0;
        //shows the game instructions at the top
        Label instructions = new Label(
                "Catch aliens for mula!\n"
        );
        instructions.setFont(Font.font("Cambria", 32));
        instructions.setTranslateY(-170);
        instructions.setTranslateX(20);
        instructions.setTextFill(Color.SKYBLUE);
        
        
        //shows the caught number of alien at the bottom
        Label caught = new Label(
                "Aliens caught: " + counter
        );
        caught.setFont(Font.font("Cambria", 22));
        caught.setTranslateX(220);
        caught.setTranslateY(170);
        caught.setTextFill(Color.SKYBLUE);
        
        
        StackPane root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT);
        

        
        //puts the background
        ImageView background = new ImageView(BACKGROUND);
        Image ALIEN = new Image(MainApplication.class.getResourceAsStream("creepy_alien.gif"));
        //makes the alien picture show up
        ImageView alien = new ImageView(ALIEN);
        
        alien.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        
        FadeTransition ft = new FadeTransition(Duration.millis(1000), alien);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
       
        Image RED_ALIEN = new Image(MainApplication.class.getResourceAsStream("red_alien.gif"));
        //makes the alien picture show up
        ImageView red_alien = new ImageView(RED_ALIEN);
      
        
        red_alien.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        
        ft = new FadeTransition(Duration.millis(1000), red_alien);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        Image COLORFUL_ALIEN = new Image(MainApplication.class.getResourceAsStream("colorful_beast.gif"));
        //makes the alien picture show up
        ImageView colorful_alien = new ImageView(COLORFUL_ALIEN);
       
        
        colorful_alien.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        
        ft = new FadeTransition(Duration.millis(1000), colorful_alien);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        Image PINK_ALIEN = new Image(MainApplication.class.getResourceAsStream("pink alien.gif"));
        //makes the alien picture show up
        ImageView pink_alien = new ImageView(PINK_ALIEN);
        
        
        ft = new FadeTransition(Duration.millis(1000), pink_alien);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        pink_alien.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        
        Image GREEN_ALIEN = new Image(MainApplication.class.getResourceAsStream("green_alien.gif"));
        //makes the alien picture show up
        ImageView green_alien = new ImageView(GREEN_ALIEN);
        
        green_alien.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), green_alien);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        
        //makes the alien picture show up
        ImageView yuck = new ImageView(GREEN_ALIEN);
        
        yuck.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), yuck);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        
        //makes the alien picture show up
        ImageView grecko = new ImageView(RED_ALIEN);
        
        grecko.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), grecko);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView boop = new ImageView(COLORFUL_ALIEN);
        
        boop.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), boop);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView pinky = new ImageView(PINK_ALIEN);
        
        pinky.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), pinky);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
         //makes the alien picture show up
        ImageView zoo = new ImageView(RED_ALIEN);
        
        zoo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), zoo);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView jug = new ImageView(ALIEN);
        
        jug.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), jug);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        
         //makes the alien picture show up
        ImageView fin = new ImageView(COLORFUL_ALIEN);
        
        fin.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), fin);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView kim = new ImageView(PINK_ALIEN);
        
        kim.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), kim);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
         //makes the alien picture show up
        ImageView yum = new ImageView(RED_ALIEN);
        
        yum.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), yum);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView hug = new ImageView(ALIEN);
        
        hug.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), hug);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        
        //makes the alien picture show up
        ImageView uu = new ImageView(GREEN_ALIEN);
        
        uu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), uu);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
         //makes the alien picture show up
        ImageView yy = new ImageView(RED_ALIEN);
        
        yy.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), yy);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //makes the alien picture show up
        ImageView zz = new ImageView(ALIEN);
        
        zz.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    counter++;
                    if (counter > 10) {           
                            try {
                                miniGameLauncher.exitMinigame(counter*100);
                            } catch(IOException exception) {
                                 System.err.println("ERROR: " + exception.getMessage());
                            }
                    }
                    caught.setText("Aliens caught: " + counter);
                }
        });
        ft = new FadeTransition(Duration.millis(1000), zz);
        ft.setFromValue(1);
        ft.setToValue(0.001);
        ft.setCycleCount(10);
        ft.play();
        
        //stackpane root element, add the root + its children
        //to the scene
       
        root.getChildren().add(background);
        root.getChildren().add(alien);
        root.getChildren().add(red_alien);
        root.getChildren().add(pink_alien);
        root.getChildren().add(green_alien);
        root.getChildren().add(colorful_alien);
        root.getChildren().add(instructions);
        root.getChildren().add(caught);
        root.getChildren().add(yuck);
        root.getChildren().add(grecko);
        root.getChildren().add(boop);
        root.getChildren().add(pinky);
        root.getChildren().add(zoo);
        root.getChildren().add(jug);
        root.getChildren().add(kim);
        root.getChildren().add(yum);
        root.getChildren().add(hug);
                root.getChildren().add(zz);
        root.getChildren().add(yy);
        root.getChildren().add(uu);
            alien.setTranslateX(100);
            alien.setTranslateY(100);
            green_alien.setTranslateX(-220);
            green_alien.setTranslateY(20);
            pink_alien.setTranslateX(-5);
            pink_alien.setTranslateY(30);
            red_alien.setTranslateX(150);
            red_alien.setTranslateY(-120);
            colorful_alien.setTranslateX(250);
            colorful_alien.setTranslateY(100);
            grecko.setTranslateX(-250);
            grecko.setTranslateY(-100);
            yuck.setTranslateX(-50);
            yuck.setTranslateY(-100);
            boop.setTranslateX(250);
            boop.setTranslateY(-100);
            pinky.setTranslateX(-50);
            pinky.setTranslateY(100);
             zz.setTranslateX(-50);
            zz.setTranslateY(0);
            yy.setTranslateX(0);
            yy.setTranslateY(-100);
            uu.setTranslateX(0);
            uu.setTranslateY(100);
            
            jug.setTranslateX(40);
            jug.setTranslateY(40);
            zoo.setTranslateX(-250);
            zoo.setTranslateY(100);
            
            kim.setTranslateX(250);
            kim.setTranslateY(190);
            
            yum.setTranslateX(90);
            yum.setTranslateY(-120);
            hug.setTranslateX(-250);
            hug.setTranslateY(180);
       //exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     public Scene getScene() {
        return scene;
        }
    public void exit() {
        System.exit(0);
    
    }
    
}
