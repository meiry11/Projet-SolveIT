package fr.classes;

import fr.interfaces.IVolatile;

public class Aigle extends Animaux implements IVolatile {

    public Aigle() {
        super();
    }

    @Override
    public void voler() {
        System.out.println("L'aigle vole");
    }

    public void manger() {
        System.out.println("L'aigle mange");
    }
}
