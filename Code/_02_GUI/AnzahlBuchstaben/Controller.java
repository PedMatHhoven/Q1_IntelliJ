package _02_GUI.AnzahlBuchstaben;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label lb1;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;

    public static int count(String s, char a) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == a) i += 1;
        }
        return i;
    }

    public void bt1_onClick() {
        String eingabe = tf1.getText();
        char suchstabe = tf2.getText().charAt(0);
        int x = count(eingabe, suchstabe);
        lb1.setText("Buchstabe ist " + x + " mal vorhanden!");
    }

    public void bt2_onClick(ActionEvent actionEvent) {
        tf1.setText("Hier Text eingeben!");
        tf2.setText("Welchen Buchstaben suchen?");
        lb1.setText("Ausgabe");
    }
}