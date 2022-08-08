package banque;

import fr.or.ProjetBank.Client;
import fr.or.ProjetBank.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    Client client;
    Client client1;
    Compte compte;
    @BeforeEach
    public void setUp() throws Exception {
        client1 = new Client();
         client = new Client("legend","jone",42,123);
        compte = new Compte(112233,12);
    }

    @Test
    public void getTest() throws Exception {
        client.ajouterCompte(compte);
        Assertions.assertEquals("legend",client.getNom());
        Assertions.assertEquals("jone",client.getPrenom());
        Assertions.assertEquals(42,client.getAge());
        Assertions.assertEquals(123,client.getNumero());
        Assertions.assertEquals(compte,client.getCompte(112233));
        Assertions.assertEquals(1,client.getTabComptes().size());

    }

    @Test
    public void setTest(){
        List<Compte> tabComptes = new ArrayList<>();
        tabComptes.add(compte);

        client.setNom("legende");
        Assertions.assertEquals("legende",client.getNom());

        client.setPrenom("jane");
        Assertions.assertNotEquals("jone",client.getPrenom());

        client.setAge(45);
        Assertions.assertEquals(45,client.getAge());

        client.setNumero(12);
        Assertions.assertNotEquals(123,client.getNumero());

        client.setTabComptes(tabComptes);
        Assertions.assertEquals(1,client.getTabComptes().size());

    }

    @Test
    public void ajouterTest() throws Exception {
        Compte compte5 = new Compte(112233,12);
        Compte compte1 = new Compte(112234,12);
        Compte compte2 = new Compte(112235,12);
        Compte compte3 = new Compte(112236,12);
        Compte compte4 = new Compte(112237,12);
        List<Compte> tabComptes = new ArrayList<>();
        tabComptes.add(compte1);
        tabComptes.add(compte2);
        tabComptes.add(compte3);
        tabComptes.add(compte4);
        tabComptes.add(compte5);

        client.setTabComptes(tabComptes);
        System.out.println("size"+client.getTabComptes().size());
        client.ajouterCompte(compte);
        System.out.println("size"+client.getTabComptes().size());

        Exception e = Assertions.assertThrows(Exception.class,()->client.ajouterCompte(compte));
        Assertions.assertEquals("Vous avez deja 5 compte",e.getMessage());
    }
    @Test
    public void testToString(){
        Assertions.assertEquals(70,client.toString().length(),"objet different");

    }

    @Test
    public void testEquals() throws Exception {
        Client client1 = new Client("legend","jone",42,123);
        Assertions.assertEquals(true,client.equals(client1));
    }

}
