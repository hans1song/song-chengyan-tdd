package src.test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import src.main.java.Calculator;

class CalculatorTest {

    public Calculator Calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

}