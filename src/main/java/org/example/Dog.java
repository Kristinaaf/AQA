package org.example;

public class Dog extends Animal {
    protected static int countDogs = 0;

    public Dog(String name) {
        super(name, 500, 10); //Ограничения: бег 500, плавание 10
        countDogs++;
    }
}
