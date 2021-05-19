package world.srv.yeahbutstill;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Random;


public class RandomCalculatorTest1 extends AbstractCalculatorTest {

    @Test
    public void testRandom(TestInfo info, Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(a + b, calculator.add(a, b));
    }
}
