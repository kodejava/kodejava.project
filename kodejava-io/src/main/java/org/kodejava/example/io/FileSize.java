package org.kodejava.example.io;

import java.io.File;

public class FileSize {
    public static void main(String[] args) throws Exception {
        File file = new File("README.md");

        // Get the size of a file in bytes.
        long fileSize = file.length();

        // Using Java printf() method to print the file size
        System.out.printf("File size: %,d bytes.%n", fileSize);
    }
}
