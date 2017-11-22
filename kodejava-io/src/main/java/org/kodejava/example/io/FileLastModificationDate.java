package org.kodejava.example.io;

import java.io.File;
import java.util.Date;

public class FileLastModificationDate {
    public static void main(String[] args) {
        // Create an instance of file object.
        File file = new File("README.md");
        if (file.exists()) {
            // Get the last modification information.
            Long lastModified = file.lastModified();

            // Create a new date object and pass last modified
            // information to the date object.
            Date date = new Date(lastModified);

            // We know when the last time the file was modified.
            System.out.println(date);
        }
    }
}
