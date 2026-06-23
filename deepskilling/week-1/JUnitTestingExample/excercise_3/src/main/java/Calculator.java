/**
 * Calculator utility class.
 * Acts as the real-world subject being tested in AssertionsTest.
 */
public class Calculator {

    // Returns sum of two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Returns true if first number is greater than second
    public boolean isGreater(int a, int b) {
        return a > b;
    }

    // Returns null to simulate an uninitialized result
    public String getNullResult() {
        return null;
    }

    // Returns a non-null default message
    public String getDefaultMessage() {
        return "JUnit Assertions Test Passed!";
    }
}