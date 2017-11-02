package org.kodejava.example.util;

import java.util.LinkedList;

public class LinkedListRemove {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("Mallory");

        System.out.println("Original values are:");
        System.out.println("====================");
        for (String name : names) {
            System.out.println("Name = " + name);
        }

        // Remove Carol from the linked list.
        names.remove(2);

        System.out.println("New values are:");
        System.out.println("====================");
        for (String name : names) {
            System.out.println("Name = " + name);
        }
    }
}
