package fr.exemple.entity;

public class Cornemuse implements Instrument{
    private String model;

    public Cornemuse() {
    }

    public Cornemuse(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Cornemuse{" +
                "model= glinkglinkglink'" + '\'' +
                '}';
    }
}
