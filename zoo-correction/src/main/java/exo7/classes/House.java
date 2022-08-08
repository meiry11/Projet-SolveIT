package exo7.classes;

import exo7.classes.Door;
import exo7.interfaces.IHouse;

public class House implements IHouse {

    private double surface;
    private Door door;

    public House(double surface, String color) {
        this.setSurface(surface);
        this.door = new Door(color);
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public Door getDoor() {
        return this.door;
    }

    public String Display() {
        return " maison, dont la surface est de " + this.surface + "m² et ayant une " + this.getDoor().Display();
    }

    @Override
    public String toString() {
        return "House{" +
                "surface=" + surface + "porte : " + this.getDoor().Display() +
                '}';
    }
}
