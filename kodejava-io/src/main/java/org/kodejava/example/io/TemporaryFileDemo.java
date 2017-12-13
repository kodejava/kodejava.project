package org.kodejava.example.io;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TemporaryFileDemo {
    public static void main(String[] args) throws Exception {
        // Create a temporary file userlist.txt in the default platform
        // temporary folder / directory. We can get the platform temporary
        // folder using System.getProperty("java.io.tmpdir")
        File user = File.createTempFile("userlist", ".txt");

        // Delete the file when the virtual machine is terminated.
        user.deleteOnExit();

        // Create a temporary file data.txt in the user specified folder.
        File data = File.createTempFile("data", ".txt", new File("C:/Users/wsaryada/Data"));
        data.deleteOnExit();

        // Write data into temporary file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(data))) {
            writer.write("750101,2008-01-01,BLUE,CAR");
            writer.write("750102,2008-09-06,RED,CAR");
            writer.write("750103,2008-05-01,GREEN,CAR");
            writer.write("750104,2008-06-08,YELLOW,CAR");
        }
    }
}
