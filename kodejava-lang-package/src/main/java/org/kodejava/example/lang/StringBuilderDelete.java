package org.kodejava.example.lang;

public class StringBuilderDelete {
    public static void main(String[] args) {
        StringBuilder lipsum = new StringBuilder("Lorem ipsum dolor sit " +
            "amet, consectetur adipisicing elit.");
        System.out.println("lipsum = " + lipsum.toString());

        // We'll remove a substring from this StringBuilder starting from
        // the first character to the 28th character.
        lipsum.delete(0, 28);
        System.out.println("lipsum = " + lipsum.toString());

        // Removes a char from the StringBuilder. In the example below we
        // remove the last character.
        lipsum.deleteCharAt(lipsum.length() - 1);
        System.out.println("lipsum = " + lipsum.toString());
    }
}
