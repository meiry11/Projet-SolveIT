package fr.or.exoPOO.exo7;

public class Person implements IPerson {
    private String nom;
    private House maison;

    /**
     * Constructeur sans arguments
     */
    public Person() {
    }

    /**
     * Constructeur avec arguments
     * @param nom
     * @param maison
     */
    public Person(String nom, House maison) {
        this.nom = nom;
        this.maison = maison;
    }

    /**
     * Recuperer le nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Recuperer la maison
     * @return
     */
    public House getMaison() {
        return maison;
    }

    /**
     * Modifier la maison
     * @param maison
     */
    public void setMaison(House maison) {
        this.maison = maison;
    }

    @Override
    public void display() {
        System.out.println("Mon nom est :"+nom);
        maison.display();
        getDoor().display();
    }

    @Override
    public Door getDoor() {
        return maison.getDoor();
    }
}
