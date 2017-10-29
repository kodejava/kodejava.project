package org.kodejava.example.util;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        // We stored some values in the stack object.
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.print(i + " ");
        }
        System.out.println("");

        // Searching for an item in the stack. The position returned
        // as the distance from the top of the stack. Here we search
        // for the 3 number in the stack which is in the 7th row of
        // the stack.
        int position = stack.search(3);
        System.out.println("Search result position: " + position);

        // The current top value of the stack
        System.out.println("Stack top: " + stack.peek());

        // Here we popping out all the stack object items.
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
