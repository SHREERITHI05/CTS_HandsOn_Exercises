/**
 * BankAccount — Real-world subject used to demonstrate
 * AAA Pattern, Test Fixtures, Setup and Teardown in JUnit.
 */
public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Deposit amount into account
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    // Withdraw amount from account
    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }

    // Returns account owner name
    public String getOwner() {
        return owner;
    }

    // Resets balance to zero (simulates account closure)
    public void closeAccount() {
        balance = 0;
    }

    // Checks if account is active (balance > 0)
    public boolean isActive() {
        return balance > 0;
    }
}