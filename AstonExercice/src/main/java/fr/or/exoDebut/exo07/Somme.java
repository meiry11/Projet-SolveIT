package fr.exo07;

import java.util.Scanner;

public class Somme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre: ");
        int N = scanner.nextInt();

        int resultat = 0;
        for (int i = 1; i <= N ; i++) {
            resultat += i;
            if (i != N) {
                System.out.print(i + " + ");
            } else {
                System.out.print(i + " = ");
            }
        }
        System.out.println(resultat);
    }

}
