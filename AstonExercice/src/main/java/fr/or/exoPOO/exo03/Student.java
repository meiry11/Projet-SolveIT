package fr.exo03;

public class Student {
    // Attributs
    String nom;
    int[] notes;

    // Constructeurs
    public Student() {
        // Les valeurs par defaut
    }

    // surcharger le constructeur en utilisant des var args pour les notes
    public Student(String nom, int... notes) {
        this.nom = nom;
        this.notes = notes;
    }

    // methodes
    public double calcAverage() {
        double resultat =0;

        for (int note: this.notes
             ) {
            resultat += note;
        }
        resultat /= this.notes.length;
        return resultat;
    }

    public void show() {
        System.out.println("L'étudiant " + this.nom + " a une moyenne de : " + calcAverage());
    }

}
