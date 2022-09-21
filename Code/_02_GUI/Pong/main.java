package _02_GUI.Pong;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class
main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        pStage.setScene(scene);
        pStage.show();
        pStage.setTitle("Pong");

        Controller con = fxmlLoader.getController();

        //Spieler bewegen
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case W:
                        con.p1moveUp();
                        break;
                    case S:
                        con.p1moveDown();
                        break;
                    case UP:
                        con.p2moveUp();
                        break;
                    case DOWN:
                        con.p2moveDown();
                        break;

                }
                con.play();
            }
        });
    }
}
