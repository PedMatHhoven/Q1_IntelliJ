package _02_GUI.ZweiteGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        //immer wieder diese vier Zeilen schreiben, damit in Erinnerung,
        //falls copy-paste mal nicht geht!
        //Fenster in Abhängigkeit einer fxml-Datei vorbereiten
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml.fxml"));
        //Szene wird auf Grundlage des fxml-Datei kreiert
        Scene scene = new Scene(fxmlLoader.load());
        //die Bühne bekommt die gerade definierte Szene
        pStage.setScene(scene);
        //die Bühne wird gezeigt
        pStage.show();
    }
}
