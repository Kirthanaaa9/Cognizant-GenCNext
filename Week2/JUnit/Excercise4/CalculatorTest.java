package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;

public class CalculatorTest {

    private Calculator calculator;

    // Setup: runs before each test
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created.");
    }

    // Teardown: runs after each test
    @After
    public void tearDown() {
        System.out.println("Teardown: Test finished.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }
}
