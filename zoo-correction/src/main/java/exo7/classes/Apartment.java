package exo7.classes;

import exo7.interfaces.IHouse;

public class Apartment extends House implements IHouse {

    public Apartment(String color) {
        super(50, color);
    }

    @Override
    public String toString() {
        return "Apartment{ surface : " + this.getSurface() + "porte : " + this.getDoor().Display() +
                "}";
    }

    public String Display() {
        return " appartement, dont la surface est de " + this.getSurface() + "m² et ayant une " + this.getDoor().Display();
    }
}
