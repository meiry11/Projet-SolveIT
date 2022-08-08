package fr.exo05;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(5, 6);
        Point p2 = new Point(3, 2);

        System.out.printf("La distance entre le p1 et le p2 est de : %.5f", p1.distance(p2));
    }
}
