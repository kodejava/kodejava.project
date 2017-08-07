package org.kodejava.example.lang;

public class LeadingSpace {
    public static void main(String[] args) {
        String text = "     tattarrattat     ";
        System.out.println("Original      = " + text);
        System.out.println("text.length() = " + text.length());

        // Using regular expression to remove only the leading white
        // space in string
        text = text.replaceAll("^\\s+", "");
        System.out.println("Result        = " + text);
        System.out.println("text.length() = " + text.length());
    }
}
