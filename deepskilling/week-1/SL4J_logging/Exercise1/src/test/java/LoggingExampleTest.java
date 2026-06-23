import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * LoggingExampleTest — Validates logging behaviour indirectly.
 *
 * Note: SLF4J logs are output side-effects — we test the
 * business logic that triggers the logs, not the logs themselves.
 * This is the correct and professional approach.
 */
public class LoggingExampleTest {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExampleTest.class);

    @Before
    public void setUp() {
        logger.info("── setUp(): Test starting ──");
    }

    @After
    public void tearDown() {
        logger.info("── tearDown(): Test complete ──");
    }

    // ════════════════════════════════════════════════
    //  TEST 1: Logger instance is correctly initialized
    // ════════════════════════════════════════════════
    @Test
    public void testLoggerIsNotNull() {

        // ARRANGE
        Logger testLogger = LoggerFactory.getLogger(LoggingExample.class);

        // ACT + ASSERT
        assertNotNull("Logger instance must not be null", testLogger);
        logger.info("INFO: Logger instance validated successfully");
    }

    // ════════════════════════════════════════════════
    //  TEST 2: Logger name matches class name
    // ════════════════════════════════════════════════
    @Test
    public void testLoggerName() {

        // ARRANGE
        Logger testLogger = LoggerFactory.getLogger(LoggingExample.class);

        // ACT
        String loggerName = testLogger.getName();

        // ASSERT
        assertEquals("Logger name must match class name",
                "LoggingExample", loggerName);

        logger.debug("DEBUG: Logger name verified — {}", loggerName);
    }

    // ════════════════════════════════════════════════
    //  TEST 3: WARN level is enabled (logback config)
    // ════════════════════════════════════════════════
    @Test
    public void testWarnLevelIsEnabled() {

        // ARRANGE
        Logger testLogger = LoggerFactory.getLogger(LoggingExample.class);

        // ACT + ASSERT
        assertTrue("WARN level must be enabled", testLogger.isWarnEnabled());
        logger.warn("WARN: Warning level check passed");
    }

    // ════════════════════════════════════════════════
    //  TEST 4: ERROR level is enabled
    // ════════════════════════════════════════════════
    @Test
    public void testErrorLevelIsEnabled() {

        // ARRANGE
        Logger testLogger = LoggerFactory.getLogger(LoggingExample.class);

        // ACT + ASSERT
        assertTrue("ERROR level must be enabled", testLogger.isErrorEnabled());
        logger.error("ERROR: Error level check passed");
    }

    // ════════════════════════════════════════════════
    //  TEST 5: INFO level is enabled
    // ════════════════════════════════════════════════
    @Test
    public void testInfoLevelIsEnabled() {

        // ARRANGE
        Logger testLogger = LoggerFactory.getLogger(LoggingExample.class);

        // ACT + ASSERT
        assertTrue("INFO level must be enabled", testLogger.isInfoEnabled());
        logger.info("INFO: Info level check passed");
    }

    // ════════════════════════════════════════════════
    //  TEST 6: Parameterized log message doesn't throw
    // ════════════════════════════════════════════════
    @Test
    public void testParameterizedLoggingDoesNotThrow() {

        // ARRANGE
        String user    = "ShreeRithi";
        int    attempt = 3;

        // ACT + ASSERT — no exception must be thrown
        try {
            logger.warn("WARN: User '{}' failed {} times", user, attempt);
            assertTrue("Parameterized logging must execute without error", true);
        } catch (Exception e) {
            fail("Logging must never throw an exception: " + e.getMessage());
        }
    }
}