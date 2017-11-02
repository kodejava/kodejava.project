package org.kodejava.example.util;

import java.util.LinkedList;

public class LinkedListGetFirstLast {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("Mallory");

        // Get the first and the last element of the linked list
        String first = names.getFirst();
        String last = names.getLast();

        System.out.println("First member = " + first);
        System.out.println("Last member  = " + last);
    }
}
