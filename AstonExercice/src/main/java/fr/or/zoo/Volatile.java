package fr.or.zoo;

public class Volatile extends Animal implements IVolatile{


    public Volatile(String nom, boolean marcher, boolean nager, boolean voler) {
        super(nom, marcher, nager, voler);
    }

    @Override
    public void vole() {
        System.out.println("Je vole");
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
