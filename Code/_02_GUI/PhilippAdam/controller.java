package _02_GUI.PhilippAdam;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

// Projekt von Adam Hahne und Philipp Glasovac, Q1

public class controller {
    // Definition wichtiger Variablen
    @FXML
    private Label lb1;
    static String Anzeige = "";
    static int Reihenfolgekontrolle = 0;
    static int rechenorder = 0;
    static int[] rechnung = new int[2];
    static float ergebnis = 0;
    static float ergebnis_2 = 0;
    static String rechenmethode;
    static String[] rechenmethoden = {"+", "-", "*", "/"};

    // Zahleneingabe durch Button
    public void bt1_onAction() {
        Anzeige = Anzeige.concat("1");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt2_onAction() {
        Anzeige = Anzeige.concat("2");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt3_onAction() {
        Anzeige = Anzeige.concat("3");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt4_onAction() {
        Anzeige = Anzeige.concat("4");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt5_onAction() {
        Anzeige = Anzeige.concat("5");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt6_onAction() {
        Anzeige = Anzeige.concat("6");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt7_onAction() {
        Anzeige = Anzeige.concat("7");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt8_onAction() {
        Anzeige = Anzeige.concat("8");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt9_onAction() {
        Anzeige = Anzeige.concat("9");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }
    public void bt0_onAction() {
        Anzeige = Anzeige.concat("0");
        lb1.setText(Anzeige);
        Reihenfolgekontrolle = 0;
    }

    // Rechenmethoden
    public void btplus_onAction() {
        if (Reihenfolgekontrolle == 1) {
            System.out.println("Geht nicht!");
        } else {
            Anzeige = Anzeige.concat(" + ");
            lb1.setText(Anzeige);
        }
        Reihenfolgekontrolle = 1;
        rechenmethode = "+";
    }

    public void btminus_onAction() {
        if (Reihenfolgekontrolle == 1) {
            System.out.println("Geht nicht!");
        } else {
            Anzeige = Anzeige.concat(" - ");
            lb1.setText(Anzeige);
        }
        Reihenfolgekontrolle = 1;
        rechenmethode = "-";
    }
    public void btmal_onAction() {
        if (Reihenfolgekontrolle == 1) {
            System.out.println("Geht nicht!");
        } else {
            Anzeige = Anzeige.concat(" * ");
            lb1.setText(Anzeige);
        }
        Reihenfolgekontrolle = 1;
        rechenmethode = "*";
    }
    public void btgeteilt_onAction() {
        if (Reihenfolgekontrolle == 1) {
            System.out.println("Geht nicht!");
        } else {
            Anzeige = Anzeige.concat(" / ");
            lb1.setText(Anzeige);
        }
        Reihenfolgekontrolle = 1;
        rechenmethode = "/";
    }

    // Ausrechnungsverfahren
    public void btgleich_onAction() {
        int test;

        for (int i = 0; i <= 3; i++) {
            if (rechenmethode.equals(rechenmethoden[i])) {
                test = Anzeige.indexOf(" " + rechenmethoden[i] + " ");
                String erste_Zahl = Anzeige.substring(test - 1, test);
                String zweite_Zahl = Anzeige.substring(test + 3);
                int zahl_umgewandelt = Integer.valueOf(erste_Zahl);
                int zahl_umgewandelt_2 = Integer.valueOf(zweite_Zahl);
                rechnung[rechenorder] = zahl_umgewandelt;
                rechenorder += 1;
                rechnung[rechenorder] = zahl_umgewandelt_2;
                zahl_umgewandelt = 0;
                zahl_umgewandelt_2 = 0;
            }
        }

        if (rechenmethode.equals("+")) {
            for (int i = 0; i <= 1; i++){
                ergebnis = ergebnis + rechnung[i];
            }

        } else if (rechenmethode.equals("-")) {
            int i = 0;
            ergebnis = rechnung[i] - rechnung[i + 1];

        } else if (rechenmethode.equals("*")) {
            int i = 0;
            ergebnis = rechnung[i] * rechnung[i + 1];

        } else {
            int i = 0;
            ergebnis = rechnung[i] / rechnung[i + 1];
        }

        System.out.println("Das Ergebnis ist: " + ergebnis);
    }

    public void btdelete_onAction() {
        // Der Löschen-Button wird noch programmiert...
        Anzeige = "";
        lb1.setText(Anzeige);
    }
}