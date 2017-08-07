package org.kodejava.example.lang;

public class TrimStringExample {
    public static void main(String[] args) {
        String text = "     tattarrattat     ";
        System.out.println("Original      = " + text);
        System.out.println("text.length() = " + text.length());

        // The trim() method will result a new string object with a leading and
        // trailing while space removed.
        text = text.trim();
        System.out.println("Result        = " + text);
        System.out.println("text.length() = " + text.length());
    }
}
