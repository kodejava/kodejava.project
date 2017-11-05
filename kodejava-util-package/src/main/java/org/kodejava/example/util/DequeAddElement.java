package org.kodejava.example.util;

import java.util.Deque;
import java.util.LinkedList;

public class DequeAddElement {
    public static void main(String[] args) {
        // Create an instance of Deque using LinkedList class.
        Deque<String> deque = new LinkedList<>();

        // Insert a word into the Deque
        deque.add("jumps");

        // Insert words at the beginning of the current Deque
        // elements
        deque.addFirst("fox");
        deque.addFirst("brown");
        deque.addFirst("quick");
        deque.addFirst("The");

        // Insert words at the end of the current Deque elements
        deque.addLast("over");
        deque.addLast("the");
        deque.addLast("lazy");
        deque.addLast("dog");

        for (String word : deque) {
            System.out.println("word = " + word);
        }
    }
}
