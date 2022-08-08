package fr.exemple.entity;

/**
 * Classe artiste de type guitariste implement Musicien
 * @author roumaissa
 */
public class Guitariste implements Musicien{
    private String nom;
    private Instrument guitare;

    @Override
    public void jouer() {
        System.out.println(getNom()+ "joue : "+ getGuitare());
    }

    public Guitariste() {
    }

    public Guitariste(String nom, Instrument guitare) {
        this.nom = nom;
        this.guitare = guitare;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Instrument getGuitare() {
        return guitare;
    }

    public void setGuitare(Instrument guitare) {
        this.guitare = guitare;
    }
}
