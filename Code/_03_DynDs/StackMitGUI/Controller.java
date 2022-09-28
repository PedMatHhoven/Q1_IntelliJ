package _03_DynDs.StackMitGUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfIsEmpty;
    @FXML private TextField tfPush;
    @FXML private TextField tfTop;
    private Stack <String> s;

    public void btStack_click() {
        s = new Stack <String> ();
    }

    public void btIsEmpty_click() {
        if (s.isEmpty()) tfIsEmpty.setText("ja - leer!"); else tfIsEmpty.setText("nicht leer!");
    }

    public void btPush_click() {
    }

    public void btPop_click() {
    }

    public void btTop_click() {
    }
}
