package fr.or.exo6;

public class Calculatrice {
    private float operande1;
    private float operande2;
    private String operation;

    public Calculatrice(float operande1, float operande2, String operation) {
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.operation = operation;
    }

    public Calculatrice() {

    }

    public float getOperande1() {
        return operande1;
    }

    public void setOperande1(float operande1) {
        this.operande1 = operande1;
    }

    public float getOperande2() {
        return operande2;
    }

    public void setOperande2(float operande2) {
        this.operande2 = operande2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float Calculer(){
        float result=0;
        switch (operation){
            case "+" -> result= operande1 + operande2;
            case "-" -> result= operande1 - operande2;
            case "*" -> result= operande1 * operande2;
            default -> result= operande1 / operande2;
        }
        return result;
    }
}
