package fr.or.jeudedes;

import java.util.ArrayList;
import java.util.List;

public class Partie{
    private List<Joueur> tabJoueurs = new ArrayList<Joueur>();
    private int nbTours;
    private Gobelet goblet;

    public Partie(int nbTours,int nbDes) {
        goblet = new Gobelet(nbDes);
        this.nbTours = nbTours;
    }
    public void initialiser(Joueur joueur){
        tabJoueurs.add(joueur);
    }

    public void lancer() throws Exception {
        System.out.println("Partie Lancée !! ");
        for (int i = 0 ; i <nbTours ;i++){
            System.out.println("Tour numéro : "+(i+1));
            for (Joueur joueur:tabJoueurs
                 ) {

                joueur.jouer(goblet);
                System.out.println("cest le tour de "+joueur);
            }

        }
        afficheGagnant();
    }

    public void afficheGagnant(){
        Joueur gagant=null;

        if(tabJoueurs.size() != 0) { // Verifier si il y a au moins un joueur dans la liste
            for (Joueur joueur : tabJoueurs
            ) {
                if (gagant == null || joueur.get_score() > gagant.get_score()) // Si gagnant null donc le premier joueur trouver c est le gagnat et on le remplace avec le joueur avec le score le plus elevé au fur et à mesure
                    gagant = joueur;
            }
            System.out.println(gagant);
        }

    }

}
