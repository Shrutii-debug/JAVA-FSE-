import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int result = c.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testIsPositive_withPositiveNumber() {
        Calculator c = new Calculator();
        boolean result = c.isPositive(5);
        assertTrue(result); // we EXPECT this to be true, and we're checking that it actually is
    }

    @Test
    public void testIsPositive_withNegativeNumber() {
        Calculator c = new Calculator();
        boolean result = c.isPositive(-3);
        assertFalse(result); // we EXPECT this to be false, and we're checking that it actually is
    }
    @Test
    public void testDescribeNumber_withLargeNumber(){
        Calculator c = new Calculator();
        String result = c.describeNumber(150);
        assertNotNull(result);
    }
    @Test
     public void testDescribeNumber_withSmallNumber() {
        Calculator c = new Calculator();
        String result = c.describeNumber(50);
        assertNull(result); // 50 is not > 100, so describeNumber should return null
    }
}