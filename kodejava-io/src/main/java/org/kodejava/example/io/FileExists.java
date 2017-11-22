package org.kodejava.example.io;

import java.io.File;
import java.io.FileNotFoundException;

public class FileExists {
    public static void main(String[] args) throws Exception {
        // Create an abstract definition of configuration file to be
        // read.
        File file = new File("applicationContext-hibernate.xml");

        // Print the exact location of the file in file system.
        System.out.println("File = " + file.getAbsolutePath());

        // If configuration file, applicationContext-hibernate.xml
        // does not exist in the current path throws an exception.
        if (!file.exists()) {
            String message = "Cannot find configuration file!";
            System.out.println(message);
            throw new FileNotFoundException(message);
        }

        // Continue with application logic here!
    }
}
