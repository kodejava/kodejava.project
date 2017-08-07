package org.kodejava.example.lang;

public class StringBuilderInsert {
    public static void main(String[] args) {
        StringBuilder alphabets = new StringBuilder("abcdfghopqrstuvwxyz");
        System.out.println("alphabets = " + alphabets);

        //  |a|b|c|d|f|g|h|i|....
        //  0|1|2|3|4|5|6|7|8|...
        //
        // From the above sequence you can see that the index of the string is
        // started from 0, so when we insert a string in the fourth offset it
        // means it will be inserted after the "d" letter. There are other overload
        // version of this method that can be used to insert other type of data
        // such as char, int, long, float, double, Object, etc.
        alphabets.insert(4, "e");
        System.out.println("alphabets = " + alphabets);

        // Here we insert an array of characters to the StringBuilder.
        alphabets.insert(8, new char[] {'i', 'j', 'k', 'l', 'm', 'n'});
        System.out.println("alphabets = " + alphabets);
    }
}
