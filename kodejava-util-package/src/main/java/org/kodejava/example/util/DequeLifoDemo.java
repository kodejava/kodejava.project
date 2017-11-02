package org.kodejava.example.util;

import java.util.Deque;
import java.util.LinkedList;

public class DequeLifoDemo {

    public static void main(String[] args) {
        // Create an instance of a Deque, here we use the LinkedList
        // class which implements the Deque interface.
        Deque<String> deque = new LinkedList<>();
        deque.add("one");
        deque.add("two");
        deque.add("three");
        deque.add("four");

        StringBuilder in = new StringBuilder("Items IN in order : ");

        // Returns an iterator over the elements in this deque in
        // proper sequence
        for (String s : deque) {
            in.append(s).append(",");
        }

        in.deleteCharAt(in.length() - 1);
        System.out.println(in.toString());

        StringBuilder out = new StringBuilder("Items OUT in order: ");
        for (int i = 0; i < deque.size();) {
            out.append(deque.peekLast()).append(",");

            // Retrieves and removes the last element of this deque,
            // or returns null if this deque is empty.
            deque.pollLast();
        }

        out.deleteCharAt(out.length() - 1);
        System.out.println(out.toString());
    }
}
