package world.srv.yeahbutstill;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter = 0;

    @Test
    @Order(1)
    public void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    public void test2() {

    }

    @Test
    @Order(3)
    public void test1() {

    }
}
