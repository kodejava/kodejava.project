package org.kodejava.example.util;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            // the configuration file name
            String fileName = "app.config";
            ClassLoader classLoader = PropertiesExample.class.getClassLoader();

            // Make sure that the configuration file exists
            URL res = Objects.requireNonNull(classLoader.getResource(fileName),
                "Can't find configuration file app.config");

            InputStream is = new FileInputStream(res.getFile());

            // load the properties file
            prop.load(is);

            // get the value for app.name key
            System.out.println(prop.getProperty("app.name"));
            // get the value for app.version key
            System.out.println(prop.getProperty("app.version"));

            // get the value for app.vendor key and if the
            // key is not available return Kode Java as
            // the default value
            System.out.println(prop.getProperty("app.vendor","Kode Java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
