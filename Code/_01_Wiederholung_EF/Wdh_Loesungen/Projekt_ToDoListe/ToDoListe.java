package _01_Wiederholung_EF.Wdh_Loesungen.Projekt_ToDoListe;

public class ToDoListe {
  
  private Aufgabe[] Aufgabenliste;
  private int Anzahl;
  
  public ToDoListe() {
    //maximal 10 Aufgaben erlaubt
    Aufgabenliste = new Aufgabe[10];
    //leere Aufgaben werden angelegt (mit Priorität 0)
    Aufgabe aufg = new Aufgabe("", 0);
    for (int i=0; i<10; i++) Aufgabenliste[i] = aufg; 
    //keine wirkliche Aufgabe vorhanden!
    Anzahl = 0;
  }
  
  public int getAnzahl() {
    return Anzahl;
  }
  
  public Aufgabe[] getListe() {
    return Aufgabenliste;
  }
  
  public void fuegeEin(Aufgabe pAufgabe) {
    //fügt laut Priorität pAufgabe in den array Aufgabenliste ein
    //ein Überschreiten der 10 Aufgaben wird erstmal nicht behandelt!
    int i=0;
    while ((i < Anzahl) && (pAufgabe.gibPrioritaet() >= Aufgabenliste[i].gibPrioritaet())) i++;
    for (int j=9; j>i; j--) Aufgabenliste[j] = Aufgabenliste[j-1];
    Aufgabenliste[i] = pAufgabe;
    Anzahl++;
  }
  
  public void loesche() {
    //löscht das erste Element der Aufgabenliste (nach Bearbeitung)
    if (Anzahl > 0) {
      for (int i=0; i<9; i++) Aufgabenliste[i] = Aufgabenliste[i+1];
      Aufgabenliste[9] = new Aufgabe("", 0);
      Anzahl--;
    }
  }
  
  public String zeigeAufgabe() {
    //zeigt das erste Element der Aufgabenliste an (wenn diese nicht leer ist)
    if (Anzahl > 0) return Aufgabenliste[0].gibBeschreibung() + "," + Aufgabenliste[0].gibPrioritaet();
    else return "Aufgabenliste ist leer :)!";
  }
}

