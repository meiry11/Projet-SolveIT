package zoo.classes;

import zoo.interfaces.INageur;

public class Dauphin extends Animaux implements INageur {

    public Dauphin() {
        super();
    }

    @Override
    public void nager() {
        System.out.println("le dauphin nage");
    }
}
