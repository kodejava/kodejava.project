package org.kodejava.example.lang;

public class VarargsToArray {
    public static void main(String[] args) {
        printMessage("Hello ", "there", ", ", "how ", "are ", "you", "?");
    }

    public static void printMessage(String... messages) {
        String[] copiedMessage = messages;
        for (int i = 0; i < messages.length; i++) {
            System.out.print(copiedMessage[i]);
        }
    }
}
