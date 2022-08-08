package cours;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CalculatriceTest {
    @BeforeAll
    public void starter(){
        // se lance une fois permet d initialiser nos elements de tests
    }

    @BeforeEach
    public void starter2(){
        // se lance avant chaque test
    }

    @Test
    @DisplayName("démonstration")
    public void testDemo(){
        Assertions.assertEquals(1,1,"open");
    }
}
