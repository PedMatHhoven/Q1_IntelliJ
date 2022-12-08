package _04_Rekursion;

import java.util.Scanner;

public class Treppen {
  static int count = 0;

  public static String treppen(int a, String s)  {
    if (a==0) {
      count++;
      return s + "\n";
    }
    else if (a==1) {
      count++;
      return "E" + s + "\n";
    }
    else {
      return treppen(a-1, "E" + s) + treppen(a-2, "D" + s);
    }
  }

  public static int treppenAnzahl(int a)  {
    if (a<=1) return 1; else return treppenAnzahl(a-1) + treppenAnzahl(a-2);
  }

  public static void main(String[] args) {
    System.out.print("Wie viele Stufen möchtest Du gehen? ");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    System.out.print(treppen(n,""));
    System.out.println("Das waren insgesamt " + count + " Möglichkeiten.");
    System.out.println("Die rekursive Anzahl-Funktion liefert (auch) " + treppenAnzahl(n) + " Möglichkeiten.");
  }
} 

