package fr.exo08;

import java.util.Scanner;

public class Escalier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre :");
        int  nombre = scanner.nextInt();

        String etoile = "";

        for (int i = 0; i < nombre ; i++) {
            etoile += "*";
            System.out.println(etoile);
        }
    }
}
