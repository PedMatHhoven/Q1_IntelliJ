package _02_GUI.mehrereFenster;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    //folgende Attribute benötigt man nur bei Verwendung der Version ganz unten!
    /*@FXML
    Button bFenster2;
    @FXML
    Button bFenster3;*/
    //hier werden - abhängig vom Button - verschieden-artige Fenster vom selben Hauptfenster aus geöffnet
    //bei jedem Klick wird ein komplett neues Fenster erstellt!
    public void oeffneFenster_2(ActionEvent actionEvent) throws IOException {
        //Erzeugen eines neuen Fensters läuft im Prinzip identisch wie in der Main
        Stage stage = new Stage(); //lediglich eine neue Bühne muss zu Beginn erzeugt werden!
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Fenster 2");
    }

    public void oeffneFenster_3(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Fenster 3");
    }

    //in der folgenden Version wird auf Eigenschaften der Buttons eingegangen,
    //weshalb diese über das pEvent angesprochen werden müssen;
    //einfachere Version aber oben
    //- verschiedene Buttons erhalten verschiedene Methoden
    //- unten haben beide Buttons dieselbe Methode!
    /*public void oeffneFenster(ActionEvent pEvent) throws IOException {
        String nameFXML = "";
        Button sourceButton = (Button) pEvent.getSource();
        if (sourceButton == bFenster1) {
            nameFXML = "fxml_2.fxml";
        } else if (sourceButton == bFenster2) {
            nameFXML = "fxml_3.fxml";
        } else {
            new Alert(Alert.AlertType.ERROR, "Button nicht erkannt").showAndWait();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(nameFXML));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(sourceButton.getText());
        stage.setScene(scene);
        stage.show();
    }*/
}
