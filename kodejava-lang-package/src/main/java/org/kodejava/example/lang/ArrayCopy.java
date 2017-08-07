package org.kodejava.example.lang;

public class ArrayCopy {
    public static void main(String[] args) {
        // Creates letters array with 5 chars inside it.
        String[] letters = {"A", "I", "U", "E", "O"};

        // Create an array to where we are going to copy
        // some elements of the previous array.
        String[] results = new String[3];

        // Copy 3 characters from letters starting from the
        // third element and put it inside result array
        // beginning at the first element
        System.arraycopy(letters, 2, results, 0, 3);

        // Just print out what were got copied, it will
        // contains U, E, and O
        for (String result : results) {
            System.out.println("result = " + result);
        }
    }
}
