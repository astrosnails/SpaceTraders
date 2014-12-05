package spacetraders.minigames;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;
import spacetraders.minigames.MiniGameLauncher;

public class PongController {
    DoubleProperty centerX = new SimpleDoubleProperty();
    DoubleProperty centerY = new SimpleDoubleProperty();
    DoubleProperty bottomPaddleX = new SimpleDoubleProperty();
    double bottomPaddleDragAnchorX;
    double initbottomPaddleTranslateX;
    Circle ball;
    Group pongComponents;
    Rectangle bottomPaddle;
    Rectangle topWall;
    Rectangle rightWall;
    Rectangle leftWall;
    Rectangle bottomWall;
    Button startButton;
    BooleanProperty startVisible = new SimpleBooleanProperty(true);
    private Scene scene;
    private MiniGameLauncher miniGameLauncher;
    int money; 
  
    public PongController(MiniGameLauncher miniGameLauncher) {
        this.miniGameLauncher = miniGameLauncher;
        
        scene  = SceneBuilder.create()
        .width(500)
        .height(500)
        .fill(
          LinearGradientBuilder.create()
            .startX(0.0)
            .startY(0.0)
            .endX(0.0)
            .endY(1.0)
            .stops(
              new Stop(0.0, Color.BLACK),
              new Stop(0.0, Color.GRAY)
             )
            .build()
        )
        .root(
          pongComponents = GroupBuilder.create()
            .focusTraversable(true)
            .children(
              ball = CircleBuilder.create()
                .radius(5.0)
                .fill(Color.RED)
                .build(),
              topWall = RectangleBuilder.create()
                .x(0)
                .y(0)
                .width(500)
                .height(1)
                .build(),
              leftWall = RectangleBuilder.create()
                .x(0)
                .y(0)
                .width(1)
                .height(500)
                .build(),
              rightWall = RectangleBuilder.create()
                .x(500)
                .y(0)
                .width(1)
                .height(500)
                .build(),
              bottomWall = RectangleBuilder.create()
                .x(0)
                .y(500)
                .width(500)
                .height(1)
                .build(),
              bottomPaddle = RectangleBuilder.create()
                .x(-50)
                .y(490)
                .width(100)
                .height(10)
                .fill(Color.YELLOW)
                .cursor(Cursor.HAND)
                .onMousePressed(new EventHandler<MouseEvent>() {
                  public void handle(MouseEvent me) {
                    initbottomPaddleTranslateX =  bottomPaddle.getTranslateX();
                    bottomPaddleDragAnchorX = me.getSceneY();
                  }
                })
                .onMouseDragged(new EventHandler<MouseEvent>() {
                  public void handle(MouseEvent me) {
                    double dragX = me.getSceneY() - bottomPaddleDragAnchorX;
                    bottomPaddleX.setValue(initbottomPaddleTranslateX + dragX);
                  }
                })
                .build(),
              startButton = ButtonBuilder.create()
                .layoutX(0)
                .layoutY(0)
                .text("The more you hit the ball, the more money you will get!")
                .onAction(new EventHandler<javafx.event.ActionEvent>() {
                  @Override public void handle(javafx.event.ActionEvent e) {
                    startVisible.set(false);
                    pongAnimation.playFromStart();
                    pongComponents.requestFocus();
                  }
                })
                .build()
            )
            .onKeyPressed(new EventHandler<KeyEvent>() {
              @Override public void handle(KeyEvent k) {

                if (k.getCode() == KeyCode.LEFT &&
                    !bottomPaddle.getBoundsInParent().intersects(leftWall.getBoundsInLocal())) {
                  bottomPaddleX.setValue(bottomPaddleX.getValue() - 6);
                }
                else if (k.getCode() == KeyCode.RIGHT &&
                    !bottomPaddle.getBoundsInParent().intersects(rightWall.getBoundsInLocal())) {
                  bottomPaddleX.setValue(bottomPaddleX.getValue() + 6);
                }
              }
            })  
            .build()
        )
        .build();

        ball.centerXProperty().bind(centerX);
        ball.centerYProperty().bind(centerY);
        bottomPaddle.translateXProperty().bind(bottomPaddleX);
        startButton.visibleProperty().bind(startVisible);

        initialize();
    }
  
  
  Timeline pongAnimation = TimelineBuilder.create()
    .keyFrames(
      new KeyFrame(
        new Duration(10.0),
        new EventHandler<ActionEvent>() {
          public void handle(javafx.event.ActionEvent t) {
            checkForCollision();
            int horzPixels = movingRight ? 1 : -1;
            int vertPixels = movingDown ? 1 : -1;
            centerX.setValue(centerX.getValue() + horzPixels);
            centerY.setValue(centerY.getValue() + vertPixels);
          }
        }
      )
    )
    .cycleCount(Timeline.INDEFINITE)
    .build();

  boolean movingRight = true;
  boolean movingDown = true;

  void initialize() {
    centerX.setValue(250);
    centerY.setValue(250);
    bottomPaddleX.setValue(235);
    startVisible.set(true);
    pongComponents.requestFocus();
  }

  void checkForCollision() {
    if (false && ball.intersects(bottomWall.getBoundsInLocal())) {
      pongAnimation.stop();
      initialize();
    }
    else if (ball.intersects(rightWall.getBoundsInLocal()) ||
              ball.intersects(leftWall.getBoundsInLocal()) ) {
      movingRight = !movingRight;
    }
    else if (ball.intersects(topWall.getBoundsInLocal()) || 
            (ball.intersects(bottomPaddle.getBoundsInParent()))) {
      movingDown = !movingDown;
    if (ball.intersects(bottomPaddle.getBoundsInParent())) {
            money++;
     }
  }
}
  
  public static void main(String[] args) {
    Application.launch(args);
  }
  
    public Scene getScene() {
        return scene;
    }
}