package world.srv.yeahbutstill;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    public void testOnlyRunOnWindows() {
        // put yout unit test
    }

    @Test
    @DisabledOnOs(value = {OS.WINDOWS})
    public void testDisabledRunOnWindows() {
        // put your unit test
    }

    @Test
    @EnabledOnJre(value = {JRE.JAVA_11})
    public void testOnlyRunOnJava11() {
        // put your unit test
    }

    @Test
    @EnabledOnJre(value = {JRE.JAVA_11})
    public void testDisabledRunOnJava11() {
        // put your unit test
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    public void testOnlyRunJava11ToJava17() {
        // put your unit test
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    public void testDisabledRunOnJava11ToJava17() {
        // put your unit test
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnabledOnOracle() {
        // put your unit test
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testDisabledOnOracle() {
        // put your unit test
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {
        // put your unit test
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev() {
        // put your unit test
    }

}
