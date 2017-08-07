package org.kodejava.example.lang;

public class SubstringExample {
    public static void main(String[] args) {
        // This program demonstrate how we can take some part of a string
        // or the what we called as substring. Java String class provides
        // substring method with some overloaded parameter.
        String sentence = "The quick brown fox jumps over the lazy dog";

        // The first substring method with single parameter beginIndex 
        // will take some part of the string from the beginning index 
        // until the last character in the string.
        String part = sentence.substring(4);
        System.out.println("Part of sentence: " + part);

        // The second substring method take two parameters, beginIndex 
        // and endIndex. This method returns the substring start from 
        // beginIndex to the endIndex.
        part = sentence.substring(16, 30);
        System.out.println("Part of sentence: " + part);
    }
}
