import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * BankAccountTest — Demonstrates:
 *
 *  ✔ Arrange-Act-Assert (AAA) Pattern
 *  ✔ Test Fixtures (@Before setup)
 *  ✔ Teardown (@After cleanup)
 *  ✔ Edge case & exception handling tests
 *
 * Subject Under Test: BankAccount
 */
public class BankAccountTest {

    // ── Test Fixture: shared object across all tests ──
    private BankAccount account;

    /**
     * @Before — Runs BEFORE every test method.
     * Sets up a fresh BankAccount to avoid state leakage between tests.
     * This is the ARRANGE phase shared across tests (Test Fixture).
     */
    @Before
    public void setUp() {
        account = new BankAccount("Shree Rithi", 1000.00);
        System.out.println("── setUp(): BankAccount initialized with ₹1000 ──");
    }

    /**
     * @After — Runs AFTER every test method.
     * Cleans up resources / simulates teardown (e.g., closing DB connections).
     */
    @After
    public void tearDown() {
        account.closeAccount();
        System.out.println("── tearDown(): BankAccount closed, balance reset ──");
    }

    // ════════════════════════════════════════════════
    //  TEST 1: Deposit increases balance correctly
    // ════════════════════════════════════════════════
    @Test
    public void testDeposit() {

        // ARRANGE — additional setup specific to this test
        double depositAmount = 500.00;
        double expectedBalance = 1500.00;

        // ACT — perform the action being tested
        account.deposit(depositAmount);

        // ASSERT — verify the outcome
        assertEquals("Balance after deposit must be ₹1500",
                expectedBalance, account.getBalance(), 0.001);
    }

    // ════════════════════════════════════════════════
    //  TEST 2: Withdrawal reduces balance correctly
    // ════════════════════════════════════════════════
    @Test
    public void testWithdraw() {

        // ARRANGE
        double withdrawAmount = 300.00;
        double expectedBalance = 700.00;

        // ACT
        account.withdraw(withdrawAmount);

        // ASSERT
        assertEquals("Balance after withdrawal must be ₹700",
                expectedBalance, account.getBalance(), 0.001);
    }

    // ════════════════════════════════════════════════
    //  TEST 3: Account is active when balance > 0
    // ════════════════════════════════════════════════
    @Test
    public void testAccountIsActive() {

        // ARRANGE — account has ₹1000 from setUp()

        // ACT
        boolean status = account.isActive();

        // ASSERT
        assertTrue("Account with positive balance must be active", status);
    }

    // ════════════════════════════════════════════════
    //  TEST 4: Account owner name is correct
    // ════════════════════════════════════════════════
    @Test
    public void testAccountOwner() {

        // ARRANGE
        String expectedOwner = "Shree Rithi";

        // ACT
        String actualOwner = account.getOwner();

        // ASSERT
        assertEquals("Owner name must match", expectedOwner, actualOwner);
    }

    // ════════════════════════════════════════════════
    //  TEST 5: Overdraft throws IllegalArgumentException
    // ════════════════════════════════════════════════
    @Test(expected = IllegalArgumentException.class)
    public void testOverdraftThrowsException() {

        // ARRANGE
        double overdraftAmount = 5000.00; // exceeds balance of ₹1000

        // ACT — must throw IllegalArgumentException
        account.withdraw(overdraftAmount);

        // ASSERT — handled by @Test(expected = ...)
    }

    // ════════════════════════════════════════════════
    //  TEST 6: Negative deposit throws exception
    // ════════════════════════════════════════════════
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDepositThrowsException() {

        // ARRANGE
        double invalidDeposit = -200.00;

        // ACT — must throw IllegalArgumentException
        account.deposit(invalidDeposit);

        // ASSERT — handled by @Test(expected = ...)
    }

    // ════════════════════════════════════════════════
    //  TEST 7: Account inactive after closeAccount()
    // ════════════════════════════════════════════════
    @Test
    public void testAccountInactiveAfterClosure() {

        // ARRANGE — account has balance from setUp()

        // ACT
        account.closeAccount();

        // ASSERT
        assertFalse("Closed account must be inactive", account.isActive());
        assertEquals("Closed account balance must be 0",
                0.0, account.getBalance(), 0.001);
    }
}