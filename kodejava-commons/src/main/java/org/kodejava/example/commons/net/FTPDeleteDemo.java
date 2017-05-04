package org.kodejava.example.commons.net;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class FTPDeleteDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();

        try {
            client.connect("ftp.example.org");
            client.login("admin", "admin123**");

            // Delete file on the FTP server. When the FTP delete
            // complete it returns true.
            String filename = "data.txt";
            boolean deleted = client.deleteFile(filename);
            if (deleted) {
                System.out.printf("File %s was deleted...", filename);
            } else {
                System.out.println("No file was deleted...");
            }

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
