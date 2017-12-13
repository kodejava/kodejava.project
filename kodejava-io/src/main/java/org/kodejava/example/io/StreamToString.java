package org.kodejava.example.io;

import java.io.*;

public class StreamToString {

    public static void main(String[] args) throws Exception {
        StreamToString demo = new StreamToString();

        // Get input stream of our data file. This file can be in
        // the root of you application folder or inside a jar file
        // if the program is packed as a jar.
        InputStream is = demo.getClass().getResourceAsStream("/data.txt");

        // Call the method to convert the stream to string
        System.out.println(demo.convertStreamToString(is));
    }

    private String convertStreamToString(InputStream stream) throws IOException {
        // To convert the InputStream to String we use the
        // Reader.read(char[] buffer) method. We iterate until the
        // Reader return -1 which means there's no more data to
        // read. We use the StringWriter class to produce the string.
        if (stream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                stream.close();
            }
            return writer.toString();
        }
        return "";
    }
}
