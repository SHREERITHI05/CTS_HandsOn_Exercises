import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * MyServiceTest — Demonstrates Mockito Mocking & Stubbing.
 *
 *  ✔ Mock creation using Mockito.mock()
 *  ✔ Stubbing with when().thenReturn()
 *  ✔ Exception stubbing with thenThrow()
 *  ✔ Interaction verification with verify()
 *  ✔ AAA Pattern throughout
 *
 * Subject Under Test: MyService
 * Mocked Dependency : ExternalApi
 */
public class MyServiceTest {

    // ── Shared mock object (Test Fixture) ──
    private ExternalApi mockApi;
    private MyService service;

    /**
     * @Before — Initializes mock and injects into service before each test.
     * Fresh mock per test prevents stub/interaction bleed between tests.
     */
    @Before
    public void setUp() {
        // Create mock object for ExternalApi interface
        mockApi = Mockito.mock(ExternalApi.class);

        // Inject mock into MyService via constructor
        service = new MyService(mockApi);

        System.out.println("── setUp(): Mock created and injected ──");
    }

    /**
     * @After — Resets mock interactions after each test.
     */
    @After
    public void tearDown() {
        Mockito.reset(mockApi);
        System.out.println("── tearDown(): Mock reset complete ──");
    }

    // ════════════════════════════════════════════════
    //  TEST 1: Stubbing getData() with mock response
    // ════════════════════════════════════════════════
    @Test
    public void testFetchData_ReturnsMockedData() {

        // ARRANGE — stub the external API method
        when(mockApi.getData()).thenReturn("Mock Data");

        // ACT — call the service method
        String result = service.fetchData();

        // ASSERT — verify the stubbed value flows correctly
        assertEquals("Service must return stubbed API data",
                "Mock Data", result);

        // VERIFY — confirm mock was actually called once
        verify(mockApi, times(1)).getData();
    }

    // ════════════════════════════════════════════════
    //  TEST 2: Stubbing null response → fallback message
    // ════════════════════════════════════════════════
    @Test
    public void testFetchData_WhenApiReturnsNull_ReturnsDefault() {

        // ARRANGE
        when(mockApi.getData()).thenReturn(null);

        // ACT
        String result = service.fetchData();

        // ASSERT
        assertEquals("Null API response must return fallback message",
                "No Data Available", result);
    }

    // ════════════════════════════════════════════════
    //  TEST 3: Stubbing getUserData() with specific ID
    // ════════════════════════════════════════════════
    @Test
    public void testFetchUserData_ValidUserId() {

        // ARRANGE
        when(mockApi.getUserData(101)).thenReturn("Mock User: Shree Rithi");

        // ACT
        String result = service.fetchUserData(101);

        // ASSERT
        assertEquals("Must return mocked user data for ID 101",
                "Mock User: Shree Rithi", result);

        // VERIFY
        verify(mockApi, times(1)).getUserData(101);
    }

    // ════════════════════════════════════════════════
    //  TEST 4: Invalid user ID — no API call made
    // ════════════════════════════════════════════════
    @Test
    public void testFetchUserData_InvalidUserId_NoApiCall() {

        // ARRANGE — no stub needed (API should never be called)

        // ACT
        String result = service.fetchUserData(-1);

        // ASSERT
        assertEquals("Negative ID must return error message",
                "Invalid User ID", result);

        // VERIFY — API must NOT be called for invalid ID
        verify(mockApi, never()).getUserData(anyInt());
    }

    // ════════════════════════════════════════════════
    //  TEST 5: Stubbing boolean — service status UP
    // ════════════════════════════════════════════════
    @Test
    public void testGetServiceStatus_WhenAvailable() {

        // ARRANGE
        when(mockApi.isServiceAvailable()).thenReturn(true);

        // ACT
        String status = service.getServiceStatus();

        // ASSERT
        assertEquals("Service UP message must match",
                "Service is UP", status);
    }

    // ════════════════════════════════════════════════
    //  TEST 6: Stubbing boolean — service status DOWN
    // ════════════════════════════════════════════════
    @Test
    public void testGetServiceStatus_WhenUnavailable() {

        // ARRANGE
        when(mockApi.isServiceAvailable()).thenReturn(false);

        // ACT
        String status = service.getServiceStatus();

        // ASSERT
        assertEquals("Service DOWN message must match",
                "Service is DOWN", status);
    }

    // ════════════════════════════════════════════════
    //  TEST 7: Exception stubbing — API throws RuntimeException
    // ════════════════════════════════════════════════
    @Test(expected = RuntimeException.class)
    public void testFetchData_WhenApiThrowsException() {

        // ARRANGE — stub to throw exception
        when(mockApi.getData()).thenThrow(new RuntimeException("API Timeout"));

        // ACT — must propagate the exception
        service.fetchData();

        // ASSERT — handled by @Test(expected = ...)
    }
}