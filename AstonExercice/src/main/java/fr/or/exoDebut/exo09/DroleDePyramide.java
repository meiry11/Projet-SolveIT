package fr.exo09;


import java.util.Scanner;

public class DroleDePyramide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre: ");
        int nombre = scanner.nextInt();

        String etoile = "";

        for (int i = 0; i < nombre; i++) {
            etoile += "*";
            System.out.println(etoile);
        }

        for (int k = 0; k < nombre; k++) {
            etoile = etoile.substring(0, nombre - k);
            System.out.println(etoile);
        }
    }
}
