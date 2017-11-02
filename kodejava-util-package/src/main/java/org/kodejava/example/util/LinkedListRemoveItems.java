package org.kodejava.example.util;

import java.util.LinkedList;

public class LinkedListRemoveItems {
    public static void main(String[] args) {
        LinkedList<String> grades = new LinkedList<>();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");
        grades.add("F");

        System.out.println("Original values are:");
        System.out.println("====================");
        for (String grade : grades) {
            System.out.println("Grade: " + grade);
        }

        grades.removeFirst();
        grades.removeLast();

        System.out.println("New values are:");
        System.out.println("====================");
        for (String grade : grades) {
            System.out.println("Grade: " + grade);
        }
    }
}
