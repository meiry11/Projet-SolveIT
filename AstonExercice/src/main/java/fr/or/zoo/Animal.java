package fr.or.zoo;

public abstract class Animal implements IAnimal{
    public static int compteur;
    private boolean marcher;
    private boolean nager;
    private boolean voler;
    private String nom;

    public Animal(String nom,boolean marcher,boolean nager,boolean voler) {
        this.nom = nom;
    }

    @Override
    public void manger() {
        System.out.println("Je mange");
    }
    public void dormir() {
        System.out.println("Je dors");
    }

    @Override
    public void setVoler(Boolean bool) {
        voler=bool;
    }

    @Override
    public void setMarcher(Boolean bool) {
        marcher=bool;
    }

    @Override
    public void setNager(Boolean bool) {
        nager=bool;
    }

    public static int getCompteur() {
        return compteur;
    }

    public boolean isMarcher() {
        return marcher;
    }

    public boolean isNager() {
        return nager;
    }

    public boolean isVoler() {
        return voler;
    }

    public String getNom() {
        return nom;
    }
}
