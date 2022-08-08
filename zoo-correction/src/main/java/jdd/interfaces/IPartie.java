package jdd.interfaces;

import jdd.classes.Joueur;

public interface IPartie {
    public void initialiser(Joueur joueur);
    public void lancer();
    public void afficherGagnant(Joueur gagnant);
}
