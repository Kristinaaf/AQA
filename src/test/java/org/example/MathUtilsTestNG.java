package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MathUtilsTestNG {
    MathUtils math = new MathUtils();

    @Test
    public void testFactorial() {
        assertEquals(math.factorial(5), 120);
        assertEquals(math.factorial(0), 1);
        assertThrows(IllegalArgumentException.class, () -> math.factorial(-1));
    }

    @Test
    public void testTriangleArea() {
        assertEquals(math.triangleArea(3, 4, 5), 6.0, 0.0001);
    }

    @Test
    public void testArithmetic() {
        assertEquals(math.add(2, 3), 5);
        assertEquals(math.subtract(3, 2), 1);
        assertEquals(math.multiply(2, 3), 6);
        assertEquals(math.divide(5, 2), 2.5);
        assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
    }

    @Test
    public void testCompare() {
        assertTrue(math.compare(5, 3) > 0);
        assertTrue(math.compare(3, 5) < 0);
        assertEquals(math.compare(4, 4), 0);
    }
}