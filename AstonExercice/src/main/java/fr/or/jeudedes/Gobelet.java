package fr.or.jeudedes;

import java.util.Random;

public class Gobelet implements IJouer{
    public int valeur;
    private De[] des;

    public Gobelet(int nb_des) {
        valeur = 0;
        des = new De[nb_des];
    }

    public int getValeur() {
        return valeur;
    }

    public De[] getDes() {
        return des;
    }

    public void lancer() throws Exception {
        valeur=0;
        if(valeur>= des.length) throw new Exception("Vos avez plus droit");
        De de = new De();
        de.lancer();
        des[valeur]=de;
        valeur++;
    }

    public void afficheScore(){
        if(valeur != 0)
            System.out.println("Le dernier score est : "+des[valeur-1].getValeur());
        else
            System.out.println("Aucun lancer n a été fait");
    }
}
