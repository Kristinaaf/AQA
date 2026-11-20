package org.example;

public class Bowl {
    private int food;

    public Bowl(int food) {
        // В миске не может быть отрицательного количества еды
        if (food >= 0) {
            this.food = food;
        } else {
            this.food = 0;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.food += amount;
            System.out.println("В миску добавил " + amount + " еды. Теперь в миске: " + this.food);
        }
    }
}
