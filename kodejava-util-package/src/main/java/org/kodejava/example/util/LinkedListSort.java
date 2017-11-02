package org.kodejava.example.util;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListSort {
    public static void main(String[] args) {
        LinkedList<String> grades = new LinkedList<>();
        grades.add("E");
        grades.add("C");
        grades.add("A");
        grades.add("F");
        grades.add("B");
        grades.add("D");

        System.out.println("Before sorting:");
        System.out.println("===============");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }

        // Sort the elements of linked list based on its data
        // natural order.
        Collections.sort(grades);

        System.out.println("After sorting:");
        System.out.println("===============");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }
    }
}
