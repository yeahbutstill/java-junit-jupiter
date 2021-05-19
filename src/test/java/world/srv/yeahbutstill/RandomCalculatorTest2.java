package world.srv.yeahbutstill;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RandomCalculatorTest2 extends AbstractCalculatorTest {

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5);
    }

    @Test
    public void testRandom(TestInfo info, Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        assertEquals(a + b, calculator.add(a, b));
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepeatitions}"
    )
    public void testRandomRepeat(TestInfo info, Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        assertEquals(a + b, calculator.add(a, b));
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(value = 10, name = "{displayName}")
    public void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        assertEquals(a + b, calculator.add(a, b));
    }

    @DisplayName("Test Calculator with Parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource(value = {"parameterSource"})
    public void testWithMethodSource(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);
        assertEquals(expected, result);
    }
}
