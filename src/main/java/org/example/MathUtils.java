package org.example;

public class MathUtils {
    // 1. Вычисление факториала
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число не может быть отрицательным");
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    // 2. Площадь треугольника (по формуле Герона)
    public double triangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // 3. Арифметические действия
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Деление на ноль!");
        return (double) a / b;
    }

    // 4. Сравнение двух чисел
    public int compare(int a, int b) {
        return Integer.compare(a, b);
    }
}