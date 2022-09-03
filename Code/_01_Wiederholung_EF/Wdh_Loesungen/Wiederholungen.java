package _01_Wiederholung_EF.Wdh_Loesungen;

import java.util.Scanner;

public class Wiederholungen {
    public static void main(String args[]) {
        String passwort;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Passwort? ");
            passwort = scan.nextLine();
        } while (!passwort.equals("Simsalabim"));
    }
}
