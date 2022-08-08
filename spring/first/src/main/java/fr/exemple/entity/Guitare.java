package fr.exemple.entity;

/**
 * Classe guitare qui implement instruments
 * @author roumaissa
 */
public class Guitare implements Instrument{
    private String model;

    public Guitare() {
    }

    public Guitare(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    /**
     *
     * @param model mettre a jour le model
     */
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Guitare{" +
                "model= GlinGlingGling'" + '\'' +
                '}';
    }
}
