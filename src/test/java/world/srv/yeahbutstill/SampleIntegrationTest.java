package world.srv.yeahbutstill;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({
        @Tag("integration-test")
})
public class SampleIntegrationTest {
    @Test
    void test1() {
        System.out.println("Integration Test 1");
    }

    @Test
    void test2() {
        System.out.println("Integration Test 2");
    }
}
