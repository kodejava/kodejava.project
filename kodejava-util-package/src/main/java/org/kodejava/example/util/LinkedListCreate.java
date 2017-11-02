package org.kodejava.example.util;

import java.util.List;
import java.util.LinkedList;

public class LinkedListCreate {
    public static void main(String[] args) {
        // Creates a new instance of java.util.LinkedList and
        // adds five string object into the list.
        List<String> grades = new LinkedList<>();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("E");
        grades.add("F");

        // Iterates the LinkedList object using the for each
        // statement.
        for (String grade : grades) {
            System.out.println("Grade: " + grade);
        }
    }
}
