package org.kodejava.example.lang;

public class CharArrayCopyExample {
    public static void main(String[] args) {
        char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        // Copy all value in the char array and create a new string out of it.
        String text = String.valueOf(data);
        System.out.println(text);

        // Copy a sub array from the char array and create a new string. The
        // following line will just copy 5 characters starting from array index
        // of three. When the element copied is out side of the array index an
        // IndexOutOfBoundsException will be thrown.
        text = String.copyValueOf(data, 3, 5);
        System.out.println(text);
    }
}
