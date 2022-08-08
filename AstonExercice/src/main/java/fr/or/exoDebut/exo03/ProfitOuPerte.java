package fr.exo03;


import java.util.Scanner;

public class ProfitOuPerte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Saisir des prix avec , et pas . (ex: 10,99)
        System.out.println("Saisir le prix de fabrication : ");
        double prixFabrication = scanner.nextDouble();

        System.out.println("Saisir le prix de vente: ");

        double prixVente = scanner.nextDouble();

        double resultat = prixVente - prixFabrication;

        if (prixFabrication > 0 && prixVente > 0) {
            if (resultat > 0) {
                System.out.println("Profit de " + resultat + "€");
            } else if (resultat < 0) {
                System.out.println("Pert de " + (-resultat) + "€");
            } else {
                System.out.println("Ni perte, ni profit !");
            }
        }else {
            System.out.println("Saisir un prix positif svp !");
        }
    }
}
