package jdd.classes;

import jdd.interfaces.IJoueur;
import jdd.interfaces.IPartie;

import java.util.ArrayList;
import java.util.List;

public class Partie implements IPartie {

    private List<Joueur> tableJoueur = new ArrayList<Joueur>();
    private int nbTour;
    private Gobelet gobelet;

    public Partie(int nbTour, Gobelet gobelet) {
        this.setNbTour(nbTour);
        this.setGobelet(gobelet);
    }

    public List<Joueur> getTableJoueur() {
        return tableJoueur;
    }

    public void setTableJoueur(List<Joueur> tableJoueur) {
        this.tableJoueur = tableJoueur;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public Gobelet getGobelet() {
        return gobelet;
    }

    public void setGobelet(Gobelet gobelet) {
        this.gobelet = gobelet;
    }

    @Override
    public void initialiser(Joueur joueur) {
        this.tableJoueur.add(joueur);

    }

    @Override
    public void lancer() {

        Joueur gagnant = this.tableJoueur.get(0);
        for (int i =0; i < this.nbTour; i++) {
            for (Joueur joueur: tableJoueur
                 ) {
                joueur.jouer(this.gobelet);
                joueur.afficherScore();
                if (joueur.getScore() > gagnant.getScore()) gagnant = joueur;
            }
        }

        this.afficherGagnant(gagnant);

    }

    @Override
    public void afficherGagnant(Joueur gagnant) {
        System.out.println("le gagnant est : " + gagnant.getNom() + " avec un score de : " + gagnant.getScore());
    }
}
