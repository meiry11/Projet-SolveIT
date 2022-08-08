package fr;

import fr.classes.*;
import fr.interfaces.IAnimal;
import fr.interfaces.INageur;

public class Main {
    public static void main(String[] args) throws Exception {

        Conteneur<Aquarium, INageur> aquarium = new Conteneur(5);
        Dauphin dau = new Dauphin();
        aquarium.ajouter(dau);

        Conteneur<Cage, IAnimal> cage = new Conteneur(10);
        Chat chat = new Chat();
        cage.ajouter(chat);

        Zoo zoo = new Zoo();
        zoo.addConteneur(cage);
    }
}
