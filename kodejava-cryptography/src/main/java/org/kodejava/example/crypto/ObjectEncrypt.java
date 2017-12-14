package org.kodejava.example.crypto;

import java.io.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class ObjectEncrypt {
    public static void main(String[] args) throws Exception {
        // Generating a temporary key and store it in a file.
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        writeToFile("secretkey.dat", key);

        // Preparing Cipher object for encryption.
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Here we seal (encrypt) a simple string message (a string object).
        SealedObject sealedObject = new SealedObject("THIS IS A SECRET MESSAGE!", cipher);

        // Write the object out as a binary file.
        writeToFile("sealed.dat", sealedObject);
    }

    // Store object in a file for future use.
    private static void writeToFile(String filename, Object object) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(new File(filename));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(object);
        }
    }
}
