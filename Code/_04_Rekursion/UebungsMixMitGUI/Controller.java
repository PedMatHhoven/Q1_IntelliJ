package _04_Rekursion.UebungsMixMitGUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML private Label lbFakultaetRek;
    @FXML private Label lbFakultaetIt;
    @FXML private Label lbSummeBisRek;
    @FXML private Label lbSummeBisIt;
    @FXML private Label lbSpiegelwortRek;
    @FXML private Label lbSpiegelwortIt;
    @FXML private Label lbQuersummeRek;
    @FXML private Label lbQuersummeIt;
    @FXML private Label lbLineareSucheRek;
    @FXML private Label lbLineareSucheIt;
    @FXML private Label lbggTRek;
    @FXML private Label lbggTIt;
    @FXML private TextField tfFakultaetRek;
    @FXML private TextField tfFakultaetIt;
    @FXML private TextField tfSummeBisRek;
    @FXML private TextField tfSummeBisIt;
    @FXML private TextField tfSpiegelwortRek;
    @FXML private TextField tfSpiegelwortIt;
    @FXML private TextField tfQuersummeRek;
    @FXML private TextField tfQuersummeIt;
    @FXML private TextField tfLineareSucheRek;
    @FXML private TextField tfLineareSucheIt;
    @FXML private TextField tfggTRek1;
    @FXML private TextField tfggTRek2;
    @FXML private TextField tfggTIt1;
    @FXML private TextField tfggTIt2;

    public void btFakultaetRek_onClick() {
        lbFakultaetRek.setText(String.valueOf(Uebungen.FakultaetRek(Integer.parseInt(tfFakultaetRek.getText()))));
    }

    public void btFakultaetIt_onClick() {
        lbFakultaetIt.setText(String.valueOf(Uebungen.FakultaetIt(Integer.parseInt(tfFakultaetIt.getText()))));
    }

    public void btSummeBisRek_onClick() {
        lbSummeBisRek.setText(String.valueOf(Uebungen.SummeBisRek(Integer.parseInt(tfSummeBisRek.getText()))));
    }

    public void btSummeBisIt_onClick() {
        lbSummeBisIt.setText(String.valueOf(Uebungen.SummeBisIt(Integer.parseInt(tfSummeBisIt.getText()))));
    }

    public void btSpiegelwortRek_onClick() {
        lbSpiegelwortRek.setText(Uebungen.SpiegelwortRek(tfSpiegelwortRek.getText()));
    }

    public void btSpiegelwortIt_onClick() {
        lbSpiegelwortIt.setText(Uebungen.SpiegelwortIt(tfSpiegelwortIt.getText()));
    }

    public void btQuersummeRek_onClick() {
        lbQuersummeRek.setText(String.valueOf(Uebungen.QuersummeRek(Integer.parseInt(tfQuersummeRek.getText()))));
    }

    public void btQuersummeIt_onClick() {
        lbQuersummeIt.setText(String.valueOf(Uebungen.QuersummeIt(Integer.parseInt(tfQuersummeIt.getText()))));
    }

    public void btLineareSucheRek_onClick() {
        int[] a = {2,3,5,7,11,13,17,19};
        int b = Integer.parseInt(tfLineareSucheRek.getText());
        lbLineareSucheRek.setText(String.valueOf(Uebungen.LineareSucheRek(a,b,0)));
    }

    public void btLineareSucheIt_onClick() {
        int[] a = {2,3,5,7,11,13,17,19};
        int b = Integer.parseInt(tfLineareSucheIt.getText());
        lbLineareSucheIt.setText(String.valueOf(Uebungen.LineareSucheIt(a,b)));
    }

    public void btggTRek_onClick() {
        int a = Integer.parseInt(tfggTRek1.getText());
        int b = Integer.parseInt(tfggTRek2.getText());
        lbggTRek.setText(String.valueOf(Uebungen.ggTRek(a,b)));
    }

    public void btggTIt_onClick() {
        int a = Integer.parseInt(tfggTIt1.getText());
        int b = Integer.parseInt(tfggTIt2.getText());
        lbggTIt.setText(String.valueOf(Uebungen.ggTIt(a,b)));
    }
}
