package org.kodejava.example.util;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListListIterator {
    public static void main(String[] args) {
        List<String> grades = new LinkedList<>();
        grades.add("A");
        grades.add("B");
        grades.add("C");
        grades.add("D");
        grades.add("E");

        // Retrieves object from LinkedList using the ListIterator
        // interface.
        ListIterator li = grades.listIterator();
        while (li.hasNext()) {
            System.out.println("Grades: " + li.next());
            System.out.println("    hasPrevious  : " + li.hasPrevious());
            System.out.println("    hasNext      : " + li.hasNext());
            System.out.println("    previousIndex: " + li.previousIndex());
            System.out.println("    nextIndex    : " + li.nextIndex());
        }
    }
}
