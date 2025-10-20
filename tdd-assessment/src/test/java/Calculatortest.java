import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Calculatortest {

    public Calculator Calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @ParameterizedTest(name = "Addition: {0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "10, 5, 15",
            "-5, 5, 0",
            "-10, -5, -15"

        })
        void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }

    @Test
    void testSubtract() {
        assertEquals(1, Calculator.subtract(3, 2));
    }

    @ParameterizedTest(name = "Subtraction: {0} - {1} = {2}")
    @CsvSource({
            "3, 2, 1",
            "10, 3, 7",
            "5, 5, 0",
            "5, 10, -5",
            "5, -5, 10"
    })
    void testSubtractParameterized(int a, int b, int expected) {
        assertEquals(expected, Calculator.subtract(a, b));
    }

    @Test
    void testMultiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }

    @ParameterizedTest(name = "Multiplication: {0} * {1} = {2}")
    @CsvSource({
            "2, 3, 6",
            "0, 5, 0",
            "-2, 4, -8",
            "-3, -2, 6",
            "10, 1, 10"
    })
    void testMultiplyParameterized(int a, int b, int expected) {
        assertEquals(expected, Calculator.multiply(a, b));
    }

    @ParameterizedTest(name = "Division: {0} / {1} = {2}")
    @CsvSource({
            "4, 1, 4",
            "10, 5, 2",
            "7, 3, 2",
            "-10, 5, -2",
            "-10, -5, 2"
    })
    void testDivideParameterized(int a, int b, int expected) {
        assertEquals(expected, Calculator.divide(a, b));
    }


    @Test
    void testDivide() {
        assertEquals(2, Calculator.divide(4, 2));
    }


}
