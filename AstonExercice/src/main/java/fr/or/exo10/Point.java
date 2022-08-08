package fr.or.exo10;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calculerDistance(Point p2){
        double result=0;

        result = Math.sqrt((p2.getX()-x)*(p2.getX()-x)+(p2.getY()-y)*(p2.getY()-y));
        return result;
    }
}
