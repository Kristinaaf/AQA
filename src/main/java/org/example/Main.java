package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1: Животные ===");

        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик");
        Cat catMurka = new Cat("Мурка");

        dogBobik.run(150);
        dogBobik.run(600); // Превышение лимита
        dogBobik.swim(5);
        dogBobik.swim(15); // Превышение лимита

        catBarsik.run(100);
        catBarsik.run(250); // Превышение лимита
        catBarsik.swim(5); // Коты не плавают

        Bowl bowl = new Bowl(10); // Миска с 10 еды
        catBarsik.eat(bowl, 15);  // Пытается съесть 15 (не хватит)
        catMurka.eat(bowl, 5);    // Пытается съесть 5 (хватит)

        bowl.addFood(20);         // Добавляем еду
        catBarsik.eat(bowl, 10);  // Теперь Барсик может поесть

        System.out.println("\nСытость котов:");
        System.out.println(catBarsik.getName() + " сыт? " + catBarsik.isSatiety());
        System.out.println(catMurka.getName() + " сыт? " + catMurka.isSatiety());

        System.out.println("\nВсего создано: Животных - " + Animal.countAnimals +
                ", Собак - " + Dog.countDogs +
                ", Котов - " + Cat.countCats);

        System.out.println("\n=== Задание 2: Геометрические фигуры ===");

        Shape circle = new Circle(5.0, "Красный", "Черный");
        Shape rectangle = new Rectangle(4.0, 6.0, "Синий", "Желтый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Белый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}