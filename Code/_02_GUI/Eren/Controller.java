package _02_GUI.Eren;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Controller {
    @FXML
    Rectangle p1, p2;
    @FXML
    Circle ball;
    @FXML
    AnchorPane field;
    @FXML
    Label score1, score2;

    //Variablen um den Ball zu bewegen
    double x = 2;
    double y = 2;
    //Spieler bewegen
    public void p1moveUp(){
        p1.setLayoutY(p1.getLayoutY() - 20);
    }
    public void p1moveDown(){
        p1.setLayoutY(p1.getLayoutY() + 20);
    }
    public void p2moveUp(){
        p2.setLayoutY(p2.getLayoutY() - 20);
    }
    public void p2moveDown(){
        p2.setLayoutY(p2.getLayoutY() + 20);
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            //Ball bewegen
            ball.setLayoutY(ball.getLayoutY() + y);
            ball.setLayoutX(ball.getLayoutX() + x);

         Bounds bounds = field.getBoundsInLocal();

         //Wandberührung
         if (ball.getLayoutX() == bounds.getMaxX() - ball.getRadius()){
             ball.setLayoutY(60);
             ball.setLayoutX(295);
             score1.setText(String.valueOf(Integer.parseInt(score1.getText()) + 1));
         }
         if (ball.getLayoutX() == bounds.getMinX() + ball.getRadius()){
             ball.setLayoutY(60);
             ball.setLayoutX(295);
             score2.setText(String.valueOf(Integer.parseInt(score2.getText()) + 1));
         }
         if (ball.getLayoutY() == bounds.getMaxY() - ball.getRadius() || ball.getLayoutY() == bounds.getMinY() + ball.getRadius()){
             y *= -1;
         }

         //Abprallen an Spielern
         if(ball.getBoundsInParent().intersects(p1.getBoundsInParent())){
             x *= -1;
         }
         if(ball.getBoundsInParent().intersects(p2.getBoundsInParent())){
             x *= -1;
         }
        }
    }));

    //Spiel starten
    public void play(){
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
