package _03_DynDs.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfIsEmpty;
    @FXML private TextField tfHasAccess;
    @FXML private TextField tfGetContent;
    @FXML private TextField tfSetContent;
    @FXML private TextField tfAppend;
    @FXML private TextField tfInsert;
    @FXML private ListView lv;
    @FXML private Button btIsEmpty;
    @FXML private Button btHasAccess;
    @FXML private Button btNext;
    @FXML private Button btToFirst;
    @FXML private Button btToLast;
    @FXML private Button btGetContent;
    @FXML private Button btSetContent;
    @FXML private Button btAppend;
    @FXML private Button btInsert;
    @FXML private Button btConcat;
    @FXML private Button btRemove;

    private List<String> l;

    public void btList_click() {
        l = new List<String>();
        gibAus();
        btIsEmpty.setDisable(false);
        btHasAccess.setDisable(false);
        btNext.setDisable(false);
        btToFirst.setDisable(false);
        btToLast.setDisable(false);
        btGetContent.setDisable(false);
        btSetContent.setDisable(false);
        btAppend.setDisable(false);
        btInsert.setDisable(false);
        btConcat.setDisable(false);
        btRemove.setDisable(false);
    }

    public void btIsEmpty_click() {
        if (l.isEmpty()) tfIsEmpty.setText("ja - leer!"); else tfIsEmpty.setText("nicht leer!");
    }

    public void btHasAccess_click() {
        if (l.hasAccess()) tfHasAccess.setText("ja - akt.!"); else tfHasAccess.setText("kein akt.");
    }

    public void btNext_click() {
        l.next();
        gibAus();
    }

    public void btToFirst_click() {
        l.toFirst();
        gibAus();
    }

    public void btToLast_click() {
        l.toLast();
        gibAus();
    }

    public void btGetContent_click() {
        tfGetContent.setText(l.getContent());
    }

    public void btSetContent_click() {
        l.setContent(tfSetContent.getText());
        gibAus();
    }

    public void btAppend_click() {
        l.append(tfAppend.getText());
        gibAus();
    }

    public void btInsert_click() {
        l.insert(tfInsert.getText());
        gibAus();
    }

    public void btConcat_click() {
        //neue Liste l2 aufbauen!?
        l.concat(l);
        gibAus();
    }

    public void btRemove_click() {
        l.remove();
        gibAus();
    }

    public void gibAus() {
        //Ausgabe über Hilfsliste
        List <String> l2 = new List <String> ();
        List <String> l3 = new List <String> ();
        l3.current = l.current;
        lv.getItems().clear();
        while (!l.isEmpty()){
            //vorderstes Element ausgeben + zwischenspeichern auf Hilfsliste + löschen
            l.toFirst();
            lv.getItems().add(l.getContent());
            l2.append(l.getContent());
            l.remove();
        }
        //List rekonstruieren (und Hilfsliste leeren)
        while (!l2.isEmpty()){
            l2.toFirst();
            l.append(l2.getContent());
            l2.remove();
        }
        l.current = l3.current;
    }
}
