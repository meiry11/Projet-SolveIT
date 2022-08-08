package fr.or.exoPOO.exo7;

public class Main {
    public static void main(String[] args) {
        Appartement aprt = new Appartement("bleu");
        Person prs = new Person("JONE",aprt);
        prs.display();
    }
}
