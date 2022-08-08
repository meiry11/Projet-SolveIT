import fr.or.dao.Profit;
import fr.or.exo10.Point;
import fr.or.exo7.Somme;
import fr.or.exo8.Student;
import fr.or.exo9.NombreComplex;
import fr.or.tools.Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     /*   exercice 06

        Profit pr = new Profit();

        pr.setPrixAchat(pr.DemandeSomme("Veuillez saisir le prix d'achat : "));
        pr.setPrixVente(pr.DemandeSomme("Veuillez saisir le prix de vente : "));

        pr.CalculBenefice();*/


        /*  exercice 07
        Scanner sc = new Scanner(System.in);

        Somme sm = new Somme();

        System.out.println("Veuillez saisir le premier opérande : ");

        int n1= Integer.valueOf(sc.nextLine());

        sm.setN1(n1);

        System.out.println("Veuillez saisir le deuxieme opérande : ");

        int n2= Integer.valueOf(sc.nextLine());

        sm.setN2(n2);

        System.out.println("Le résultat est : "+sm.Sum());*/


/*           exercice 08
        Student st = new Student();

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom et prenom : ");

        st.setNom(sc.nextLine());

        System.out.println("Veuillez saisir le nombre de note a saisir : ");

        int taille= Integer.valueOf(sc.nextLine());

        int[] notes =  new int[taille];

        for (int i=0; i<taille ;i++){
            System.out.printf("Veuillez saisir la note numero %d : ",i+1);
            notes[i]= Integer.valueOf(sc.nextLine());
            System.out.println("");
        }

        st.setNotes(notes);

        st.show();*/

/*       EXERCICE 09

        NombreComplex nb1 = new NombreComplex();
        NombreComplex nb2 = new NombreComplex();

        System.out.println("Premier Nombre ");
        nb1.setPartieReelle(Tools.saisirNombre("Veuillez entrer la partie Réelle : "));
        nb1.setPartieImaginaire(Tools.saisirNombre("Veuillez entrer la partie Imaginaire : "));

        System.out.println("Deuxieme Nombre ");
        nb2.setPartieReelle(Tools.saisirNombre("Veuillez entrer la partie Réelle : "));
        nb2.setPartieImaginaire(Tools.saisirNombre("Veuillez entrer la partie Imaginaire : "));

        nb1.claculSomme(nb2);*/

        Scanner sc = new Scanner(System.in);

        System.out.println("Point 1 : ");

        Point p1 = new Point();

        System.out.print(" x= ");

        p1.setX(Integer.valueOf(sc.nextLine()));

        System.out.print(" y= ");

        p1.setY(Integer.valueOf(sc.nextLine()));

        System.out.println("Point 2 : ");

        Point p2 = new Point();

        System.out.print(" x= ");

        p2.setX(Integer.valueOf(sc.nextLine()));

        System.out.print(" y= ");

        p2.setY(Integer.valueOf(sc.nextLine()));

        System.out.printf("La distance entre P1 et P2 est : %.5f",p1.calculerDistance(p2));
    }
}

