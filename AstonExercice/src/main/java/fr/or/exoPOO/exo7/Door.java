package fr.or.exoPOO.exo7;

public class Door implements IDoor{
    /**
     * Couleur de la porte
     */
    private String color;

    /**
     * Constructeur sans arguments
     */
    public Door() {
    }
    /**
     * Constructeur avec arguments
     */
    public Door(String color) {
        this.color = color;
    }

    /**
     * Recupere la couleur de la porte
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Change la couleur de la porte
     * @param color : la nouvelle couleur
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Afficher une message + la couleur de la porte
     */
    @Override
    public void display() {
        System.out.println("Je suis une porte, ma couleur est "+color);
    }

    @Override
    public Door getDoor() {
        return this;
    }
}
