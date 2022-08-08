package fr.or.exoPOO.exo7;

public class Appartement extends House{
    /**
     * Constructeur sans arguments
     */
    public Appartement() {
    setSurface(50);
    }

    /**
     * Constructeur avec arguments
     * @param couleur
     */
    public Appartement(String couleur) {
        super(50, couleur);
    }

    /**
     * Forcer la la valeur de la surface à 50
     */
    public void setSurface() {
        super.setSurface(50);
    }

    /**
     * Recuperer la valeur de la surface
     * @return
     */
    @Override
    public float getSurface() {
        return super.getSurface();
    }

    @Override
    public void display() {
        System.out.println("Je suis un appartement, ma surface est de "+super.getSurface()+" m2");
    }
}
