import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingExample — Demonstrates SLF4J logging levels with Logback.
 *
 * Logging Levels (LOW → HIGH severity):
 *   TRACE → DEBUG → INFO → WARN → ERROR
 *
 * SLF4J acts as a facade — Logback is the actual implementation.
 * This separation allows switching logging frameworks without
 * changing application code.
 */
public class LoggingExample {

    // Logger instance — tied to this class for traceability
    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.info("═══════════════════════════════════════");
        logger.info("   SLF4J Logging Demo — All Levels     ");
        logger.info("═══════════════════════════════════════");

        // ── TRACE: Finest detail — method entry/exit tracking ──
        logger.trace("TRACE: Entering main() — finest level logging");

        // ── DEBUG: Useful during development for variable inspection ──
        logger.debug("DEBUG: Application started, initializing components...");
        logger.debug("DEBUG: Config loaded — log level set to DEBUG");

        // ── INFO: General application lifecycle events ──
        logger.info("INFO:  Application is running successfully");
        logger.info("INFO:  User session started");

        // ── WARN: Something unexpected but recoverable ──
        logger.warn("WARN:  Response time exceeded threshold — 3200ms");
        logger.warn("WARN:  Deprecated API method called — update recommended");

        // ── ERROR: Serious failure — needs immediate attention ──
        logger.error("ERROR: Database connection failed — retrying...");
        logger.error("ERROR: Payment gateway timeout — transaction rolled back");

        // ── Parameterized logging — avoids string concatenation cost ──
        String username = "ShreeRithi";
        int attempts    = 3;
        logger.warn("WARN:  User '{}' has {} failed login attempts",
                username, attempts);

        // ── Logging with exception stack trace ──
        try {
            int result = 100 / 0; // Simulated exception
        } catch (ArithmeticException e) {
            logger.error("ERROR: Arithmetic failure in calculation — {}",
                    e.getMessage(), e);
        }

        logger.info("═══════════════════════════════════════");
        logger.info("   Logging Demo Complete                ");
        logger.info("═══════════════════════════════════════");
    }
}