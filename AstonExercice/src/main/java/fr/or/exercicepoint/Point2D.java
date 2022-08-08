package fr.or.exercicepoint;

public class Point2D {
    /**
     * {@code Classe point @autor OURABAH ROUMAISSA}
     */
    /**
     * il permet de compter le nombre d'objet créé dans cette famille (la famille des Point2D).
     */
    private static int compteur;
    /**
     * @Param x permet de récuperer l'abcisse
     */
    private int x;
    int a;
    /**
     * @Param y permet de récuperer la coordonnée
     */
    private int y;

    /**
     * Constructeur sans argument pour redéfinir le constructeur par default
     */
    public Point2D() {
        compteur++;
    }

    /**
     * Constructeur redefinie avec les deux attributs
     * @param x : initialiser l'abcisse
     * @param y : initialiser le y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
        compteur++;
    }

    /**
     * Récuperer la valeur de l'abcisse
     * @return l'abcisse
     */
    public int getX() {
        return x;
    }

    /**
     * Mettre à jour la valeur de x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Recuperer la valeur de la coordonnee
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * Mettre a jour la valeur de Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Permet de recuperer le nombre d'objet créé dans cette famille
     * @return
     */
    public static int getCompteur() {
        return compteur;
    }

    /**
     * Afficher dans la console les coordonnées sous un format specifique
     */
    public void afficher(){
        System.out.println("["+x+", "+y+"]");
    }

    /**
     * Translater le point en rajoutant un dx et un dy
     * @param dX permet de Translater le X
     * @param dY permet de Translater le Y
     */
    public void translater(int dX, int dY){
        this.x += dX;
        this.y += dY;
    }
}
