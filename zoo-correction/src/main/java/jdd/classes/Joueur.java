package jdd.classes;

import jdd.interfaces.IGobelet;
import jdd.interfaces.IJoueur;

public class Joueur implements IJoueur {

    private String nom;
    private int score;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void jouer(IGobelet gobelet) {
        gobelet.lancer();
        this.score += gobelet.getValeur();
        gobelet.afficher_score();
    }

    @Override
    public void afficherScore() {
        System.out.println("le score de " + this.nom + " est de : " + this.score + System.getProperty("line.separator"));
    }
}
