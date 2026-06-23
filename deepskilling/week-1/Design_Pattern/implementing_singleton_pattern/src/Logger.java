

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger - Singleton Design Pattern Implementation
 * Ensures a single shared logging instance across the entire application.
 * Uses Bill Pugh's Initialization-on-demand holder idiom:
 * lazy-loaded, thread-safe, and zero synchronization overhead.
 */
public class Logger {

    // Log levels for structured output
    public enum LogLevel {
        INFO, WARNING, ERROR
    }

    private static int logCount = 0;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Private constructor — prevents external instantiation
    private Logger() {
        System.out.println("[Logger] Instance created. (This should print only ONCE)");
    }

    /**
     * Inner static holder class — loaded only when getInstance() is called.
     * JVM guarantees class loading is thread-safe, so no synchronized needed.
     */
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    /**
     * Global access point to the single Logger instance.
     */
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    /**
     * Core log method with timestamp and level tagging.
     */
    public void log(LogLevel level, String message) {
        logCount++;
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.printf("[%s] [%s] [Log #%d] %s%n", timestamp, level, logCount, message);
    }

    // Convenience wrappers
    public void info(String message)    { log(LogLevel.INFO, message); }
    public void warning(String message) { log(LogLevel.WARNING, message); }
    public void error(String message)   { log(LogLevel.ERROR, message); }

    public int getLogCount() { return logCount; }
}