package org.kodejava.example.lang;

import java.io.File;

public class AppTerminate {
    public static void main(String[] args) {
        File file = new File("config.xml");

        int errCode = 0;
        if (!file.exists()) {
            errCode = 1;
        }

        // When the error code is not zero go terminate
        if (errCode > 0) {
            System.exit(errCode);
        }
    }
}
