package fr.exo03;

import java.awt.desktop.AboutEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le nom de l'étudiant : ");
        String nom = scanner.nextLine();

        System.out.println("Saisir la premiere note :");
        int note1 = scanner.nextInt();

        System.out.println("Saisir la deuxieme note :");
        int note2 = scanner.nextInt();

        System.out.println("Saisir la troisieme note :");
        int note3 = scanner.nextInt();

        Student etudiant = new Student(nom, note1, note2, note3);

        etudiant.show();
    }
}
