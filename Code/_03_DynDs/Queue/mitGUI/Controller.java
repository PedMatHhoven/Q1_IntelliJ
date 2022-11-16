package _03_DynDs.Queue.mitGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfIsEmpty;
    @FXML private TextField tfEnqueue;
    @FXML private TextField tfFront;
    @FXML private ListView lv;
    @FXML private Button btIsEmpty;
    @FXML private Button btEnqueue;
    @FXML private Button btDequeue;
    @FXML private Button btFront;

    private Queue <String> q;

    public void btQueue_click() {
        q = new Queue <String>();
        gibAus();
        btIsEmpty.setDisable(false);
        btEnqueue.setDisable(false);
        btDequeue.setDisable(false);
        btFront.setDisable(false);
    }

    public void btIsEmpty_click() {
        if (q.isEmpty()) tfIsEmpty.setText("ja - leer!"); else tfIsEmpty.setText("nicht leer!");
    }

    public void btEnqueue_click() {
        q.enqueue(tfEnqueue.getText());
        gibAus();
    }

    public void btDequeue_click() {
        q.dequeue();
        gibAus();
    }

    public void btFront_click() {
        tfFront.setText("" + q.front());
    }

    public void gibAus() {
        //Ausgabe über Hilfsschlange
        Queue <String> q2 = new Queue <String> ();
        lv.getItems().clear();
        while (!q.isEmpty()){
            //vorderstes Element ausgeben + zwischenspeichern auf Hilfsschlange + löschen
            lv.getItems().add(q.front());
            q2.enqueue(q.front());
            q.dequeue();
        }
        //Queue rekonstruieren (und Hilfsschlange leeren)
        while (!q2.isEmpty()){
            q.enqueue(q2.front());
            q2.dequeue();
        }
    }
}
