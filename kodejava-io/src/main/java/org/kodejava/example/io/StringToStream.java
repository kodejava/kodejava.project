package org.kodejava.example.io;

import java.io.*;

public class StringToStream {
    public static void main(String[] args) {
        String text = "Converting String to InputStream Example";

        // Convert String to InputStream using ByteArrayInputStream
        // class. This class constructor takes the string byte array
        // which can be done by calling the getBytes() method.
        try {
            InputStream stream = new ByteArrayInputStream(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
