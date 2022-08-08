package fr.exemple.entity;

public class Sonneur implements Musicien{
    private String nom;
    private Instrument cornemuse;


    public Sonneur() {
    }

    public Sonneur(String nom, Instrument cornemuse) {
        this.nom = nom;
        this.cornemuse = cornemuse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Instrument getCornemuse() {
        return cornemuse;
    }

    public void setCornemuse(Instrument cornemuse) {
        this.cornemuse = cornemuse;
    }

    @Override
    public void jouer() {
        System.out.println(getNom()+ "joue : "+ getCornemuse());
    }
}
