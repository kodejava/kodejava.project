package org.kodejava.example.io;

import java.io.File;

public class FileDeleteExample {
    public static void main(String[] args) {
        // When want to delete a file named readme.txt
        File file = new File("write.txt");

        // Checks if the file is exists before deletion.
        if (file.exists()) {
            System.out.println("Deleting " + file.getAbsolutePath());
            // Use the delete method to delete the given file.
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println(file.getAbsolutePath() + " was deleted.");
            }
        } else {
            System.out.println(file.getAbsolutePath() + " not found.");
        }
    }
}
