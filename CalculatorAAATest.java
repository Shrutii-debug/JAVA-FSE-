
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAAATest {

    // The FIXTURE - declared at class level so @BeforeEach can set it up
    // and every @Test method can use it without recreating it
    private Calculator calculator;
    
    @BeforeAll
    public static void initAll() {
        // Runs ONCE before any test in this class
        // Use for expensive one-time setup (e.g. starting a server, loading a config file)
        System.out.println("=== Starting CalculatorAAATest suite ===");
    }

    @BeforeEach
    public void setUp() {
        // Runs before EVERY @Test method
        // Creates a fresh Calculator so no test can accidentally affect another
        calculator = new Calculator();
        System.out.println("--- Setting up fresh Calculator ---");
    }

    @AfterEach
    public void tearDown() {
        // Runs after EVERY @Test method, even if the test FAILED
        // Ensures cleanup always happens regardless of test outcome
        calculator = null;
        System.out.println("--- Cleaned up after test ---");
    }

    @AfterAll
    public static void tearDownAll() {
        // Runs ONCE after ALL tests in this class have finished
        System.out.println("=== Finished CalculatorAAATest suite ===");
    }

    // -------------------------------------------------------
    // TEST METHODS - all following the AAA pattern
    // -------------------------------------------------------

    @Test
    public void testAdd_twoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testAdd_negativeNumbers() {
        // Arrange
        int a = -4;
        int b = -6;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(-10, result);
    }

    @Test
    public void testIsPositive_withPositiveNumber() {
        // Arrange
        int number = 5;

        // Act
        boolean result = calculator.isPositive(number);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsPositive_withNegativeNumber() {
        // Arrange
        int number = -3;

        // Act
        boolean result = calculator.isPositive(number);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testDescribeNumber_largeNumber() {
        // Arrange
        int number = 150;

        // Act
        String result = calculator.describeNumber(number);

        // Assert
        assertNotNull(result);
        assertEquals("Large number", result);
    }

    @Test
    public void testDescribeNumber_smallNumber() {
        // Arrange
        int number = 50;

        // Act
        String result = calculator.describeNumber(number);

        // Assert
        assertNull(result);
    }

    @Test
    public void testDivide_normalCase() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testDivide_byZero_throwsException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act + Assert (combined for exception tests - the act IS the thing being asserted)
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a, b);
        });
    }
}
