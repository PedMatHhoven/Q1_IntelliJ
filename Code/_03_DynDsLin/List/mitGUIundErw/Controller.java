package _03_DynDsLin.List.mitGUIundErw;

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
    @FXML private TextField tfCount;
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
    @FXML private Button btPrevious;
    @FXML private Button btCount;
    @FXML private Button btDreheUm;
    @FXML private Button btTauscheRechts;

    //damit auch erweiterte Methoden abrufbar!
    private ListErw <String> l;

    public void btListErw_click() {
        l = new ListErw();
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
        btPrevious.setDisable(false);
        btCount.setDisable(false);
        btDreheUm.setDisable(false);
        btTauscheRechts.setDisable(false);
    }

    public void btIsEmpty_click() {
        if (l.isEmpty()) tfIsEmpty.setText("ja - leer!"); else tfIsEmpty.setText("nicht leer!");
    }

    public void btHasAccess_click() {
        if (l.hasAccess()) tfHasAccess.setText("ja - current!"); else tfHasAccess.setText("kein current!");
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
        List <String> l2 = new List <String> ();
        l2.append("1"); l2.append("2"); l2.append("3");
        l.concat(l2);
        gibAus();
    }

    public void btRemove_click() {
        l.remove();
        gibAus();
    }

    public void btPrevious_click() {
        l.current = l.getPrevious(l.current);
        gibAus();
    }

    public void btCount_click() {
        tfCount.setText(String.valueOf(l.count()));
    }

    public void btDreheUm_click() {
        l.dreheUm();
        gibAus();
    }

    public void btTauscheRechts_click() {
        l.tauscheRechts();
        gibAus();
    }

    public void gibAus() {
        //Hilfsliste l2 - (nur) für einen Hilfszeiger
        List l2 = new List();
        l2.current = l.current; //zwischenspeichern
        lv.getItems().clear();
        l.toFirst();
        while (l.hasAccess()) {
            if (l.current == l2.current) {
                lv.getItems().add(l.getContent() + " - current!");
            } else {
                lv.getItems().add(l.getContent());
            }
            l.next();
        }
        l.current = l2.current; //zurücksetzen
    }
}