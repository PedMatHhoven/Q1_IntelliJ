package _01_Wiederholung_EF.ToDoListe;

public class Aufgabe {
  private String beschreibung;
  private int prioritaet;
  
  public Aufgabe(String beschr, int prio) {
    beschreibung = beschr;
    prioritaet = prio;
  } 
  
  public String gibBeschreibung() {
    return beschreibung;
  }
  
  public int gibPrioritaet() {
    return prioritaet;
  } 
}

