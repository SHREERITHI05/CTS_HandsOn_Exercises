/**
 * OrderService — Simulates a real order processing system.
 * Depends on ExternalApi for payment and notification calls.
 * Used to demonstrate advanced Mockito interaction verification.
 */
public class OrderService {

    private final ExternalApi externalApi;

    public OrderService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    // Places an order for a specific user
    public String placeOrder(int userId, String item) {
        if (userId <= 0 || item == null || item.isEmpty()) {
            return "Invalid Order";
        }
        String userData = externalApi.getUserData(userId);
        String confirmation = externalApi.getData();
        return "Order placed for " + userData + " | Item: " + item
                + " | Ref: " + confirmation;
    }

    // Checks availability before ordering
    public String checkAndOrder(int userId, String item) {
        boolean available = externalApi.isServiceAvailable();
        if (!available) {
            return "Service Unavailable — Order Cancelled";
        }
        return placeOrder(userId, item);
    }

    // Bulk order — calls getUserData multiple times
    public void placeBulkOrders(int userId, String[] items) {
        for (String item : items) {
            externalApi.getUserData(userId);
            externalApi.getData();
        }
    }
}