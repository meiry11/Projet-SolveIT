package zoo.classes;

import zoo.interfaces.IVolatile;

public class Aigle extends Animaux implements IVolatile {


    public Aigle() {
        super();
    }

    @Override
    public void voler() {
        System.out.println("l'aigle vole");
    }
}
