package fr.exo11;


import java.util.Scanner;

public class MonnaieEuropeene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un prix:");
        double prix = scanner.nextDouble();

        double[] monnaies = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

        for (double monnaie: monnaies) {
            double nombre = Math.floor(prix / monnaie) ;
            if (monnaie >= 5) {
                System.out.println("Billets de " + monnaie + " € : " + (int) nombre);
            } else {
                System.out.println("Pieces de  " + monnaie + " € : " + (int) nombre);
            }
            prix -= nombre * monnaie;
            prix=Math.round(prix*100.0)/100.0;
        }
    }
}
