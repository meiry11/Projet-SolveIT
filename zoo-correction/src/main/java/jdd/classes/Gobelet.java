package jdd.classes;

import jdd.interfaces.IGobelet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gobelet implements IGobelet {

    private int valeur;
    private List<De> tableDe;

    public Gobelet(List<De> tableDe) {
        this.setTableDe(tableDe);
        this.setValeur();
    }

    public void setValeur() {
        this.valeur = 0;
    }

    public void setTableDe(List<De> tableDe) {
        this.tableDe = tableDe;
    }

    @Override
    public int getValeur() {
        return this.valeur;
    }

    @Override
    public void lancer() {
        this.setValeur();
        for (De de : tableDe
             ) {
            de.lancer();
            this.valeur += de.getValeur();
        }
    }

    @Override
    public void afficher_score() {
        System.out.println("valeur du gobelet : " + this.valeur);
    }
}
