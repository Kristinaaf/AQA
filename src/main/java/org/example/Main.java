package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1 и 2: Массив товаров ===");

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599.0, true);
        productsArray[1] = new Product("iPhone 15 Pro", "15.09.2024", "Apple Inc.", "China", 4800.0, false);
        productsArray[2] = new Product("Xiaomi 14", "10.01.2025", "Xiaomi", "China", 3200.0, true);
        productsArray[3] = new Product("Google Pixel 8", "04.10.2024", "Google LLC", "Vietnam", 3999.0, false);
        productsArray[4] = new Product("OnePlus 12", "05.12.2024", "BBK Electronics", "China", 3500.0, false);

        for (Product product : productsArray) {
            product.printInfo();
        }

        System.out.println("\n=== Задание 3: Парк с вложенным классом ===");

        Park.Attraction attraction1 = new Park.Attraction("Колесо обозрения", "10:00 - 22:00", 500.0);
        Park.Attraction attraction2 = new Park.Attraction("Американские горки", "11:00 - 21:00", 800.0);

        attraction1.printAttractionInfo();
        attraction2.printAttractionInfo();
    }
}