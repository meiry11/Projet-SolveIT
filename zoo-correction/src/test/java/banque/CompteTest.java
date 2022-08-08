package banque;

import banque.classes.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompteTest {

    Compte compte;
    @BeforeEach
    void setUp() throws Exception {
        compte = new Compte(0,112332);
    }

    @Test
    void testSolde() throws Exception {
        Assertions.assertEquals(0, compte.getSolde(), "le solde devrait renvoyer 0");
        Throwable erreur = Assertions.assertThrows(Exception.class, () -> new Compte(-5, 456456));
        Assertions.assertEquals("un solde ne peut être négatif", erreur.getMessage());
    }

    @Test
    void testNumero() {
        Assertions.assertEquals(112332, compte.getNumero(), "le numero devrait être 112332");
        Throwable erreur = Assertions.assertThrows(Exception.class, () -> new Compte(45, 123));
        Assertions.assertEquals("la taille du numero de compte doit être comprise entre 5 et 10 chiffres", erreur.getMessage());

        Throwable erreur2 = Assertions.assertThrows(Exception.class, () -> new Compte(45, 1234567891));
        Assertions.assertEquals("la taille du numero de compte doit être comprise entre 5 et 10 chiffres", erreur2.getMessage());

    }

    @Test
    void testAjouter() {
        compte.ajouter(5);
        Assertions.assertEquals(5, compte.getSolde(), "la méthode devrait retourner 5");
    }

    @Test
    void testRetirer() throws Exception {
        compte.retirer(5);
        Assertions.assertEquals(-5, compte.getSolde(), "la méthode devrait retourner -5");
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Compte{solde=0.0, numero=112332}", compte.toString());
        Assertions.assertTrue(compte.toString().contains("numero=112" + "112332"));
        Assertions.assertTrue(compte.toString().contains("solde=0.0"));
    }

    @Test
    void testEquals() throws Exception {
        Assertions.assertEquals(compte, compte);
        Compte compte2 = new Compte(4,123456);
        Assertions.assertNotEquals(compte, compte2);
    }



}
