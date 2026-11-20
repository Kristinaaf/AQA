package org.example;

public class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    protected static int countAnimals = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        countAnimals++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + runLimit + " м.)");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " пропыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + swimLimit + " м.)");
        }
    }
}