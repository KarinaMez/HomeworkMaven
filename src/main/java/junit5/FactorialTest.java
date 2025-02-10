package junit5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-5));
    }
}