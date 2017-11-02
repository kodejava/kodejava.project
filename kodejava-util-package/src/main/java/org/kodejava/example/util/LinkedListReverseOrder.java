package org.kodejava.example.util;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListReverseOrder {
    public static void main(String[] args) {
        LinkedList<String> grades = new LinkedList<>();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");
        grades.add("F");

        System.out.println("Output in original order:");
        System.out.println("=========================");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }

        // Reverse the element order in the linked list object.
        Collections.reverse(grades);

        System.out.println("Output in reverse order:");
        System.out.println("=========================");
        for (String grade : grades) {
            System.out.println("Grade = " + grade);
        }
    }
}
