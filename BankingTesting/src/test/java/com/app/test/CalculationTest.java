package com.app.test;

import org.junit.jupiter.api.Test;

import com.app.MathOperation;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationTest {

	@Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
	
	@Test
    void testAdd() {
		MathOperation calc = new MathOperation();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testMultiply() {
    	MathOperation calc = new MathOperation();
        int result = calc.multiply(4, 5);
        assertEquals(20, result);
    }
}
