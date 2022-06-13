package quru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Disabled
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTest1() {
        Assertions.assertTrue(3 > 2);
    }
}
