package _02_GUI.Umdreher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label lb1;
    @FXML
    private TextField tf1;

    public void bt1_onClick() {
        String wort = tf1.getText();
        int laenge = wort.length();
        String hilfe = "";
        for (int i=0; i <= laenge-1; i++) hilfe = hilfe + wort.charAt(laenge-i-1);
        lb1.setText(hilfe);
    }
}