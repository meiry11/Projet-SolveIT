package fr.exo01;

import java.util.Scanner;

public class Bienvenue {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prenom ? ");
        String prenom = scanner.next();
        System.out.println("Bienvenue " + prenom);
    }
}
