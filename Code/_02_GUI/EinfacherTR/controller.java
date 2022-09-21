package _02_GUI.EinfacherTR;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private Label lb1;

    public void bt1_onClick(){
        String summand1 = tf1.getText();
        String zeichen = tf2.getText();
        String summand2 = tf3.getText();

        double summand_1a = Double.parseDouble(summand1);
        double summand_2b = Double.parseDouble(summand2);

        if (zeichen.equals("+")) {
            lb1.setText(String.valueOf(summand_1a + summand_2b));
        } else if (zeichen.equals("-")) {
            lb1.setText(String.valueOf(summand_1a - summand_2b));
        } else if (zeichen.equals("*")) {
            lb1.setText(String.valueOf(summand_1a * summand_2b));
        } else if (zeichen.equals("/")) {
            lb1.setText(String.valueOf(summand_1a / summand_2b));
        }
    }
}