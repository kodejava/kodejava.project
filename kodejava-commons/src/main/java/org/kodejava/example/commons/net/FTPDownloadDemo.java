package org.kodejava.example.commons.net;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FTPDownloadDemo {
    public static void main(String[] args) {
        // The local filename and remote filename to be downloaded.
        String filename = "data.txt";

        FTPClient client = new FTPClient();
        try (OutputStream os = new FileOutputStream(filename)) {
            client.connect("ftp.example.org");
            client.login("admin", "admin123**");

            // Download file from FTP server.
            client.retrieveFile("/" + filename, os);
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
