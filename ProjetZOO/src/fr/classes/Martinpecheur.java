package fr.classes;

import fr.interfaces.INageur;
import fr.interfaces.IVolatile;

public class Martinpecheur extends Animaux implements INageur, IVolatile {

    public Martinpecheur() {
        super();
    }

    @Override
    public void nager() {
        System.out.println("Le martinpecheur nage");
    }

    @Override
    public void voler() {
        System.out.println("Le martinpecheur vole");
    }
    public void manger() {
        System.out.println("Le martinpecheur mange");
    }
}
