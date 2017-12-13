package org.kodejava.example.io;

import java.io.FileInputStream;

public class HexDumpDemo {
    public static void main(String[] args) throws Exception {
        // Open the file using FileInputStream
        try (FileInputStream fis = new FileInputStream("C:/Users/wsaryada/data.txt")) {
            // A variable to hold a single byte of the file data
            int i = 0;

            // A counter to print a new line every 16 bytes read.
            int count = 0;

            // Read till the end of the file and print the byte in hexadecimal
            // valueS.
            while ((i = fis.read()) != -1) {
                System.out.printf("%02X ", i);
                count++;

                if (count == 16) {
                    System.out.println("");
                    count = 0;
                }
            }
        }
    }
}
