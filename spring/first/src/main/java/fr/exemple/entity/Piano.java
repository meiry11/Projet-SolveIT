package fr.exemple.entity;

/**
 * Classe Piano qui implement instrument
 * @author roumaissa
 */
public class Piano implements Instrument{
    private String model;

    public Piano() {
    }

    public Piano(String model) {
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
        return "Piano{" +
                "model= TingTingTing'" + '\'' +
                '}';
    }

}
