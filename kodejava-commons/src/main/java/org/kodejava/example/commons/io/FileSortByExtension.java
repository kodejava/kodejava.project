package org.kodejava.example.commons.io;

import org.apache.commons.io.FilenameUtils;
import static org.apache.commons.io.comparator.ExtensionFileComparator.*;

import java.io.File;
import java.util.Arrays;

public class FileSortByExtension {
    public static void main(String[] args) {
        File file = new File(".");

        // Excludes directory in the list
        File[] files = file.listFiles(File::isFile);

        if (files != null) {
            // Sort in ascending order.
            Arrays.sort(files, EXTENSION_COMPARATOR);
            FileSortByExtension.displayFileOrder(files);

            // Sort in descending order.
            Arrays.sort(files, EXTENSION_REVERSE);
            FileSortByExtension.displayFileOrder(files);
        }
    }

    private static void displayFileOrder(File[] files) {
        System.out.printf("%-20s | %s%n", "Name", "Ext");
        System.out.println("--------------------------------");
        for (File file : files) {
            System.out.printf("%-20s | %s%n", file.getName(),
                    FilenameUtils.getExtension(file.getName()));
        }
        System.out.println();
    }
}
