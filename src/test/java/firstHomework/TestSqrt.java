package firstHomework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestSqrt extends TestsForCalc{
    @ParameterizedTest
    @ValueSource(doubles = {0, 1, 2700, 845, 13.24, Double.MAX_VALUE, Double.MIN_VALUE})
    void testEqClass(double value){
        assertEquals(Math.sqrt(value),calculator.sqrt(value), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -3, -2.2, -Double.MAX_VALUE})
    void testNeg(double value){
        assertThrows(NumberFormatException.class, ()->calculator.sqrt(value));
    }
}

