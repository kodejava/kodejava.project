package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteDirectory {
    public static void main(String[] args) {
        try {
            File directory = new File("/home/foobar/Temp/Data");

            // Deletes a directory recursively. When deletion process is fail an
            // IOException is thrown and that's why we catch the exception.
            FileUtils.deleteDirectory(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
