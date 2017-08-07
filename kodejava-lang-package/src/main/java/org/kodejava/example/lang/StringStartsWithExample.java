package org.kodejava.example.lang;

public class StringStartsWithExample {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";

        // See if the fox is a quick fox.
        if (str.startsWith("The quick")) {
            System.out.println("Yes, the fox is the quick one");
        } else {
            System.out.println("The fox is a slow fox");
        }
    }
}
