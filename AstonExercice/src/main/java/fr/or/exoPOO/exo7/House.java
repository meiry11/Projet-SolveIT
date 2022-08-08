package fr.or.exoPOO.exo7;

public class House implements IHouse{
    /**
     * La surface de la maison
     */
    private float surface;
    /**
     * Une maison est composée obligatoirement d'une porte
     */
    private Door porte;

    /**
     * Constructeur sans arguments
     */
    public House() {
        porte = new Door();
    }

    /**
     * Constructeur avec paramatre
     * @param surface : surface de la maison
     */
    public House(float surface,String couleur) {
        this.surface = surface;
        porte = new Door(couleur);
    }

    /**
     * Recuperer la surface de la maison
     * @return la valeur de la surface
     */
    public float getSurface() {
        return surface;
    }

    /***
     * Modifier la valeur de la surface de la maison
     * @param surface la nouvelle valeur de surface
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     * Affiche un message en indiquant la surface
     */
    @Override
    public void display(){
        System.out.println("Je suis une maison, ma surface est de "+surface+" m2");
    }

    @Override
    public Door getDoor() {
        return porte;
    }
}
