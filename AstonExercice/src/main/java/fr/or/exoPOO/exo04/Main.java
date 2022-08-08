package fr.exo04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Premier nombre -----");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Saisir le premier reel :");
        double num1 = scanner.nextDouble();

        System.out.print("Saisir le premier imaginaire :");
        double num1Imaginaire = scanner.nextDouble();

        System.out.println("-------- Deuxieme nombre ----------");
        System.out.println("Saisir le deucieme reel :");
        double num2 = scanner.nextDouble();

        System.out.println("Saisir le deuxieme imaginaire :");
        double num2Imaginaire = scanner.nextDouble();

        Complexe somme = new Complexe(num1, num1Imaginaire, num2, num2Imaginaire);

        somme.sum();
    }
}
