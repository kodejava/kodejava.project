package org.kodejava.example.lang;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = new String("Hello World");

        // This is good!
        if (s1.equals(s2)) {
            System.out.println("1. Both strings are equals.");
        } else {
            System.out.println("1. Both strings are not equals.");
        }

        // This is bad!
        if (s1 == s2) {
            System.out.println("2. Both strings are equals.");
        } else {
            System.out.println("2. Both strings are not equals.");
        }
    }
}
