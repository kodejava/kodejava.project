package org.kodejava.example.io;

import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberReaderExample {
    public static void main(String[] args) throws Exception {
        // We'll read a file called student.csv that contains our
        // student information data.
        String filename = Thread.currentThread().getContextClassLoader()
            .getResource("student.csv").getFile();

        // To create the FileReader we can pass in our student data
        // file to the reader. Next we pass the reader into our
        // LineNumberReader class.
        try (FileReader fileReader = new FileReader(filename);
             LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {
            // If we set the line number of the LineNumberReader here
            // we'll got the line number start from the defined line
            // number + 1

            //lineNumberReader.setLineNumber(400);

            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                // We print out the student data and show what line
                // is currently read by our program.
                System.out.printf("Line Number %s: %s%n",
                    lineNumberReader.getLineNumber(), line);
            }
        }
    }
}
