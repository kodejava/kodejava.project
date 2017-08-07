package org.kodejava.example.lang;

public class StringContainsExample {
    public static void main(String[] args) {
        String haystack = "Kodejava - Learn Java by Examples";

        // Checks to see if the word "Java" is found in the haystack
        // variable.
        String needle = "Java";
        if (haystack.indexOf(needle) != -1) {
            System.out.println("Found the word " + needle +
                " at index number " + haystack.indexOf(needle));
        } else {
            System.out.println("Can't find " + needle);
        }

        // Or use the String.contains() method if you are not interested
        // with the index of the word.
        if (haystack.contains(needle)) {
            System.out.println("Eureka we've found Java!");
        }
    }
}
