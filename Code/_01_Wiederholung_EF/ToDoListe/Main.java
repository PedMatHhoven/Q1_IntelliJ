package _01_Wiederholung_EF.ToDoListe;

import java.util.Scanner;

public class Main {
  public static void main (String args[]) {
    //leere Liste erzeugen
    System.out.println("Dies ist ein Verwaltungsprogramm fuer eine ToDo-Liste!");
    System.out.println("Zunaechst wird eine leere Liste angelegt..............");
    System.out.println("");
    ToDoListe Liste = new ToDoListe();
    System.out.println(Liste.zeigeAufgabe());
    System.out.println("");
    
    Scanner scan = new Scanner(System.in);
    
    String a = "Start";
    while (!a.equals("b")) {
      System.out.println("Was moechten Sie nun tun?");
      System.out.println("Eine neue Aufgabe anlegen (a) oder die aktuelle Aufgabe anzeigen (an)");
      System.out.println("oder die aktuelle Aufgabe loeschen (l) oder alle Aufgaben anzeigen (al)");
      System.out.print("oder das Programm beenden (b)? "); 
      a = scan.nextLine();
      if (a.equals("a")) {
        System.out.println();
        System.out.print("Geben Sie eine Bezeichnung fuer die Aufgabe ein: "); 
        String s = scan.nextLine();
        System.out.print("Welche Prioritaet soll diese Aufgabe inne haben (1/2/3)? ");
        String t = scan.nextLine();
        int i = Integer.parseInt(t);
        Aufgabe Aufgabe1 = new Aufgabe(s, i);
        Liste.fuegeEin(Aufgabe1);
      } else if (a.equals("an")) { 
        System.out.println();
        System.out.println(Liste.zeigeAufgabe());
      } else if (a.equals("l")) {
        Liste.loesche();
      } else if (a.equals("al")) {
        for (int i=0; i<10; i++) System.out.println(Liste.getListe()[i].gibBeschreibung()+","+Liste.getListe()[i].gibPrioritaet()); 
      }
      System.out.println("");
    }
  }
} 
