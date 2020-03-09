package org.kodejava.example.commons.io;

import static org.apache.commons.io.comparator.LastModifiedFileComparator.*;

import java.io.File;
import java.util.Arrays;

public class FileSortLastModified {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.home"));
        File[] files = dir.listFiles();

        if (files != null) {
            // Sort files in ascending order based on file's last
            // modification date.
            System.out.println("Ascending order.");
            Arrays.sort(files, LASTMODIFIED_COMPARATOR);
            FileSortLastModified.displayFileOrder(files);

            System.out.println("------------------------------------");

            // Sort files in descending order based on file's last
            // modification date.
            System.out.println("Descending order.");
            Arrays.sort(files, LASTMODIFIED_REVERSE);
            FileSortLastModified.displayFileOrder(files);
        }
    }

    private static void displayFileOrder(File[] files) {
        for (File file : files) {
            System.out.printf("%2$td/%2$tm/%2$tY - %s%n", file.getName(),
                file.lastModified());
        }
    }
}
