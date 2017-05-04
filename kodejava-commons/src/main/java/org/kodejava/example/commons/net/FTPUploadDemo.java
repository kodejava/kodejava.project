package org.kodejava.example.commons.net;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;

public class FTPUploadDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        String filename = "data.txt";

        // Read the file from resources folder.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(filename)) {
            client.connect("ftp.example.org");
            client.login("admin", "admin123**");

            // Store file to server
            client.storeFile(filename, is);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
