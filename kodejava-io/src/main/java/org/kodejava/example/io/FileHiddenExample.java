package org.kodejava.example.io;

import java.io.File;
import java.io.IOException;

public class FileHiddenExample {
    public static void main(String[] args) throws IOException {
        File file = new File("Hidden.txt");
        file.createNewFile();

        // We are using the isHidden() method to check whether a file
        // is hidden.
        if (file.isHidden()) {
            System.out.println("File is hidden!");
        } else {
            System.out.println("File is not hidden!");
        }
    }
}
