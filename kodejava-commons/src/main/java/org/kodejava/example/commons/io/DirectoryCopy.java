package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DirectoryCopy {
    public static void main(String[] args) {
        // An existing directory to copy.
        String source = "C:/Demo/source";
        File srcDir = new File(source);

        // The destination directory to copy to. This directory
        // doesn't exists and will be created during the copy
        // directory process.
        String destination = "C:/Demo/target";
        File destDir = new File(destination);

        try {
            // Copy source directory into destination directory
            // including its child directories and files. When
            // the destination directory is not exists it will
            // be created. This copy process also preserve the
            // date information of the file.
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
