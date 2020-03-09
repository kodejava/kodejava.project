package org.kodejava.example.streams;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * ListHiddenFileExample.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class ListHiddenFileExample {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
