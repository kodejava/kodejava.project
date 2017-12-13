package org.kodejava.example.io;

import java.io.File;

public class CreateDirs {
    public static void main(String[] args) {
        // Define a deep directory structures and create all the
        // directories at once.
        String directories = "D:/kodejava/a/b/c/d/e/f/g/h/i";
        File file = new File(directories);

        // The mkdirs will create folder including any necessary
        // but nonexistence parent directories. This method returns
        // true if and only if the directory was created along with
        // all necessary parent directories.
        boolean created = file.mkdirs();
        System.out.println("Directories created? " + created);
    }
}
