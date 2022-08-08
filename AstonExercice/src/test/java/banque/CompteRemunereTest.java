package banque;

import fr.or.ProjetBank.CompteRemunere;
import fr.or.ProjetBank.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteRemunereTest {
    CompteRemunere cr;
    @BeforeEach
    void setUp() throws Exception {
        CompteRemunere cr1 = new CompteRemunere();
        CompteRemunere cr2 = new CompteRemunere(12);
        cr = new CompteRemunere(112233,120,12);
    }
    @Test
    public void getTest(){
        Assertions.assertEquals(12,cr.getTaux());
    }
    @Test
    public void setTest(){
        cr.setTaux(5);
        Assertions.assertNotEquals(12,cr.getTaux());
    }
    @Test
    public void testToString(){
        Assertions.assertEquals(25,cr.toString().length(),"objet different");

    }
    @Test
    void calculinteretTest(){
        Assertions.assertEquals(1440,cr.calculerInterets());
    }
    @Test
    void verserInteretTest(){
        cr.verserInterets();
        Assertions.assertNotEquals(120,cr.getSolde());
    }
    @Test
    void ajouterTest(){
        cr.ajouter(50);
        Assertions.assertEquals(170,cr.getSolde());
    }
    @Test
    void retirerTest() throws Exception {
        cr.retirer(50);
        Assertions.assertNotEquals(120,cr.getSolde());
    }
    @Test
    void mainTest(){
        Main m = new Main();
    }
}
