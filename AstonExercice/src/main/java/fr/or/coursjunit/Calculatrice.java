package fr.or.coursjunit;

public class Calculatrice {
    public double add(double param, double param2){
        return  param+param2;
    }

    public double sub(double param, double param2){
        return  param-param2;
    }

    public double divide(double param, double param2){
        if (param2 == 0) throw new ArithmeticException("division par 0");
        return  param/param2;
    }
}
