package firstHomework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestPow extends TestsForCalc{
    @ParameterizedTest
    @CsvSource({"1,3","3,3.3","4.4, 2", "4.8, 8.4", "-10, 5","10, -5", "-2.7, 4", "2.7, -4", "8, -4.7"})
    void testEqClass(double base, double rank){
        assertEquals(Math.pow(base,rank), calculator.pow(base,rank), DELTA);
    }
    @Test
    void testInvalidValue(){
        double base = -4;
        double rank = 4.7;
        assertThrows(NumberFormatException.class, () -> calculator.pow(base, rank));
    }
}
