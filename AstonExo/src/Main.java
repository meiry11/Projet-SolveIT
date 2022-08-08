import fr.or.dao.Profit;
import fr.or.exo7.Somme;
import fr.or.exo8.Student;

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

        st.show();
    }
}

