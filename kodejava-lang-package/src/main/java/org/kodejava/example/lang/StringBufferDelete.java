package org.kodejava.example.lang;

public class StringBufferDelete {
    public static void main(String[] args) {
        String text = "Learn Java by Examples";

        // Creates a new instance of StringBuffer and initialize
        // it with some text.
        StringBuffer sb = new StringBuffer(text);
        System.out.println("Original text  = " + sb.toString());

        // We'll remove a sub string from this StringBuffer starting
        // from the first character to the 10th character.
        sb.delete(0, 10);
        System.out.println("After deletion = " + sb.toString());

        // Removes a char at a specified index from the StringBuffer.
        // In the example below we remove the last character.
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("Final result   = " + sb.toString());
    }
}
