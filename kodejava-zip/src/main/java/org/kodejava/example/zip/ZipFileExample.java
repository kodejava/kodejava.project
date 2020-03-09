package org.kodejava.example.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileExample {
    public static void main(String[] args) {
        try {
            // Create an instance of ZipFile to read a zip file
            // called sample.zip
            ZipFile zip = new ZipFile(new File("data.zip"));

            // Here we start to iterate each entries inside
            // sample.zip
            for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
                // Get ZipEntry which is a file or a directory
                ZipEntry entry = (ZipEntry) e.nextElement();

                // Get some information about the entry such as
                // file name, its size.
                System.out.println("File name: " + entry.getName()
                    + "; size: " + entry.getSize()
                    + "; compressed size: "
                    + entry.getCompressedSize());
                System.out.println();

                // Now we want to get the content of this entry.
                // Get the InputStream, we read through the input
                // stream until all the content is read.
                InputStream is = zip.getInputStream(entry);
                InputStreamReader isr = new InputStreamReader(is);

                char[] buffer = new char[1024];
                while (isr.read(buffer, 0, buffer.length) != -1) {
                    String s = new String(buffer);
                    // Here we just print out what is inside the
                    // buffer.
                    System.out.println(s.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
