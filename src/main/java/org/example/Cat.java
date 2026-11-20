package org.example;

public class Cat extends Animal {
    protected static int countCats = 0;
    private boolean satiety; // false = голоден, true = сыт

    public Cat(String name) {
        super(name, 200, 0); // Ограничения: бег 200, плавать не умеет (0)
        countCats++;
        this.satiety = false; // Изначально голоден
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.setFood(bowl.getFood() - amount);
            this.satiety = true;
            System.out.println(name + " съел " + amount + " еды и наелся.");
        } else {
            System.out.println(name + " не стал есть, в миске недостаточно еды (нужно " + amount + ", есть " + bowl.getFood() + ").");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}