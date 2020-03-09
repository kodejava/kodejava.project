package org.kodejava.example.commons.codec;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;

public class Base64Encode {
    public static void main(String[] args) {
        String hello = "Hello World";

        // The encodeBase64 method take a byte[] as the parameter. The byte[]
        // can be from a simple string like in this example or it can be from
        // an image file data.
        byte[] encoded = Base64.encodeBase64(hello.getBytes());

        // Print the encoded byte array
        System.out.println(Arrays.toString(encoded));

        // Print the encoded string
        String encodedString = new String(encoded);
        System.out.println(hello + " = " + encodedString);
    }
}
