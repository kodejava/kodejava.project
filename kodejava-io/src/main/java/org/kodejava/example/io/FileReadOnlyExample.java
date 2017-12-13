package org.kodejava.example.io;

import java.io.File;

public class FileReadOnlyExample {
    public static void main(String[] args) throws Exception {
        File file = new File("ReadOnly.txt");

        // Create a file only if it doesn't exist.
        boolean created = file.createNewFile();

        // Set file attribute to read only so that it cannot be written
        boolean succeeded = file.setReadOnly();

        // We are using the canWrite() method to check whether we can
        // modified file content.
        if (file.canWrite()) {
            System.out.println("File is writable!");
        } else {
            System.out.println("File is in read only mode!");
        }
    }
}
