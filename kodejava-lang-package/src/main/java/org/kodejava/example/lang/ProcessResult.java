package org.kodejava.example.lang;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessResult {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("ls -al");

            // Wait for this process to finish or terminated
            process.waitFor();

            // Get process exit value
            int exitValue = process.exitValue();
            System.out.println("exitValue = " + exitValue);

            // Read the result of the ls -al command by reading the
            // process's input stream
            InputStreamReader is = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(is);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
