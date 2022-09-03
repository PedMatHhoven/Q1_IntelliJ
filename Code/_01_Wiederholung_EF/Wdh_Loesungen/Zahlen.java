package _01_Wiederholung_EF.Wdh_Loesungen;

import java.util.Scanner;

public class Zahlen {
    public static void main(String args[]) {
        double a, b, c;
        Scanner scan = new Scanner(System.in);
        System.out.print("1. Zahl? ");
        a = scan.nextDouble();
        System.out.print("2. Zahl? ");
        b = scan.nextDouble();
        System.out.print("3. Zahl? ");
        c = scan.nextDouble();
        System.out.println("Durchschnitt: " + (a+b+c)/3);
    }
}

