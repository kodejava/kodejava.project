package org.kodejava.example.io;

import java.io.File;

public class AbsolutePathExample {
    public static void main(String[] args) {
        // Create an instance of File called file.
        File file = new File("README.md");

        // Now we want to know where is exactly this file is
        // located in our file system. To do this we can use
        // the getAbsolutePath() method of the File class.
        String absolutePath = file.getAbsolutePath();

        // Print out the JavaProgrammingBook.pdf location to
        // the console.
        System.out.println("AbsolutePath = " + absolutePath);
    }
}
