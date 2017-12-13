package org.kodejava.example.io;

import java.io.File;

public class EmptyDirCheck {
    public static void main(String[] args) {
        File file = new File("C:/Users/kodejava/Documents");

        // Check to see if the object represent a directory.
        if (file.isDirectory()) {
            // Get list of file in the directory. When its length is not zero
            // the folder is not empty.
            String[] files = file.list();

            if (files != null && files.length > 0) {
                System.out.println("The " + file.getPath() + " is not empty!");
            }
        }
    }
}
