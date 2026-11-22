package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    // Создаем объект нашего класса, чтобы вызывать его методы
    MathUtils math = new MathUtils();

    @Test
    void testFactorial() {
        assertEquals(120, math.factorial(5)); // 5! = 120
        assertEquals(1, math.factorial(0));   // 0! = 1
        // Проверяем, что при отрицательном числе выбрасывается ошибка
        assertThrows(IllegalArgumentException.class, () -> math.factorial(-1));
    }

    @Test
    void testTriangleArea() {
        // Проверяем площадь египетского треугольника (3, 4, 5). Площадь = 6.
        // 0.0001 - это погрешность для чисел с плавающей точкой (double)
        assertEquals(6.0, math.triangleArea(3, 4, 5), 0.0001);
    }

    @Test
    void testArithmetic() {
        assertEquals(5, math.add(2, 3));
        assertEquals(1, math.subtract(3, 2));
        assertEquals(6, math.multiply(2, 3));
        assertEquals(2.5, math.divide(5, 2));

        // Проверяем деление на ноль
        assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
    }

    @Test
    void testCompare() {
        assertTrue(math.compare(5, 3) > 0);  // 5 больше 3 (вернет 1)
        assertTrue(math.compare(3, 5) < 0);  // 3 меньше 5 (вернет -1)
        assertEquals(0, math.compare(4, 4)); // 4 равно 4 (вернет 0)
    }
}