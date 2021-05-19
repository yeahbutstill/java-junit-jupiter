package world.srv.yeahbutstill;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import world.srv.yeahbutstill.resolver.RandomParameterResolver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Extensions(value = {@ExtendWith(RandomParameterResolver.class)})
public class RandomCalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        assertEquals(a + b, calculator.add(a, b));
    }
}
