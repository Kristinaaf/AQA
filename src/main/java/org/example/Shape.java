package org.example;

public interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Фигура: " + getClass().getSimpleName() +
                " | Периметр: " + String.format("%.2f", getPerimeter()) +
                " | Площадь: " + String.format("%.2f", getArea()) +
                " | Цвет фона: " + getFillColor() +
                " | Цвет границы: " + getBorderColor());
    }
}