/**
 * MyService — Business logic layer.
 * Depends on ExternalApi (injected via constructor).
 * This is the class we actually want to test.
 *
 * Uses Dependency Injection — makes it fully mockable.
 */
public class MyService {

    private final ExternalApi externalApi;

    // Constructor Injection — best practice for testability
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    // Fetches and processes general data from API
    public String fetchData() {
        String data = externalApi.getData();
        if (data == null || data.isEmpty()) {
            return "No Data Available";
        }
        return data;
    }

    // Fetches data for a specific user
    public String fetchUserData(int userId) {
        if (userId <= 0) {
            return "Invalid User ID";
        }
        return externalApi.getUserData(userId);
    }

    // Returns service status message
    public String getServiceStatus() {
        boolean available = externalApi.isServiceAvailable();
        return available ? "Service is UP" : "Service is DOWN";
    }
}