package coursjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    Calculatrice calculatrice;

    @BeforeEach
    void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    void testAdd() {

        Assertions.assertEquals(10, calculatrice.add(5,5), "addition de 5 + 5");
        Assertions.assertAll("suite de test",
                () -> Assertions.assertEquals(15, calculatrice.add(4,11)),
                () -> Assertions.assertNotEquals(15, calculatrice.add(4,2))
        );
    }

    @Test
    void testSub() {
        calculatrice.sub(5,4);
        Assertions.assertEquals(1, calculatrice.liste.size());
        calculatrice.sub(5,4);
        Assertions.assertEquals(2, calculatrice.liste.size());


    }

    @Test
    void testDivide() {
        Assertions.assertThrows(Exception.class, () -> calculatrice.divide(2,0));
    }

    @Test
    void testAddCommentaire() throws Exception {
        // tester si la methode ajoute un commentaire
        Assertions.assertEquals("mest", calculatrice.addCommentaire("mest"), "la methode renvoie message test");
        Exception demo = Assertions.assertThrows(Exception.class, () -> calculatrice.addCommentaire(""));
        Assertions.assertEquals("message vide", demo.getMessage());
        Exception demo2 = Assertions.assertThrows(Exception.class, () -> calculatrice.addCommentaire("kqjbsckqvcksdc"));
        Assertions.assertEquals("message trop long", demo2.getMessage());
    }
}
