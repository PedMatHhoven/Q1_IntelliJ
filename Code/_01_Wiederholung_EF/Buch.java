package _01_Wiederholung_EF;

import java.util.Scanner;

public class Buch {
    private int Seitenanzahl;
    private String Titel, Autor;

    //Konstruktor (gleicher Name wie Klasse!)
    public Buch(String Autor, String Titel, int Anzahl) {
        this.Seitenanzahl = Anzahl;
        this.Titel = Titel;
        this.Autor = Autor;
    }

    //set- und get-Methoden:
    public void setTitel(String Titel) {
        this.Titel = Titel;
    }

    public String getTitel() {
        return Titel;
    }

    public void setAutor(String autor){
        this.Autor = autor;
    }

    public String getAutor(){
        return Autor;
    }

    public void setSeitenanzahl(int a){
        this.Seitenanzahl = a;
    }

    public int getSeitenanzahl(){
        return Seitenanzahl;
    }

    public static void main (String args[]) {
        //leeres Buch anlegen
        Buch Buch1 = new Buch("", "", 0);

        //Buchwerte über Eingabe abfragen:
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben Sie als erstes den Buchtitel ein: ");
        String titel = scan.nextLine();
        Buch1.setTitel(titel);

        System.out.print("Geben Sie nun den Autor ein: ");
        String autor = scan.nextLine();
        Buch1.setAutor(autor);

        System.out.print("Geben Sie jetzt die Seitenzahl ein: ");
        int seiten = scan.nextInt();
        //nextInt() verursacht Probleme,
        //falls im Anschluss wieder nextLine()
        //aufgerufen werden soll, deshalb auch möglich:
        //int seiten = Integer.parseInt(scan.nextLine());
        Buch1.setSeitenanzahl(seiten);

        //man hätte sich natürlich auch den Aufruf des Konstruktors
        //sowie der set-Prozeduren oben sparen und jetzt über
        //Buch Buch1 = new Buch(autor, titel, seiten);
        //ein neues Buch erzeugen können

        //Buchwerte ausgeben:
        String titelx = Buch1.getTitel();
        String autorx = Buch1.getAutor();
        int seitenx = Buch1.getSeitenanzahl();

        System.out.println();
        System.out.println("Der Titel des Buches lautet '"+ titelx + "'.");
        System.out.println("Das Buch wurde von "+ autorx + " geschrieben.");
        System.out.println("Das Buch hat "+ seitenx + " Seiten.");
        System.out.println();
    }
}

