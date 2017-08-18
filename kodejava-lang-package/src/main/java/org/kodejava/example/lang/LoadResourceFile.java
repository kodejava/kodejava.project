package org.kodejava.example.lang;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class LoadResourceFile {
    public static void main(String[] args) throws Exception {
        LoadResourceFile demo = new LoadResourceFile();
        demo.loadUsingClassMethod();
        demo.loadUsingClassLoaderMethod();
    }

    private void loadUsingClassMethod() throws IOException {
        System.out.println("LoadResourceFile.loadUsingClassMethod");
        Properties properties = new Properties();

        // Load resource relatively to the LoadResourceFile package.
        // This actually load resource from
        // "/org/kodejava/example/lang/database.conf".
        URL resource = getClass().getResource("database.conf");
        properties.load(new FileReader(new File(resource.getFile())));
        System.out.println("JDBC Driver: " + properties.get("jdbc.driver"));

        // Load resource using absolute name. This will read resource
        // from the root of the package. This will load "/database.conf".
        InputStream is = getClass().getResourceAsStream("/database.conf");
        properties.load(is);
        System.out.println("JDBC Driver: " + properties.get("jdbc.driver"));
    }

    private void loadUsingClassLoaderMethod() throws IOException {
        System.out.println("LoadResourceFile.loadUsingClassLoaderMethod");
        Properties properties = new Properties();

        // When using the ClassLoader method the resource name should
        // not started with "/". This method will not apply any
        // absolute/relative transformation to the resource name.
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("database.conf");
        properties.load(new FileReader(new File(resource.getFile())));
        System.out.println("JDBC URL: " + properties.get("jdbc.url"));

        InputStream is = classLoader.getResourceAsStream("database.conf");
        properties.load(is);
        System.out.println("JDBC URL: " + properties.get("jdbc.url"));
    }
}
