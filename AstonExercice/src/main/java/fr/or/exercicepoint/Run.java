package fr.or.exercicepoint;

import fr.or.exo10.Point;

public class Run {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        System.out.println("nbr"+Point2D.getCompteur());
        Point2D p2 = new Point2D();
        System.out.println("nbr"+Point2D.getCompteur());
        p1.setX(4);
        p1.setY(34);
        p2.setX(2);
        p2.setY(2);

        p1.afficher();
        p1.translater(p2.getX(),p2.getY());
        p1.afficher();

    }
}
