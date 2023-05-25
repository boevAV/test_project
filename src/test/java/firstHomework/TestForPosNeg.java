package firstHomework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestForPosNeg extends TestsForCalc {
    @ParameterizedTest
    @ValueSource(ints = {-5, -5000, Integer.MIN_VALUE})
    void testNeg(int value){
        assertTrue(calculator.isNegative(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 5000, Integer.MAX_VALUE})
    void testPos(int value){
        assertFalse(calculator.isNegative(value));
    }
}
