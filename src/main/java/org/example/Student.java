package org.example;

import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private double averageGrade;

    public Student(String name, String group, int course, double averageGrade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public String getName() { return  name; }
    public int getCourse() { return course; }
    public double getAverageGrade() { return averageGrade; }

    public void setCourse(int course) { this.course = course; }

    //Переопределяем методы equals и hashCode, чтобы Set корректно определял дубликаты студентов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Double.compare(student.averageGrade, averageGrade) == 0 &&
                Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, averageGrade);
    }

    @Override
    public String toString() {
        return "Студент: " + name + " | Группа: " + group + " | Курс: " + course + " | Средний бал " + averageGrade;
    }
}