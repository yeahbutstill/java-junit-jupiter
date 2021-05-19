package world.srv.yeahbutstill;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String temp;

    @Test
    public void testA() {
        temp = "Dani";
    }

    @Test
    public void testB() {
        System.out.println(temp);
    }
}
