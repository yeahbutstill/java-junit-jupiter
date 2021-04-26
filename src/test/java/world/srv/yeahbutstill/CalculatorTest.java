package world.srv.yeahbutstill;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddSucces() {
        var result = calculator.add(10,10);
        // this is with Assertions
        assertEquals(20, result);
    }

    @Test
    public void testDiveideSucces() {
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

}
