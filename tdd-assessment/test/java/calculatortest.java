package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.src.calculator;

public class calculatortest {
    @Test
    void testadd() {
        calculator c = new calculator();
        assertEquals(5, c.add(2, 3)); 
    }
    @P

}
