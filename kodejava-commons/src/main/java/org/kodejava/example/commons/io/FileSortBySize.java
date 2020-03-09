package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;

import static org.apache.commons.io.comparator.SizeFileComparator.*;

public class FileSortBySize {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles();

        if (files != null) {
            // Sort files in ascending order based on file size.
            System.out.println("Ascending order.");
            Arrays.sort(files, SIZE_COMPARATOR);
            FileSortBySize.displayFileOrder(files, false);

            // Sort files in descending order based on file size
            System.out.println("Descending order.");
            Arrays.sort(files, SIZE_REVERSE);
            FileSortBySize.displayFileOrder(files, false);

            // Sort files in ascending order based on file / directory
            // size
            System.out.println("Ascending order with directories.");
            Arrays.sort(files, SIZE_SUMDIR_COMPARATOR);
            FileSortBySize.displayFileOrder(files, true);

            // Sort files in descending order based on file / directory
            // size
            System.out.println("Descending order with directories.");
            Arrays.sort(files, SIZE_SUMDIR_REVERSE);
            FileSortBySize.displayFileOrder(files, true);
        }
    }

    private static void displayFileOrder(File[] files, boolean displayDirectory) {
        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%-25s - %s%n", file.getName(),
                        FileUtils.byteCountToDisplaySize(file.length()));
            } else if (displayDirectory) {
                long size = FileUtils.sizeOfDirectory(file);
                String friendlySize = FileUtils.byteCountToDisplaySize(size);
                System.out.printf("%-25s - %s%n", file.getName(),
                        friendlySize);
            }
        }
        System.out.println("------------------------------------");
    }
}
