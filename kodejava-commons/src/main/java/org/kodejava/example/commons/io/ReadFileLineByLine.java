package org.kodejava.example.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class ReadFileLineByLine {
    public static void main(String[] args) throws Exception {
        // Load file from resource directory.
        ClassLoader classLoader = ReadFileLineByLine.class.getClassLoader();
        URL url = Objects.requireNonNull(classLoader.getResource("data.txt"),
                "Resource could not be found.");

        File file = new File(url.getFile());
        try (LineIterator iterator = FileUtils.lineIterator(file, "UTF-8")) {
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                System.out.println("line = " + line);
            }
        }
    }
}
