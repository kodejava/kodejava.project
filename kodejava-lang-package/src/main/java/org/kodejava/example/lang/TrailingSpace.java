package org.kodejava.example.lang;

public class TrailingSpace {
    public static void main(String[] args) {
        String text = "     tattarrattat     ";
        System.out.println("Original      = " + text);
        System.out.println("text.length() = " + text.length());

        // Using a regular expression to remove only the trailing white space in
        // a string
        text = text.replaceAll("\\s+$", "");
        System.out.println("Result        = " + text);
        System.out.println("text.length() = " + text.length());
    }
}
