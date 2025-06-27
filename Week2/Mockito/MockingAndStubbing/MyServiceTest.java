package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Mock the ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the getData() method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Use mock in MyService
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert the result
        assertEquals("Mock Data", result);
    }
}
