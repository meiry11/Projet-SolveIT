package zoo.classes;

import zoo.interfaces.IAnimal;

abstract public class Animaux implements IAnimal {

    static public int compteur;

    public Animaux() {
        compteur++;
    }

    @Override
    public void manger() {
        System.out.println("l'animal mange");
    }
}
