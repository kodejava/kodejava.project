package org.kodejava.example.io;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryContentExample {
    public static void main(String[] args) {
        File gamesDir = new File("D:/Games");

        // Get a list of file under the specified directory above
        // and return it as an abstract file object.
        File[] files = gamesDir.listFiles();

        if (files != null) {
            // Iterates the content of gamesDir directory, print
            // it and check it whether it was a directory or a
            // file.
            for (File file : files) {
                System.out.println(file + " is a "
                    + (file.isDirectory() ? "directory" : "file"));
            }
        }

        // Here we also get the list of file in the directory but
        // return it just as an array of String.
        String[] strings = gamesDir.list();
        if (strings != null) {
            for (String file : strings) {
                System.out.println("File = " + file);
            }
        }

        // Now we want to list the file in the directory but we
        // just want a file with a .doc extension. To do this we
        // first create a FilenameFilter which will be given to
        // the listFiles() method to filter the listing process.
        // The rule of filtering is implemented in the accept()
        // method of the FilenameFilter interface.
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".docx");
            }
        };

        // Give me just a .doc files in your directory.
        File[] docs = gamesDir.listFiles(filter);
        if (docs != null) {
            for (File doc : docs) {
                System.out.println("Doc file = " + doc);
            }
        }
    }
}
