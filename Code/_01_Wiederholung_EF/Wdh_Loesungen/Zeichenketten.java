package _01_Wiederholung_EF.Wdh_Loesungen;

import java.util.Scanner;

public class Zeichenketten {
    public static void main(String[] args) {
        String wort;
        String hilfe;
        int laenge;

        Scanner scan = new Scanner(System.in);
        System.out.print("Wort? ");
        wort = scan.nextLine();
        laenge = wort.length();
        hilfe = "";

        for (int i=0; i <= laenge-1; i++) hilfe = hilfe + wort.charAt(laenge-i-1);
        System.out.println("Umgekehrt: " + hilfe);
        System.out.println();
    }
}