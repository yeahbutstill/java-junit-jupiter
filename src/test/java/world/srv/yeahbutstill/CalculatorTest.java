package world.srv.yeahbutstill;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import world.srv.yeahbutstill.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

// menggunakan generator name
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk Calculator class") // manual name
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
//    @DisplayName("Test skenario suskes untuk method add(Integer first, Integer second)")
    public void testAddSucces() {
        var result = calculator.add(10,10);
        // this is with Assertions
        assertEquals(20, result);
    }

    @Test
//    @DisplayName("Test skenario sukses untuk method devide(Integer first, Integer second)")
    public void testDivideSucces() {
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
//    @DisplayName("Test skenario kalau gagal pada method add(Integer first, Integer second)")
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon() {

    }

    @Test
    public void testAbortedTest() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
        // unit test untuk DEV
    }
}