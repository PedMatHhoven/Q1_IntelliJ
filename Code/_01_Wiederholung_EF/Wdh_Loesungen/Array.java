package _01_Wiederholung_EF.Wdh_Loesungen;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int zahl[] = new int[5];
        int such, speicher;
        String wahl;
        boolean gefunden;

        Scanner scan = new Scanner(System.in);
        System.out.println("5 Zahlen eingeben:");

        for (int i=0; i <= 4; i++) zahl[i] = scan.nextInt();

        System.out.println("Array komplett: ");
        for (int i=0; i <= 4; i++) System.out.print(zahl[i]+" ");
        System.out.println();

        System.out.print("Suche: ");
        such = scan.nextInt();

        speicher = 0;
        gefunden = false;
        for (int i=0; i <= 4; i++) {
            if (zahl[i] == such) {
                System.out.println("Gefunden! Position: " + (i+1));
                speicher = i;
                gefunden = true;
            }
        }

        if (gefunden == false) System.out.print("Nicht gefunden!");
        else {
            System.out.print("Zahl löschen (j/n)? ");
            wahl = scan.next();
            if (wahl.equals("j")) {
                for (int i=speicher; i <= 3; i++) zahl[i] = zahl[i+1];
                System.out.println("Feld komplett: ");
                for (int i=0; i <= 3; i++) System.out.print(zahl[i]+" ");
            }
        }
    }
}