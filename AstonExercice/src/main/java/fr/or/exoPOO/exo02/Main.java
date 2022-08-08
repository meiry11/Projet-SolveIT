package fr.exo02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre : ");
        double n1 = scanner.nextDouble();

        System.out.println("Saisir un deuxieme nombre : ");
        double n2 = scanner.nextDouble();


        Somme somme = new Somme(n1, n2);

        somme.sum();

    }
}
