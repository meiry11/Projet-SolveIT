package fr.exo01;

public class Rectangle {
        //  Les attributs
        public double largeur;
        public double longueur;

        // Constructeurs
    public Rectangle() {
        this.largeur = 5.0D;
        this.longueur = 8.0D;
    }

    // Surcharger le constructeur
    public Rectangle(double largeur, double longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    // Methodes

    public double calculerSurface() {
        return longueur * largeur;

    }
}
