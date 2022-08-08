package fr.or.zoo;

public class Nageur extends Animal implements INageur{


    public Nageur(String nom, boolean marcher, boolean nager, boolean voler) {
        super(nom, marcher, nager, voler);
    }

    @Override
    public void nager() {
        System.out.println("Je nage");
    }

    @Override
    public boolean getVoler() {
        return false;
    }

    @Override
    public boolean getNager() {
        return false;
    }

    @Override
    public boolean getMarcher() {
        return false;
    }
}
