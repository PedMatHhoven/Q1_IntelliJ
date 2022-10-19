package _01_Wiederholung_EF.Wdh_Loesungen.ProjektWas;

import _03_DynDs.StackMitGUI.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfIsEmpty;
    @FXML private TextField tfPush;
    @FXML private TextField tfTop;
    @FXML private TextField tfKlammern;
    @FXML private TextField tfKopie;
    @FXML private ListView lv;
    @FXML private Button btIsEmpty;
    @FXML private Button btPush;
    @FXML private Button btPop;
    @FXML private Button btTop;
    @FXML private Button btKlammern;
    @FXML private Button btKopie;

    private Stack<String> s;

    public void btStack_click() {
        s = new Stack <String> ();
        gibAus();
        btIsEmpty.setDisable(false);
        btPush.setDisable(false);
        btPop.setDisable(false);
        btTop.setDisable(false);
        btKlammern.setDisable(false);
        btKopie.setDisable(false);
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

    public void btKopie_click() {
        String k = tfKlammern.getText();
        tfKopie.setText(k);
    }

    public void btKlammern_click() {
        String k = tfKlammern.getText();
        if (!k.equals("") && (k.charAt(0)=='(' || k.charAt(0)=='[' || k.charAt(0)=='{')) {
            s.push(k.substring(0,1));
            gibAus();
            k = k.substring(1);
            tfKlammern.setText(k);
        }
        else if (!k.equals("") && !s.isEmpty() &&
                (k.charAt(0)==')' && s.top().equals("(") ||
                k.charAt(0)==']' && s.top().equals("[") ||
                k.charAt(0)=='}' && s.top().equals("{"))) {
            s.pop();
            gibAus();
            k = k.substring(1);
            tfKlammern.setText(k);
            if (s.isEmpty() && k.equals("")) {
                tfKlammern.setText("wohlgef. :)");
            }
        }
        else {
            tfKlammern.setText("inakzept.!");
            s = new Stack();
            gibAus();
        }
    }


}
