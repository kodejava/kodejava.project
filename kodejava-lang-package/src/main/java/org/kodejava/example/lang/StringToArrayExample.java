package org.kodejava.example.lang;

public class StringToArrayExample {
    public static void main(String[] args) {
        // We have a string literal that contains the motto of this website.
        String literal = "Kode Java - Learn Java by Examples";

        // Now we want to convert or divided it into a small array of char.
        // To do this we can simply used String.toCharArray() method. This
        // method splits the string into an array of characters.
        char[] temp = literal.toCharArray();

        // Here we just iterate the char array and print it to our console.
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
        }
    }
}
