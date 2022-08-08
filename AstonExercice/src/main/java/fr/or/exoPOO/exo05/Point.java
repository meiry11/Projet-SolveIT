package fr.exo05;

public class Point {
    //Attributs
    private int x, y;

    // Constructeurs
    public Point() {
        // initialiser les attributs
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters && setters
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


    // methodes
    public double distance(Point autrePoint) {
        double resultat = 0;
        double partie1 = Math.pow((autrePoint.x - this.x), 2);
        double partie2 = Math.pow((autrePoint.y - this.y), 2);
        resultat = Math.sqrt(partie1 + partie2);
        return resultat;
    }
}
