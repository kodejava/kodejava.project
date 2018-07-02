package org.kodejava.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // Creating a url object by specifying each parameter separately, including
            // the protocol, hostname, port number, and the page name
            URL url = new URL("https", "kodejava.org", 443, "/index.php");

            // We can also specify the address in a single line
            url = new URL("https://kodejava.org:443/index.php");

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
