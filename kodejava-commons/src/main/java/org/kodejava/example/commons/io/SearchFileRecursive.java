package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

public class SearchFileRecursive {
    public static void main(String[] args) {
        File root = new File("/Users/wayan/Dev");

        try {
            String[] extensions = {"xml", "java", "dat"};

            // Finds files within a root directory and optionally its
            // subdirectories which match an array of extensions. When the
            // extensions is null all files will be returned.
            //
            // This method will returns matched file as java.io.File
            Collection files = FileUtils.listFiles(root, extensions, true);

            for (Object o : files) {
                File file = (File) o;
                System.out.println("File = " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
