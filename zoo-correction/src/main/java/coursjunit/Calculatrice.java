package coursjunit;

import java.util.ArrayList;
import java.util.List;

public class Calculatrice {

    List<Double> liste = new ArrayList<>();

    public double add(double param, double param2) {
        return param + param2;
    }

    public void sub(double param, double param2) {
        double result = param - param2;
        this.liste.add(result);
    }

    public double divide(double param, double param2) throws Exception {
        if(param2 == 0) throw new Exception("division par 0");
        return param / param2;
    }

    public String addCommentaire(String message) throws Exception {
        if(message.length() == 0) throw new Exception("message vide");
        if(message.length() > 10) throw  new Exception("message trop long");
        return message;
    }
}
