package org.kodejava.example.util;

import java.util.LinkedList;

public class LinkedListAddItems {
    public static void main(String[] args) {
        LinkedList<String> grades = new LinkedList<>();
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");

        System.out.println("Original values are:");
        System.out.println("====================");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }

        grades.addFirst("A");
        grades.addLast("F");

        System.out.println("New values are:");
        System.out.println("====================");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }
    }
}
