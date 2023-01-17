package _03_DynDsLin.Queue.mitWartezimmer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AP_Controller {
    @FXML private Button btStart; //Praxis öffnen
    @FXML private Button btIsEmpty; //Wartezimmer gefüllt
    @FXML private Button btEnqueue; //Patient ins Wartezimmer
    @FXML private Button btFront; //Nächster Patient
    @FXML private Button btDequeue; //Nächster Patient ins Arztzimmer
    @FXML private Button btNotfall; //Patient an den Anfang der Schlange setzen

    @FXML private Label lblIsEmpty;
    @FXML private Label lblFront;

    @FXML private TextField tfEnqueue;
    @FXML private TextField tfNotfall;

    @FXML private ListView lvWartezimmer;

    private AP_Queue <String> queuePatienten;

    public void btStart_onClick() {
        btIsEmpty.setDisable(false);
        btEnqueue.setDisable(false);
        btFront.setDisable(false);
        btNotfall.setDisable(false);

        lblIsEmpty.setDisable(false);
        lblFront.setDisable(false);

        tfEnqueue.setDisable(false);
        tfNotfall.setDisable(false);

        lvWartezimmer.getItems().clear();
        lvWartezimmer.setDisable(false);

        queuePatienten = new AP_Queue<>();
    }

    public void btIsEmpty_onClick(){
        if (queuePatienten.isEmpty()){
            lblIsEmpty.setText("Wartezimmer leer!");
            btDequeue.setDisable(true);
        }
        else {
            lblIsEmpty.setText("Patienten im Wartezimmer!");
            btDequeue.setDisable(false);
        }
    }

    public void btEnqueue_onClick(){
        String neuerPatient = tfEnqueue.getText();
        queuePatienten.enqueue(neuerPatient);
        gibAus();
        tfEnqueue.setText("");
    }

    public void btDequeue_onClick(){
        queuePatienten.dequeue();
        gibAus();
    }

    public void btFront_onClick(){
        if (queuePatienten.isEmpty()){
            lblFront.setText("Wartezimmer leer!");
        }
        else {
            if (queuePatienten.front().length() >= 20){
                //Abfrage aus nächster Zeile zuerst
                //(Anfang == [PRIORITY/EMERGENCY] würde Fehler auslösen
                //(Substring anwendung bei kürzeren Strings)
                //Beugung der Queue-Regeln
                if (queuePatienten.front().substring(0, 20).equals("[PRIORITY/EMERGENCY]")) {
                    //Der Titel [PRIORITY/EMERGENCY] wird entfernt
                    lblFront.setText(String.valueOf(queuePatienten.front()).substring(21));
                }
            }
            else lblFront.setText(String.valueOf(queuePatienten.front()));
        }
    }

    public void btNotfall_onClick(){ //Methode, um Patienten an den Anfang der Queue zu setzen
        String notfallPatient = "[PRIORITY/EMERGENCY] " + tfNotfall.getText();
        queuePatienten.frontEnqueue(notfallPatient);
        gibAus();
        tfNotfall.setText("");
    }

    public void gibAus(){
        AP_Queue <String> queuePatientenKopie = new AP_Queue <String> ();
        //ListView löschen
        lvWartezimmer.getItems().clear();
        //Listview über Hilfsqueue rekonstruieren, Queue löschen
        while (!queuePatienten.isEmpty()){
            lvWartezimmer.getItems().add(queuePatienten.front());
            queuePatientenKopie.enqueue(queuePatienten.front());
            queuePatienten.dequeue();
        }
        //Queue rekonstruieren, Hilfsqueue löschen
        while (!queuePatientenKopie.isEmpty()){
            queuePatienten.enqueue(queuePatientenKopie.front());
            queuePatientenKopie.dequeue();
        }
    }
}