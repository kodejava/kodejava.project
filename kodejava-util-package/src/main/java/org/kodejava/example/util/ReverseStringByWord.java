package org.kodejava.example.util;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseStringByWord {
    public static void main(String[] args) {
        // The string that we'll reverse
        String text = "Jackdaws love my big sphinx of quartz";

        // We use StringTokenize to get each word of the string. You might try
        // to use the String.split() method if you want.
        StringTokenizer st = new StringTokenizer(text, " ");

        // To reverse it we can use the Stack class, which implements the LIFO
        // (last-in-first-out).
        Stack<String> stack = new Stack<>();
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken());
        }

        // Print each word in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
