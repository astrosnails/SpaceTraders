/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package spacetraders.minigames;
import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import spacetraders.MainApplication;
import spacetraders.minigames.MiniGameLauncher;


/**
 *
 * @author Hifza
 */
public class QuizController {
    //private final Image BACKGROUND = new Image(getClass().getResourceAsStream("background.jpg"));
    private final Image BACKGROUND = new Image(MainApplication.class.getResource("background2.png").toString());
    private static final Random RNG = new Random();
    private MiniGameLauncher miniGameLauncher;
    private Scene scene;
    private int money;
    private boolean answer;
    
     public QuizController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        ImageView background = new ImageView(BACKGROUND);
        StackPane root = new StackPane();
        
        root.getChildren().add(background);
        
        scene = new Scene(root, 500, 450);
       
        Label label1;   
        int type = RNG.nextInt(6);
	    
	        switch (type) {
	        case 0: label1 = new Label("2 ^ 10 = ?")  ;
	        break ;

	        case 1: label1 = new Label("2 ^ 8  =  ?")  ;
	        break ; 
                                
                             case 2: label1 = new Label("1 byte  = ? bits")  ;
	        break ;
                        
                             case 3: label1 = new Label("1 int  = ? bytes")  ;
	        break ;
                        
                             case 4: label1 = new Label("1 short  = ? bytes")  ;
	        break ;
                        
                             case 5: label1 = new Label("1 char  = ? bytes")  ;
	        break ;
                            //Change to a picture of an alien
	        default: label1 = new Label("2 x 32 = ? G")  ;
	        break ;
	        }
        label1.setFont(Font.font("Cambria", 24));
        label1.setTranslateY(-170);
        label1.setTranslateX(-150);
        label1.setTextFill(Color.ORANGE);
        TextField textField = new TextField ();
     
        
         Label label2 = new Label("");
        label2.setFont(Font.font("Cambria", 24));
        label2.setTranslateY(190);
        label2.setTranslateX(-120);
        label2.setTextFill(Color.ORANGE);
       
        textField.setTranslateY(-170);
        textField.setTranslateX(200);
        
        Button submit = new Button(); 
        submit.setText("Submit");
         submit.setTranslateY(190);
        submit.setTranslateX(180);
        root.getChildren().add(submit);
        root.getChildren().add(label2);
        submit.setOnAction(new EventHandler<ActionEvent>() {

@Override
    public void handle(ActionEvent e) {
        if ((textField.getText() != null && !textField.getText().isEmpty())) {
            if ((textField.getText().equals("1024") && label1.getText().equals("2 ^ 10 = ?")) ||
               (textField.getText().equals("256") && label1.getText().equals("2 ^ 8  =  ?")) ||
               (textField.getText().equals("8") && label1.getText().equals("1 byte  = ? bits"))   ||
                    (textField.getText().equals("4") && label1.getText().equals("1 int  = ? bytes")) || 
                    (textField.getText().equals("2") && label1.getText().equals("1 short  = ? bytes")) || 
                    (textField.getText().equals("1") && label1.getText().equals("1 char  = ? bytes")) || 
                    (textField.getText().equals("4") && label1.getText().equals("2 x 32 = ? G"))) {
              
                 money++;
                 answer = true;
                 label2.setText("Correct! Money++");
                 try {
                miniGameLauncher.exitMinigame(money*100);
           } catch(IOException exception) {
                System.err.println("ERROR: " + exception.getMessage());
           }
             } else {
                 answer = false;
                label2.setText("You got it wrong!");
                try {
                miniGameLauncher.exitMinigame(money*100);
           } catch(IOException exception) {
                System.err.println("ERROR: " + exception.getMessage());
           }
            }
        } else {
            label2.setText("Didn't submit!");
        }
        
     }
        
    });
        root.getChildren().add(label1);
        root.getChildren().add(textField);
        
     };
        
     
     

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public Scene getScene() {
        return scene;
    }
    
}
