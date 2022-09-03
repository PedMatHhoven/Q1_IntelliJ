package _01_Wiederholung_EF.Wdh_Loesungen;

import java.util.Scanner;

public class Verzweigungen {
    public static void main(String args[]) {
        int wochentag;

        Scanner scan = new Scanner(System.in);
        System.out.print("Wochentag (Mo=1, So=7)? ");
        wochentag = scan.nextInt();

        switch (wochentag) {
            case 6, 7:
                System.out.println("Ja, Wochenende :)!");
                break;
            default:
                System.out.println("Schade, kein Wochenende :(");
                break;
        }
    }
}
