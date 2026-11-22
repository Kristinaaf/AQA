package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1: Студенты ===");

        Set<Student> students = new HashSet<>();
        students.add(new Student("Иванов", "Группа 1", 1, 4.5));
        students.add(new Student("Петров", "Группа 1", 1, 2.8)); // На отчисление
        students.add(new Student("Сидоров", "Группа 2", 2, 3.0)); // Перевести на 3 курс
        students.add(new Student("Смирнов", "Группа 2", 2, 3.5)); // Перевести на 3 курс

        System.out.println("Список до обработки:");
        for (Student s : students) {
            System.out.println(s);
        }

        // 1. Удаляем студентов со средним баллом < 3
        removeLowGradeStudents(students);

        // 2. Переводим остальных на следующий курс
        promoteStudents(students);

        // 3. Выводим студентов 3-го курса
        System.out.println("\nСтуденты, которые учатся на 3 курсе:");
        printStudents(students, 3);

        System.out.println("\n=== Задание 2: Телефонный справочник ===");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "123-45-67");
        phoneBook.add("Иванов", "8900-000-00-00"); // Второй телефон для той же фамилии
        phoneBook.add("Петров", "555-55-55");

        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров")); // Пустой список
    }

    // Метод удаления студентов с баллом < 3
    public static void removeLowGradeStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                System.out.println("Отчислен студент: " + student.getName());
                iterator.remove();
            }
        }
    }

    // Метод перевода на следующий курс
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Метод печати студентов определенного курса
    public static void printStudents(Set<Student> students, int course) {
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентов на курсе " + course + " не найдено.");
        }
    }
}