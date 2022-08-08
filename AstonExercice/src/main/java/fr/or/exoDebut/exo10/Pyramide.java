package fr.exo10;


import java.util.Scanner;

public class Pyramide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un nombre:");
        int nombre = scanner.nextInt();

        for (int i = 0; i < nombre; i++) {
            String espaces = "";
            String etoiles = "";

            // Compter les espaces
            for (int j = 0; j < nombre - i; j++) {
                espaces += " ";
            }
            // Ajouter des etoiles
            for (int k = 0; k < i * 2 - 1; k++) {
                etoiles += "*";
            }
            // Assembler les etoiles et les espaces
            System.out.println(espaces + etoiles);
        }
    }
}
