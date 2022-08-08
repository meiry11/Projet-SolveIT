package fr.or.exo6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Calculatrice ca = new Calculatrice();
    Scanner sc = new Scanner(System.in);
     float op1=0;
     float op2=0;
        do{
           System.out.println("Veuillez saisir le premier operande");
           op1=Float.valueOf(sc.nextLine());
            ca.setOperande1(op1);
        }while(op1 <= 0);


            System.out.println("Veuillez saisir l'operateur'");
            ca.setOperation(sc.nextLine());

        do{
            System.out.println("Veuillez saisir le deuxieme operande");
            op2 =Float.valueOf(sc.nextLine());
            ca.setOperande2(op2);
        }while(op2 <= 0);

        System.out.println( "Le resultat est : "+ca.Calculer());

    }

}
