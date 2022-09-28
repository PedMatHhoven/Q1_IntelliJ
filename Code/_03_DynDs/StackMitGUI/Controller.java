package _03_DynDs.StackMitGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfIsEmpty;
    @FXML private TextField tfPush;
    @FXML private TextField tfTop;
    @FXML private ListView lv;
    @FXML private Button btIsEmpty;
    @FXML private Button btPush;
    @FXML private Button btPop;
    @FXML private Button btTop;

    private Stack <String> s;

    public void btStack_click() {
        s = new Stack <String> ();
        gibAus();
        btIsEmpty.setDisable(false);
        btPush.setDisable(false);
        btPop.setDisable(false);
        btTop.setDisable(false);
    }

    public void btIsEmpty_click() {
        if (s.isEmpty()) tfIsEmpty.setText("ja - leer!"); else tfIsEmpty.setText("nicht leer!");
    }

    public void btPush_click() {
        s.push(tfPush.getText());
        gibAus();
    }

    public void btPop_click() {
        s.pop();
        gibAus();
    }

    public void btTop_click() {
        tfTop.setText("" + s.top());
    }

    public void gibAus() {
        //Ausgabe über Hilfsstack
        Stack <String> s2 = new Stack <String> ();
        lv.getItems().clear();
        while (!s.isEmpty()){
            //vorderstes Element ausgeben + zwischenspeichern auf Hilfsstack + löschen
            lv.getItems().add(s.top());
            s2.push(s.top());
            s.pop();
        }
        //Stack rekonstruieren (und Hilfsstack leeren)
        while (!s2.isEmpty()){
            s.push(s2.top());
            s2.pop();
        }
    }
}
