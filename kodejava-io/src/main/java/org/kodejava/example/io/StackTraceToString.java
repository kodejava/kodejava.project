package org.kodejava.example.io;

import java.io.StringWriter;
import java.io.PrintWriter;

public class StackTraceToString {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            // Create a StringWriter and a PrintWriter both of these object
            // will be used to convert the data in the stack trace to a string.
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);

            // Instead of writing the stack trace in the console we write it
            // to the PrintWriter, to get the stack trace message we then call
            // the toString() method of StringWriter.
            e.printStackTrace(printWriter);

            System.out.println("Error = " + stringWriter.toString());
        }
    }
}
