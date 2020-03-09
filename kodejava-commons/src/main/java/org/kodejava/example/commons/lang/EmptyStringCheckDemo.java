package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.StringUtils;

public class EmptyStringCheckDemo {
    public static void main(String[] args) {
        // Create some variable to hold some string that empty, contains only
        // white spaces and words.
        String one = "";
        String two = "\t\r\n";
        String three = "     ";
        String four = null;
        String five = "four four two";

        // We can use StringUtils class for checking if a string is empty or not
        // using StringUtils.isBlank() method. This method will return true if
        // the tested string is empty, contains white space only or null.
        System.out.println("Is one empty? " + StringUtils.isBlank(one));
        System.out.println("Is two empty? " + StringUtils.isBlank(two));
        System.out.println("Is three empty? " + StringUtils.isBlank(three));
        System.out.println("Is four empty? " + StringUtils.isBlank(four));
        System.out.println("Is five empty? " + StringUtils.isBlank(five));

        // On the other side, the StringUtils.isNotBlank() methods complement
        // the previous method. It will check is a tested string is not empty.
        System.out.println("Is one not empty? " + StringUtils.isNotBlank(one));
        System.out.println("Is two not empty? " + StringUtils.isNotBlank(two));
        System.out.println("Is three not empty? " + StringUtils.isNotBlank(three));
        System.out.println("Is four not empty? " + StringUtils.isNotBlank(four));
        System.out.println("Is five not empty? " + StringUtils.isNotBlank(five));
    }
}
