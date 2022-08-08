package fr.exo02;

public class Somme {
    // Attributs
    double n1,n2;

    // Constructeurs

    public Somme() {
        this.n1 = 5;
        this.n2 = 10;
    }

    // surcharger le constructeur
    public Somme (double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Methodes

    public void sum() {
        System.out.println("La somme de n1 et n2 est de : " + (this.n1 + this.n2));
    }
}
