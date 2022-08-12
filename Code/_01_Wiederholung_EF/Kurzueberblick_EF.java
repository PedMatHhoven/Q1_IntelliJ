package _01_Wiederholung_EF;

import java.util.Scanner;

public class Kurzueberblick_EF {
    public static void main (String args[]) {
        //Variablen - Deklarationen, teils mit Startwerten
        int summe;
        boolean w;
        char b = 'x';
        double y=7.0, z=3.0;
        int [] noten = {1,2,3,4,5,6,7,8,9,10}; //initialisierter Array der Länge 10 (Index 0 bis 9)
        String s = "Hallo :)!";
        //Kurzform! - Eigentlich String s = new String("Hallo :)!"),
        //denn String ist eine Klasse, kein einfacher Datentyp, d.h.
        //eine Variable vom Typ String enthält einen Verweis auf ein Objekt der Klasse String!
        //Wichtigste Konsequenz - Vergleichs­operator == nicht perfekt, stattdessen Funktion "equals"!
        //Beispiele weiterer Methoden der Klasse String: int length(); String substring(int i, int j); …

        //Ausgaben/ Initialisierungen
        System.out.println(s);
        summe = 6+2;
        System.out.println("Summe 6+2: " + summe);
        w = true;

        //Casting
        summe = (int)(y+z);
        System.out.println("Summe 7.0+3.0 gecastet: " + summe);

        //Methodenaufruf (Methode siehe unten!)
        System.out.println("Mittelwert von 7.0 und 3.0: " + mittelwert(y,z));

        //Operatoren in Verzweigungen
        if ((y==7) && (z==3)) {
            System.out.println("y und z stimmen!");
        } else {
            System.out.println("Sie stimmen nicht!");
        }

        //Schleifen
        System.out.print("Noten: ");
        for (int i=0; i<=9; i++) {
            noten[i] = noten[i] + 1;
            System.out.print(noten[i] + " ");
        }
        System.out.println();

        //Eingaben
        //java.util.Scanner
        System.out.print("Gib was ein: ");
        Scanner scan = new Scanner(System.in);
        String eingabe =  scan.nextLine();
        System.out.println("Du hast '" + eingabe + "' eingegeben.");
    }

    //Methode (statisch, d.h. unabhängig von der Klasse - kein Objekt von Nöten!)
    public static double mittelwert(double a, double b) {
        return (a+b)/2;
    }
}
