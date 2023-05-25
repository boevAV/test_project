package firstHomework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDoubleMulti extends TestsForCalc{
    @ParameterizedTest
    @CsvSource({"9,0","3,4","4, 12.3", "-4,8", "-10, -44","-12.34, 8", "-10.7, -44.1"})
    void testEqClass(double value1, double value2){
        assertEquals(value1 * value2, calculator.mult(value1, value2), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0,Double.MIN_VALUE,Double.MAX_VALUE})
    void testBorders(double value){
        assertEquals(value * value, calculator.mult(value, value), DELTA);
    }
}
