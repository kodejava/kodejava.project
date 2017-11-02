package org.kodejava.example.util;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListIterator {
    public static void main(String[] args) {
        List<String> grades = new LinkedList<>();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");

        // Retrieve objects in LinkedList using Iterator.
        Iterator iterator = grades.iterator();
        while (iterator.hasNext()) {
            System.out.println("Grade: " + iterator.next());
        }
    }
}
