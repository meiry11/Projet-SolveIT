package zoo.classes;

import zoo.interfaces.IAnimal;
import zoo.interfaces.IConteneur;
import zoo.interfaces.INageur;
import zoo.interfaces.IVolatile;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Conteneur<Aquarium, INageur>> listeAquarium = new ArrayList<>();

    List<Conteneur<Voliere, IVolatile>> listeVoliere = new ArrayList<>();

    List<Conteneur<Cage, IAnimal>> listeCage = new ArrayList<>();

    public Zoo() throws Exception {
        this.addVoliere(new Conteneur<Voliere, IVolatile>(5));
        this.addAquarium(new Conteneur<Aquarium, INageur>(5));
        this.addCage(new Conteneur<Cage, IAnimal>(5));
    }

    public List<Conteneur<Aquarium, INageur>> getListeAquarium() {
        return listeAquarium;
    }

    public List<Conteneur<Voliere, IVolatile>> getListeVoliere() {
        return listeVoliere;
    }

    public List<Conteneur<Cage, IAnimal>> getListeCage() {
        return listeCage;
    }

    public void addVoliere(Conteneur<Voliere, IVolatile> voliere) {
        this.listeVoliere.add(voliere);
    }

    public void addCage(Conteneur<Cage, IAnimal> cage) {
        this.listeCage.add(cage);
    }

    public void addAquarium(Conteneur<Aquarium, INageur> aquarium) {
        this.listeAquarium.add(aquarium);
    }
}
