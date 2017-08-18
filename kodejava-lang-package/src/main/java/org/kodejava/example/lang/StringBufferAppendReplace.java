package org.kodejava.example.lang;

public class StringBufferAppendReplace {
    public static void main(String[] args) {
        StringBuffer quote = new StringBuffer("an apple ");
        char a = 'a';
        String day = " day";
        StringBuffer sentences = new StringBuffer(" keep the doctor away");

        // Append a character into StringBuffer
        quote.append(a);
        System.out.println("quote = " + quote.toString());

        // Append a string into StringBuffer
        quote.append(day);
        System.out.println("quote = " + quote.toString());

        // Append another StringBuffer
        quote.append(sentences);
        System.out.println("quote = " + quote.toString());

        // Replace a sub string from StringBuffer starting
        // from index = 3 to index = 8
        quote.replace(3, 8, "orange");
        System.out.println("quote = " + quote.toString());
    }
}
