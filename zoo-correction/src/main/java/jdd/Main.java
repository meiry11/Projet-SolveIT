package jdd;

import jdd.classes.De;
import jdd.classes.Gobelet;
import jdd.classes.Joueur;
import jdd.classes.Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("nombre de dés ? ");
        int nbd = scan.nextInt();

        System.out.println("nombre de tour ?");
        int nbt = scan.nextInt();

        System.out.println("nombre de joueur ? ");
        int nbj = scan.nextInt();



        List<De> listeDe = new ArrayList<De>();

        for (int i = 0; i < nbd; i++) {
            listeDe.add(new De());
        }



        Gobelet gob = new Gobelet(listeDe);

        Partie partie = new Partie(nbt, gob);

        for (int i = 0; i < nbj; i++) {
            System.out.println("nom du joueur : ");
            String nom = scan.next();
            partie.initialiser(new Joueur(nom));
        }
        scan.close();


        partie.lancer();

    }
}
