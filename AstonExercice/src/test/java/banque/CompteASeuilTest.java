package banque;

import fr.or.ProjetBank.CompteASeuil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteASeuilTest {

    CompteASeuil c1;
    CompteASeuil c2;
    @BeforeEach
    void setUp() throws Exception {
        c1=new CompteASeuil();
        c2 = new CompteASeuil(112233,120,12);
    }
    @Test
    public void getTest(){
        Assertions.assertEquals(12,c2.getSeuil());
    }
    @Test
    public void setTest(){
        c2.setSeuil(11);
        Assertions.assertEquals(11,c2.getSeuil());
    }
    @Test
    public void testToString(){
        Assertions.assertEquals(24,c2.toString().length(),"objet different");

    }
    @Test
    public void verifierTest(){
        Assertions.assertEquals(true,c2.verifier(50));
    }
    @Test
    public void retirerTest() throws Exception {
        c2.retirer((double)50);
        Exception e = Assertions.assertThrows(Exception.class,()->c2.retirer(500));
        Assertions.assertEquals("Depassement du plafond",e.getMessage());
    }
}
