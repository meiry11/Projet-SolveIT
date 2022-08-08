package fr.classes;

import fr.interfaces.IAnimal;
import fr.interfaces.IConteneur;
import fr.interfaces.INageur;
import fr.interfaces.IVolatile;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Conteneur<Aquarium, INageur>> listeAquarium = new ArrayList<>();
    List<Conteneur<Voiliere, IVolatile>> listeVoiliere = new ArrayList<>();
    List<Conteneur<Cage, IAnimal>> listeCage = new ArrayList<>();

    public Zoo() {

    }

    public void addConteneur(IConteneur conteneur) {
        System.out.println(conteneur.getClass());
    }
}
