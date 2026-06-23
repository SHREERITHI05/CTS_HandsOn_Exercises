/**
 * ExternalApi — Interface representing a third-party/external API.
 * In production, this would make real HTTP/DB calls.
 * In tests, we MOCK this to avoid real network dependency.
 */
public interface ExternalApi {

    // Fetches raw data from external source
    String getData();

    // Fetches data for a specific user ID
    String getUserData(int userId);

    // Checks if the external service is available
    boolean isServiceAvailable();
}