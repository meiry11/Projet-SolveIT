package coursjunit;

import fr.or.coursjunit.Calculatrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CalculatriceTest {
    Calculatrice cal;
//    @BeforeAll
//    public void starter(){
//
//    }
    @BeforeEach
    public void setUp(){
        cal = new Calculatrice();
    }
    @Test
    @DisplayName("TestAdd")
    public void testAdd(){
        Assertions.assertEquals(10,cal.add(5,5),"addition 5+5");
        Assertions.assertAll("Suite de Test",()->Assertions.assertEquals(15,cal.add(4,11)),
                ()-> Assertions.assertNotEquals(15,cal.add(4,2))
        );
    }

    @Test
    @DisplayName("TestDevide")
    public void testDivide(){
        Assertions.assertThrows(ArithmeticException.class,()-> cal.divide(2,0));
        Assertions.assertAll("Suite division",() ->Assertions.assertEquals(3,cal.divide(15,5)),
                () -> Assertions.assertNotEquals(3,cal.divide(-21,7)));

    }

    @Test
    @DisplayName("TestSub")
    public void testSub(){
        Assertions.assertEquals(15,cal.sub(20,5));
        Assertions.assertNotEquals(15,cal.sub(20,-5));
    }


}
