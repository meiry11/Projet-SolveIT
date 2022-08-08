package fr.exo02;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre: ");

        int nombre1 = scanner.nextInt();
        System.out.println("Saisir un deuxieme nombre : ");

        int nombre2 = scanner.nextInt();
        int resultat =nombre1 + nombre2;
        System.out.println(nombre1 + " + " + nombre2 + " = " + resultat);
    }
}
