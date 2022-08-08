package poo;

public interface IDemo {

    public void parler();

    default void marcher() {
        System.out.println("l'enfant marche");
    }
}
