package _03_DynDs.Stack.mitUPN;

import _03_DynDs.Stack.mitUPN.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField tfUPN;
    @FXML private TextField tfKopie;
    @FXML private ListView lv;
    @FXML private Button btUPN;
    @FXML private Button btKopie;

    private Stack<String> s;

    public void btStack_click() {
        s = new Stack<String>();
        gibAus();
        btUPN.setDisable(false);
        tfUPN.setDisable(false);
        btKopie.setDisable(false);
    }

    public void gibAus() {
        //Ausgabe über Hilfsstack
        Stack<String> s2 = new Stack<String>();
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
        String k = tfUPN.getText();
        tfKopie.setText(k);
    }

    public void btUPN_click() {
        //Berechnung eines (korrekt eingegebenen) Integer-UPN-Terms
        //(mit Leerstellen, auch am Ende!) zum Schluss steht das Ergebnis auf dem Stack!
        String t = tfUPN.getText();
        //suche erste Leerstelle (Trenn-Markierung)
        int pos = t.indexOf(" ");
        //Auswertung aller Fälle - bei Operator Rechnung, bei Zahl push
        switch (t.charAt(0)) {
            case '+','-','*','/':
                int b = Integer.parseInt(s.top()); s.pop();
                int a = Integer.parseInt(s.top()); s.pop();
                switch(t.charAt(0)) {
                    case '+': s.push(String.valueOf(a + b)); break;
                    case '-': s.push(String.valueOf(a - b)); break;
                    case '*': s.push(String.valueOf(a * b)); break;
                    case '/': s.push(String.valueOf(a / b)); break;
                }
                break;
            default: s.push(t.substring(0, pos));
        }
        //Anpassen des Terms
        if (t.length()>0) t = t.substring(pos+1);
        //Deaktivieren von Elementen (wenn Term abgearbeitet)
        if (t.length()==0) {
            btUPN.setDisable(true);
            tfUPN.setDisable(true);
            btKopie.setDisable(true);
        }
        gibAus();
        tfUPN.setText(t);
    }
}
