package org.example;

public class Park {
    public static class Attraction {
        String name;
        String workingHours;
        double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }
        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + name + " | Время работы: " + workingHours + " | Стоимость: " + cost);
        }
    }
}