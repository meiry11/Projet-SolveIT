package fr.exo04;

import java.util.Scanner;

public class LePlusGrand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un premier nombre : ");
        int nombre1 = scanner.nextInt();

        System.out.println("Saisir un deuxieme nombre : ");
        int nombre2 = scanner.nextInt();

        System.out.println("Saisir un troisieme nombre : ");
        int nombre3 = scanner.nextInt();

        if (nombre1 >= nombre2 && nombre1 >= nombre3) {
            System.out.println("[" + nombre1 + "," + nombre2 + "," + nombre3 + "] --> " + nombre1);
        } else if (nombre2 >= nombre1 && nombre2 >= nombre3) {
            System.out.println("[" + nombre1 + "," + nombre2 + "," + nombre3 + "] --> " + nombre2);
        } else {
            System.out.println("[" + nombre1 + "," + nombre2 + "," + nombre3 + "] --> " + nombre3);
        }
    }
}
