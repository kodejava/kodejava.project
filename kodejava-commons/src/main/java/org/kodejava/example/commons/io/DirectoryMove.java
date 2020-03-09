package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DirectoryMove {
    public static void main(String[] args) {
        String source = "C:/Demo/source";
        File srcDir = new File(source);

        String destination = "C:/Demo/target";
        File destDir = new File(destination);

        try {
            // Move the source directory to the destination directory.
            // The destination directory must not exists prior to the
            // move process.
            FileUtils.moveDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
