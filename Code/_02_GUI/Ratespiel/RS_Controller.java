package _02_GUI.Ratespiel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.util.Random;

public class RS_Controller {
    @FXML
    Button bt_Start;
    @FXML
    Button bt_Eingabe;
    @FXML
    TextField tf_Eingabe;
    @FXML
    Label lbl_Loesung;

    private int gesuchteZahl;
    private int anzahlVersuche;

    public void bt_Start_onClick(ActionEvent actionEvent){
        Random random = new Random();
        gesuchteZahl = random.nextInt(0, 100);
        lbl_Loesung.setText("Zu suchende Zahl wurde ermittelt. Viel Glück beim Finden!");
    }

    public void bt_Eingabe_onClick(ActionEvent actionEvent){
        anzahlVersuche += 1;
        int eingabe = Integer.valueOf(tf_Eingabe.getText().toString());
        if (eingabe == gesuchteZahl){
            lbl_Loesung.setText
            ("Sie haben in " + anzahlVersuche + " Versuchen die gesuchte Zahl "+ gesuchteZahl + " erraten! Glückwunsch!");
        }
        else if (eingabe < gesuchteZahl) {
            lbl_Loesung.setText("Die gesuchte Zahl ist größer als Ihre Eingabe!");
        }
        else if (eingabe > gesuchteZahl) {
            lbl_Loesung.setText("Die gesuchte Zahl ist kleiner als Ihre Eingabe!");
        }
    }
}