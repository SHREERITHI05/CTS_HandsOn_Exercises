package org.example;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    // Runs before each test method
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created");
    }

    // Runs after each test method
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance destroyed");
    }

    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals("5 + 3 should equal 8", 8, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals("10 - 4 should equal 6", 6, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 5);
        assertEquals("4 * 5 should equal 20", 20, result);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals("10 / 2 should equal 5.0", 5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0); // Should throw ArithmeticException
    }
}





