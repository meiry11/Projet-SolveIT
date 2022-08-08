package cours;

import org.junit.jupiter.api.*;

class demoTest {

/*    @BeforeAll
    public void starter() {
        System.out.println("ok");
        // se lance une fois, permet d'initialiser les elements liés aux tests
    }

    @BeforeEach
    public void starter2() {
        System.out.println("ok");
        // se lance avant chaque test
    }*/

    @Test
    @DisplayName("démonstration")
    public void testDemo() {
        Assertions.assertEquals(1, 0, "open");
    }
}
