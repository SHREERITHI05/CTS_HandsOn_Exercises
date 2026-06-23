import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * MyServiceTest — Extended with Interaction Verification.
 *
 *  ✔ verify() — method was called
 *  ✔ verify(times(n)) — called exact number of times
 *  ✔ verify(never()) — method was never called
 *  ✔ verify(atLeast/atMost) — call frequency bounds
 *  ✔ verifyNoMoreInteractions() — no unexpected calls
 *  ✔ Argument matching with eq() and anyInt()
 */
public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi  = Mockito.mock(ExternalApi.class);
        service  = new MyService(mockApi);
        System.out.println("── setUp(): Mock created and injected ──");
    }

    @After
    public void tearDown() {
        Mockito.reset(mockApi);
        System.out.println("── tearDown(): Mock reset ──");
    }

    // ════════════════════════════════════════════════
    //  TEST 1: Basic verify — getData() was called once
    // ════════════════════════════════════════════════
    @Test
    public void testVerifyInteraction_GetDataCalledOnce() {

        // ARRANGE
        when(mockApi.getData()).thenReturn("Mock Data");

        // ACT
        service.fetchData();

        // ASSERT + VERIFY
        verify(mockApi).getData();                    // called at least once
        verify(mockApi, times(1)).getData();          // called exactly once
    }

    // ════════════════════════════════════════════════
    //  TEST 2: Verify with specific argument — eq()
    // ════════════════════════════════════════════════
    @Test
    public void testVerifyInteraction_WithSpecificArgument() {

        // ARRANGE
        when(mockApi.getUserData(101)).thenReturn("Shree Rithi");

        // ACT
        service.fetchUserData(101);

        // ASSERT + VERIFY — must be called with EXACTLY 101
        verify(mockApi, times(1)).getUserData(eq(101));
    }

    // ════════════════════════════════════════════════
    //  TEST 3: Verify never called — invalid input
    // ════════════════════════════════════════════════
    @Test
    public void testVerifyInteraction_NeverCalled_InvalidId() {

        // ARRANGE — no stub needed

        // ACT
        service.fetchUserData(-5);

        // ASSERT + VERIFY — API must NEVER be called for invalid ID
        verify(mockApi, never()).getUserData(anyInt());
        verify(mockApi, never()).getData();
    }

    // ════════════════════════════════════════════════
    //  TEST 4: Verify no more interactions after fetchData
    // ════════════════════════════════════════════════
    @Test
    public void testVerifyNoMoreInteractions() {

        // ARRANGE
        when(mockApi.getData()).thenReturn("Clean Data");

        // ACT
        service.fetchData();

        // ASSERT + VERIFY
        verify(mockApi).getData();

        // Ensures no OTHER unexpected methods were called on mock
        verifyNoMoreInteractions(mockApi);
    }

    // ════════════════════════════════════════════════
    //  TEST 5: Verify isServiceAvailable() interaction
    // ════════════════════════════════════════════════
    @Test
    public void testVerifyServiceStatusCheck() {

        // ARRANGE
        when(mockApi.isServiceAvailable()).thenReturn(true);

        // ACT
        service.getServiceStatus();

        // ASSERT + VERIFY
        verify(mockApi, times(1)).isServiceAvailable();
        verify(mockApi, never()).getData();           // getData must NOT be triggered
        verify(mockApi, never()).getUserData(anyInt());
    }
}