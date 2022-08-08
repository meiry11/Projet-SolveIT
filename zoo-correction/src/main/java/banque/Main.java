package banque;

import banque.classes.Client;
import banque.classes.Compte;
import banque.classes.CompteASeuil;
import banque.classes.CompteRemunere;

public class Main {

    public static void main(String[] args) {
        try {
            Compte compte = new Compte(0, 112233);
            CompteRemunere compte2 = new CompteRemunere(0.2,100,1234567);
            CompteASeuil compte3 = new CompteASeuil(-50, 100, 456987);

            Client client = new Client("Dupont", "Marie", 25, 456456);
            client.ajouterCompte(compte);
            client.ajouterCompte(compte2);
            client.ajouterCompte(compte3);
            compte2.verserInteret();
            System.out.println(compte2);
            compte3.retirer(50);
            System.out.println(client.getComptes());


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
