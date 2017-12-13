package org.kodejava.example.io;

import java.io.File;
import java.io.IOException;

public class FileRenameExample {
    public static void main(String[] args) throws IOException {
        // Creates a new file called OldHouses.csv
        File oldFile = new File("OldHouses.csv");
        boolean created = oldFile.createNewFile();
        System.out.println("File created? " + created);

        // Creates the target file.
        File newFile = new File("NewHouses.csv");

        // The renameTo() method renames file or directory to a
        // new name by passing the new destination file.
        boolean renamed = oldFile.renameTo(newFile);
        System.out.println("File renamed? " + renamed);
    }
}
