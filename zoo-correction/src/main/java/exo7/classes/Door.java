package exo7.classes;

import exo7.interfaces.IDisplay;

public class Door implements IDisplay {

    private String color;

    public Door(String color) {
        this.setColor(color);
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String Display() {
        return "porte de couleur " + this.color;
    }
}
