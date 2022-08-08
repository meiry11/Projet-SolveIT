package banque;

import fr.or.ProjetBank.Compte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompteTest {
    Compte compte;
    Compte compte1;
    @BeforeEach
    public void setUp() throws Exception {
        compte = new Compte();
        compte1 = new Compte(11233,0);
        compte1.setNumCompte(112233);
    }

    @Test
    @DisplayName("TestgetNom")
    public void TestGetNom(){
        Assertions.assertEquals(112233,compte1.getNumCompte());
        Assertions.assertNotEquals(12233,compte1.getNumCompte(),"Not equals");
    }

    @Test
    @DisplayName("TestgetSolde")
    public void TestGetSolde(){
        Assertions.assertEquals(0,compte1.getSolde());
        Assertions.assertNotEquals(12233,compte1.getSolde(),"Not equals");
    }

    @Test
    @DisplayName("Add Commentaire")
    void testAddCommentaire() throws Exception {
        Assertions.assertEquals("a",compte1.addCommentaire("a"),"La methode renoie message");
        Exception result = Assertions.assertThrows(Exception.class,() -> compte1.addCommentaire(""));
        Assertions.assertEquals("Commentaire Vide",result.getMessage());

        Exception result1 = Assertions.assertThrows(Exception.class,() -> compte1.addCommentaire("tttttttttttttttttttt"));
        Assertions.assertEquals("Commentaire long",result1.getMessage());

    }

    @Test
    public void testAjouter(){
        compte1.ajouter(50);
        Assertions.assertEquals(50,compte1.getSolde(),"pas egale");
    }

    @Test
    public void testRetirer() throws Exception {
        compte1.ajouter(50);
        compte1.retirer( 5);
        Assertions.assertEquals(45,compte1.getSolde(),"pas egale");
        Exception result = Assertions.assertThrows(Exception.class, () ->compte1.retirer(50));
        Assertions.assertEquals("Votre solde est insuffisant",result.getMessage());
    }

    @Test
    public void testToString(){
        Assertions.assertEquals(35,compte1.toString().length(),"objet different");

    }

    @Test
    public void testEquals() throws Exception {
        Compte cmp = new Compte(112233,0);
        Assertions.assertTrue(cmp.equals(compte1));
    }

}
