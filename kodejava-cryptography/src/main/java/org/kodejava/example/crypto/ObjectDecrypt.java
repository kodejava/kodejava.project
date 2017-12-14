package org.kodejava.example.crypto;

import java.io.*;

import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;

public class ObjectDecrypt {
    public static void main(String[] args) throws Exception {
        // Read the previously stored SecretKey.
        SecretKey key = (SecretKey) readFromFile("secretkey.dat");

        // Read the SealedObject
        SealedObject sealedObject = (SealedObject) readFromFile("sealed.dat");

        // Preparing Cipher object from decryption.
        if (sealedObject != null) {
            String algorithmName = sealedObject.getAlgorithm();

            Cipher cipher = Cipher.getInstance(algorithmName);
            cipher.init(Cipher.DECRYPT_MODE, key);

            String text = (String) sealedObject.getObject(cipher);
            System.out.println("Text = " + text);
        }
    }

    // Method for reading object stored in a file.
    private static Object readFromFile(String filename) throws Exception {
        try (FileInputStream fis = new FileInputStream(new File(filename));
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
