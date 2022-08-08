package fr.classes;

import fr.interfaces.IAnimal;

abstract public class Animaux implements IAnimal {

    static public int compteur;

    public Animaux() {
        compteur++;
    }

    public void manger() {
        System.out.println("l'animal mange");
    }
}
