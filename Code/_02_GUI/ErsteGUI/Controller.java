package _02_GUI.ErsteGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label lb1;
    @FXML
    private TextField tf1;

    public void bt1_onClick() {
        lb1.setText(tf1.getText());
    }
}
