package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {
        // The source file name to be copied.
        File source = new File("january.doc");

        // The target file name to which the source file will be copied.
        File target = new File("january-backup.doc");

        // A temporary folder where we are gonna copy the source file to.
        // Here we use the temporary folder of the OS, which can be
        // obtained using java.io.tmpdir property.
        File targetDir = new File(System.getProperty("java.io.tmpdir"));

        try {
            // Using FileUtils.copyFile() method to copy a file.
            System.out.println("Copying " + source + " file to " + target);
            FileUtils.copyFile(source, target);

            // To copy a file to a specified folder we can use the
            // FileUtils.copyFileToDirectory() method.
            System.out.println("Copying " + source + " file to " + targetDir);
            FileUtils.copyFileToDirectory(source, targetDir);
        } catch (IOException e) {
            // Errors will be reported here if any error occurs during
            // copying the file
            e.printStackTrace();
        }
    }
}
