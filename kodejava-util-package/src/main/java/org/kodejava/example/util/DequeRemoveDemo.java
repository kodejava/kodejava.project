package org.kodejava.example.util;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeRemoveDemo {
    public static void main(String[] args) {
        Deque<String> deque1 = new LinkedList<>();
        deque1.offer("a");
        deque1.offer("b");
        deque1.offer("c");
        deque1.offer("d");
        deque1.offer("e");
        deque1.offer("d");

        Deque<String> deque2 = new LinkedList<>(deque1);

        // Removes the first occurrence of letter "d" from deque1
        deque1.removeFirstOccurrence("d");

        Iterator first = deque1.iterator();
        System.out.println("After removeFirstOccurrence(Object o): ");
        System.out.println("=======================================");
        while (first.hasNext()) {
            System.out.println(first.next());
        }

        // Removes the last occurrence of letter "d" from deque2
        deque2.removeLastOccurrence("d");
        Iterator last = deque2.iterator();
        System.out.println("After removeLastOccurrence(Object o): ");
        System.out.println("========================================");
        while (last.hasNext()) {
            System.out.println(last.next());
        }
    }
}
