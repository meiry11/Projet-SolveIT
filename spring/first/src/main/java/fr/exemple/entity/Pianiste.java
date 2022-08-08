package fr.exemple.entity;

public class Pianiste implements Musicien{
    private String nom;
    private Piano piano;

    public Pianiste() {
    }

    public Pianiste(String nom, Piano piano) {
        this.nom = nom;
        this.piano = piano;
    }

    public String getNom() {
        return nom;
    }

    public Piano getPiano() {
        return piano;
    }

    public void setPiano(Piano piano) {
        this.piano = piano;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Pianiste{" +
                "nom='" + nom + '\'' +
                ", piano=" + piano +
                '}';
    }

    @Override
    public void jouer() {
        System.out.println(getNom()+ "joue : "+ getPiano());
    }
}
