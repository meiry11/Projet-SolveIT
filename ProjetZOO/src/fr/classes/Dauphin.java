package fr.classes;

import fr.interfaces.INageur;

public class Dauphin extends Animaux implements INageur {

    public Dauphin() {
        super();
    }

    @Override
    public void nager() {
        System.out.println("Le dauphin nage");
    }
    public void manger() {
        System.out.println("Le dauphin mange");
    }
}
