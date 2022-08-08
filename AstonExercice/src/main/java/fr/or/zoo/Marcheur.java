package fr.or.zoo;

public class Marcheur extends Animal {


    public Marcheur(String nom, boolean marcher, boolean nager, boolean voler) {
        super(nom, marcher, nager, voler);
    }

    public void marcher(){
        System.out.println("Je marche");
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
