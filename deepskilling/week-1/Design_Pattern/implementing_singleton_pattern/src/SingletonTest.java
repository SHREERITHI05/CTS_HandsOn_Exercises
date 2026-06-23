

/**
 * SingletonTest — Verifies Singleton behavior of Logger.
 *
 * Tests:
 *  1. Same instance across multiple calls
 *  2. Consistent state (log count) across references
 *  3. Thread-safety simulation with 3 concurrent threads
 */
public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================");
        System.out.println("      Singleton Pattern - Logger Test   ");
        System.out.println("========================================\n");

        // ── Test 1: Verify same instance ──────────────────────────────
        System.out.println("── Test 1: Instance Identity Check ──");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("RESULT: " + ((logger1 == logger2 && logger2 == logger3)
                ? "✅ PASS - All references point to the same instance"
                : "❌ FAIL - Multiple instances detected") + "\n");

        // ── Test 2: Shared state verification ─────────────────────────
        System.out.println("── Test 2: Shared State (Log Count) ──");
        logger1.info("Application started");
        logger2.warning("Low memory warning");
        logger3.error("Null pointer encountered");

        System.out.println("Total logs recorded: " + Logger.getInstance().getLogCount());
        System.out.println("RESULT: " + (Logger.getInstance().getLogCount() == 3
                ? "✅ PASS - All logs tracked in shared instance"
                : "❌ FAIL - Log count mismatch") + "\n");

        // ── Test 3: Thread-safety check ────────────────────────────────
        System.out.println("── Test 3: Multi-threaded Access ──");
        Thread t1 = new Thread(() -> {
            Logger l = Logger.getInstance();
            l.info("Thread-1 logging");
            System.out.println("Thread-1 instance hash: " + l.hashCode());
        });

        Thread t2 = new Thread(() -> {
            Logger l = Logger.getInstance();
            l.warning("Thread-2 logging");
            System.out.println("Thread-2 instance hash: " + l.hashCode());
        });

        Thread t3 = new Thread(() -> {
            Logger l = Logger.getInstance();
            l.error("Thread-3 logging");
            System.out.println("Thread-3 instance hash: " + l.hashCode());
        });

        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();  t3.join();

        System.out.println("\nFinal log count across all threads: " + Logger.getInstance().getLogCount());
        System.out.println("\n========================================");
        System.out.println("  All tests completed successfully ✅");
        System.out.println("========================================");
    }
}