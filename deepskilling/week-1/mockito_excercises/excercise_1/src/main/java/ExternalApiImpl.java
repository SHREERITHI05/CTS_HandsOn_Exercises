/**
 * ExternalApiImpl — Real implementation of ExternalApi.
 * Would make actual API calls in production.
 * NOT used in unit tests — replaced by Mockito mock.
 */
public class ExternalApiImpl implements ExternalApi {

    @Override
    public String getData() {
        // Simulates real API call (e.g., HTTP GET)
        return "Real API Data";
    }

    @Override
    public String getUserData(int userId) {
        return "Real User Data for ID: " + userId;
    }

    @Override
    public boolean isServiceAvailable() {
        return true; // Would ping real endpoint
    }
}