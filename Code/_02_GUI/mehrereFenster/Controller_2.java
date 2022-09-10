package _02_GUI.mehrereFenster;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_2 {
    @FXML
    Button bt3;

    public void bt2_onClick(ActionEvent actionEvent) throws IOException {
        //soll auch ein neues Fenster "3" erstellen
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Fenster 3");
    }

    public void bt3_onClick(ActionEvent actionEvent) throws IOException {
        //soll das aktuelle Fenster ändern/ überschreiben
        Stage stage = (Stage) bt3.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Fenster 3");
    }
}
