package fr.exo06;

import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le premier nombre : ");
        double nombre1 = scanner.nextDouble();

        System.out.println("Saisir le deuxieme nombre : ");
        double nombre2 = scanner.nextDouble();

        System.out.println("Saisir l'operateur : ");
        String operateur = scanner.next();

        double resultat = 0;

        if (operateur.equals("+")) {
            resultat = nombre1 + nombre2;
        }else if (operateur.equals("-")) {
            resultat = nombre1 - nombre2;
        } else if (operateur.equals("*") || operateur.equals("x")) {
            resultat = nombre1 * nombre2;
        } else if (operateur.equals("/")) {
            if (nombre2 != 0) {
                resultat = nombre1 / nombre2;
            } else {
                System.out.println("Les divisions par 0 sont impossibles !");
            }
        } else {
            System.out.println("L'operateur n'a pas ete reconnu !");
        }

        System.out.println("[" + nombre1 + operateur + nombre2 + "] = " + resultat );
    }

}
