package zoo.classes;

import zoo.interfaces.IConteneur;

import java.util.ArrayList;
import java.util.List;

public class Conteneur<T, U> implements IConteneur {

    private int quantite;
    List<U> liste = new ArrayList<>();


    public Conteneur(int quantite) throws Exception {
        setQuantite(quantite);
    }

    public List<U> getListe() {
        return liste;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws Exception {
        if(liste.size() > quantite) throw new Exception("quantité inférieur au nombre d'animaux dans la cage");
        this.quantite = quantite;
    }


    public void ajouter(U param) throws Exception {
        if(liste.size() >= quantite) throw  new Exception("capacité atteinte");
        this.liste.add(param);
    }

    public void checkConteneur() {
        System.out.println(liste.size());
    }

}