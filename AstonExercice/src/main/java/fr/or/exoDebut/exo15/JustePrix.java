package fr.exo15;


import java.util.Scanner;

public class JustePrix {
    public static void main(String[] args) {
        System.out.println("Le nombre aléatoire est compris entre 0 et ...");

        int max = demanderNombre();

        System.out.println("Combien de vies souhaitez-vous ?");
        int nbVies = demanderNombre();

        long nombreAleatoire = Math.round(Math.random() * max);
        System.out.println("le nombre aleatoire est : " +  nombreAleatoire);
        int nbSaisies = 0;

        while (nbVies > 0 && nbSaisies != nombreAleatoire) {
            System.out.println("---------------------------");
            System.out.println("Nombre de vies restantes : " + nbVies);
            nbSaisies = demanderNombre();
            if (nbSaisies != nombreAleatoire) {
                if (nbSaisies < nombreAleatoire) {
                    System.out.println("Plus !");
                } else {
                    System.out.println("Moins !");
                }
            }
            nbVies--;
        }
        if (nbVies == 0) {
            System.out.println("Vous avez perdu... le nombre a trouver etait : " + nombreAleatoire);
        } else {
            System.out.println("Bravo, le nombre a trouver etait : " + nombreAleatoire);
        }
    }

    public static int demanderNombre() {
        System.out.println("Saisir un nombre: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
