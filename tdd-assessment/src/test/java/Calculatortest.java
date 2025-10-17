import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Calculatortest {

    public Calculator Calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, Calculator.subtract(3, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }


    @Test
    void testDivide() {
        assertEquals(2, Calculator.divide(4, 2));
    }


}
