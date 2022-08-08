package zoo.classes;

import zoo.interfaces.INageur;
import zoo.interfaces.IVolatile;

public class MartinPecheur extends Animaux implements INageur, IVolatile {

    public MartinPecheur() {
        super();
    }

    @Override
    public void nager() {
        System.out.println("le martin pecheur nage");
    }

    @Override
    public void voler() {
        System.out.println("le martin pecheur vole");
    }

    @Override
    public void manger() {
        System.out.println("le martin pecheur mange");
    }
}
