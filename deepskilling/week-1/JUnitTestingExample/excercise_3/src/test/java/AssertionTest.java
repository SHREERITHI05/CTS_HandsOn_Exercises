import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * AssertionsTest — Demonstrates core JUnit assertion types.
 *
 * Covers: assertEquals, assertTrue, assertFalse,
 *         assertNull, assertNotNull, assertSame, assertArrayEquals
 *
 * Subject Under Test: Calculator
 */
public class AssertionTest {

    private Calculator calculator;

    /**
     * Initializes Calculator instance before each test.
     * @Before ensures a fresh object per test — avoids state leakage.
     */
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    /**
     * Core assertion test covering all fundamental JUnit assert methods.
     */
    @Test
    public void testAssertions() {

        // ── 1. assertEquals: validates expected vs actual value ──
        assertEquals("2 + 3 must equal 5", 5, calculator.add(2, 3));

        // ── 2. assertTrue: condition must evaluate to true ──
        assertTrue("5 should be greater than 3", calculator.isGreater(5, 3));

        // ── 3. assertFalse: condition must evaluate to false ──
        assertFalse("3 should NOT be greater than 5", calculator.isGreater(3, 5));

        // ── 4. assertNull: object reference must be null ──
        assertNull("Uninitialized result must be null", calculator.getNullResult());

        // ── 5. assertNotNull: object must be a valid reference ──
        assertNotNull("Default message must not be null", calculator.getDefaultMessage());

        // ── 6. assertSame: checks reference equality (same object) ──
        String message = calculator.getDefaultMessage();
        String reference = message;
        assertSame("Both references must point to same object", message, reference);

        // ── 7. assertArrayEquals: validates array content & order ──
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual   = {1, 2, 3, 4, 5};
        assertArrayEquals("Arrays must be equal element by element", expected, actual);
    }

    /**
     * Boundary check: add() with negative numbers.
     * Shows understanding of edge case testing.
     */
    @Test
    public void testAddWithNegativeNumbers() {
        assertEquals("Negative + Positive should work correctly", -1, calculator.add(-4, 3));
        assertEquals("Both negatives should sum correctly", -7, calculator.add(-3, -4));
    }

    /**
     * Boundary check: isGreater() with equal values.
     * Equal numbers → isGreater must return false.
     */
    @Test
    public void testEqualNumbersAreNotGreater() {
        assertFalse("Equal numbers — neither is greater", calculator.isGreater(5, 5));
    }
}