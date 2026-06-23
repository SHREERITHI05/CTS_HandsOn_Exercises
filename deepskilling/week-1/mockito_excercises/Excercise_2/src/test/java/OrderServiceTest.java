import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * OrderServiceTest — Advanced Mockito Interaction Verification.
 *
 *  ✔ verify with exact argument matching
 *  ✔ atLeast() / atMost() frequency verification
 *  ✔ Interaction order doesn't matter (default Mockito)
 *  ✔ Bulk interaction verification
 *  ✔ Short-circuit verification (service down = no order placed)
 */
public class OrderServiceTest {

    private ExternalApi mockApi;
    private OrderService orderService;

    @Before
    public void setUp() {
        mockApi      = Mockito.mock(ExternalApi.class);
        orderService = new OrderService(mockApi);
        System.out.println("── setUp(): OrderService mock ready ──");
    }

    @After
    public void tearDown() {
        Mockito.reset(mockApi);
        System.out.println("── tearDown(): Mock reset ──");
    }

    // ════════════════════════════════════════════════
    //  TEST 1: placeOrder calls getUserData + getData
    // ════════════════════════════════════════════════
    @Test
    public void testPlaceOrder_VerifiesBothApiCalls() {

        // ARRANGE
        when(mockApi.getUserData(201)).thenReturn("Shree Rithi");
        when(mockApi.getData()).thenReturn("ORD-9981");

        // ACT
        String result = orderService.placeOrder(201, "Laptop");

        // ASSERT
        assertTrue("Result must contain user name",
                result.contains("Shree Rithi"));
        assertTrue("Result must contain item",
                result.contains("Laptop"));

        // VERIFY — both API calls must happen exactly once
        verify(mockApi, times(1)).getUserData(eq(201));
        verify(mockApi, times(1)).getData();
    }

    // ════════════════════════════════════════════════
    //  TEST 2: Invalid order — no API interactions
    // ════════════════════════════════════════════════
    @Test
    public void testPlaceOrder_InvalidInput_NoApiCalls() {

        // ARRANGE — invalid userId

        // ACT
        String result = orderService.placeOrder(-1, "Phone");

        // ASSERT
        assertEquals("Invalid order must return error",
                "Invalid Order", result);

        // VERIFY — zero interactions with mock
        verify(mockApi, never()).getUserData(anyInt());
        verify(mockApi, never()).getData();
        verifyNoMoreInteractions(mockApi);
    }

    // ════════════════════════════════════════════════
    //  TEST 3: Service down — only isServiceAvailable called
    // ════════════════════════════════════════════════
    @Test
    public void testCheckAndOrder_ServiceDown_ShortCircuits() {

        // ARRANGE
        when(mockApi.isServiceAvailable()).thenReturn(false);

        // ACT
        String result = orderService.checkAndOrder(301, "Tablet");

        // ASSERT
        assertEquals("Cancelled message must match",
                "Service Unavailable — Order Cancelled", result);

        // VERIFY — only availability checked, order never placed
        verify(mockApi, times(1)).isServiceAvailable();
        verify(mockApi, never()).getUserData(anyInt());
        verify(mockApi, never()).getData();
    }

    // ════════════════════════════════════════════════
    //  TEST 4: Bulk orders — atLeast / atMost verification
    // ════════════════════════════════════════════════
    @Test
    public void testPlaceBulkOrders_VerifyCallFrequency() {

        // ARRANGE
        String[] items = {"Phone", "Tablet", "Laptop"};
        when(mockApi.getUserData(401)).thenReturn("Bulk User");
        when(mockApi.getData()).thenReturn("BULK-REF");

        // ACT
        orderService.placeBulkOrders(401, items);

        // VERIFY — called exactly 3 times (once per item)
        verify(mockApi, times(3)).getUserData(eq(401));
        verify(mockApi, times(3)).getData();

        // VERIFY — frequency bounds
        verify(mockApi, atLeast(2)).getUserData(anyInt());
        verify(mockApi, atMost(5)).getData();
    }
}