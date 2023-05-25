package firstHomework;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class TestsForCalc {
    protected static Calculator calculator;
    protected static final double DELTA = 1e-15;

    @BeforeAll
    static void init(){
        calculator = new Calculator();
    }
}
