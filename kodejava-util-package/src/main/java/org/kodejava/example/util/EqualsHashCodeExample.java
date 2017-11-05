package org.kodejava.example.util;

import java.time.LocalDate;
import java.time.Month;

public class EqualsHashCodeExample {
    public static void main(String[] args) {
        Student student1 = new Student(1L, "Alice", LocalDate.of(1990, Month.APRIL, 1));
        Student student2 = new Student(1L, "Alice", LocalDate.of(1990, Month.APRIL, 1));
        Student student3 = new Student(2L, "Bob", LocalDate.of(1992, Month.DECEMBER, 21));

        System.out.println("student1.equals(student2) = " + student1.equals(student2));
        System.out.println("student1.equals(student3) = " + student1.equals(student3));
        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student2.hashCode() = " + student2.hashCode());
        System.out.println("student3.hashCode() = " + student3.hashCode());
    }
}
