package exo7.classes;

import exo7.interfaces.IDisplay;
import exo7.interfaces.IHouse;

public class Person implements IDisplay {

    private String nom;
    private IHouse house;

    public Person(String nom) {
        this.setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public IHouse getHouse() {
        return house;
    }

    public void setHouse(IHouse house) {
        this.house = house;
    }

    public String Display() {
        return "Mon nom est " + this.nom + " ,j'ai un logement de type" + this.getHouse().Display();
    }
}
