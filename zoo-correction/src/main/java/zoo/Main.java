package zoo;

import zoo.classes.Animaux;
import zoo.classes.Chat;
import zoo.classes.Dauphin;
import zoo.classes.Zoo;

public class Main {
    public static void main(String[] args) throws Exception {

        Chat chat = new Chat();
        Dauphin dauphin = new Dauphin();

        Zoo zoo = new Zoo();
        zoo.getListeCage().get(0).ajouter(chat);
        zoo.getListeAquarium().get(0).ajouter(dauphin);

        zoo.getListeCage().get(0).checkConteneur();
        System.out.println("nombre d'animaux dans le zoo : " + Animaux.compteur);
    }
}
