package zoo.classes;

public class Chat extends Animaux {

    public Chat() {
        super();
    }

    @Override
    public void manger() {
        System.out.println("le chat mange");
    }

    public void  dormir() {
        System.out.println("le chat dort");
    }

    public void litiere() {
        System.out.println("le chat va dans la litière");
    }
}
