package org.kodejava.example.util;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // Constructs an empty array deque with an initial capacity
        // sufficient to hold the specified number of elements.
        Deque<Integer> deque = new ArrayDeque<>(5);
        deque.add(1);
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(5);
        deque.add(8);
        deque.add(14);
        deque.add(22);

        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }
    }
}
