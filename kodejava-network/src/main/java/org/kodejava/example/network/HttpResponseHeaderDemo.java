package org.kodejava.example.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpResponseHeaderDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://kodejava.org/index.php");
            URLConnection connection = url.openConnection();

            Map<String, List<String>> responseMap = connection.getHeaderFields();
            for (String key : responseMap.keySet()) {
                System.out.print(key + " = ");

                List<String> values = responseMap.get(key);
                for (String value : values) {
                    System.out.print(value + ", ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
