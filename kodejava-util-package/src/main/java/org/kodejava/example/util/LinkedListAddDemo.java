package org.kodejava.example.util;

import java.util.LinkedList;

public class LinkedListAddDemo {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Mallory");

        System.out.println("Original values are:");
        System.out.println("====================");
        for (String name : names) {
            System.out.println("Name = " + name);
        }

        // Add a new item to the list at index number 2. Because
        // a list are 0 based index Carol will be inserted after
        // Bob.
        names.add(2, "Carol");

        System.out.println("New values are:");
        System.out.println("====================");
        for (String name : names) {
            System.out.println("Name = " + name);
        }
    }
}
