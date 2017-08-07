package org.kodejava.example.lang;

public class StringReverseExample {
    public static void main(String[] args) {
        // The normal sentence that is going to be reversed.
        String words = "Morning of The World - The Last Paradise on Earth";

        // To reverse the string we can use the reverse() method in
        // the StringBuffer class. The reverse() method returns a
        // StringBuffer so we need to call the toString() method to
        // get a string object.
        String reverse = new StringBuffer(words).reverse().toString();

        // Print the normal string
        System.out.println("Normal : " + words);
        // Print the string in reversed order
        System.out.println("Reverse: " + reverse);
    }
}
