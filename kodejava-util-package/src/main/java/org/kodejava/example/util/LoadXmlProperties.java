package org.kodejava.example.util;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadXmlProperties {
    public static void main(String[] args) {
        LoadXmlProperties lxp = new LoadXmlProperties();
        try {
            Properties properties = lxp.readProperties();

            //Display all properties information
            properties.list(System.out);

            // Read the value of data.folder and jdbc.url configuration
            String dataFolder = properties.getProperty("data.folder");
            System.out.println("data.folder = " + dataFolder);
            String jdbcUrl = properties.getProperty("jdbc.url");
            System.out.println("jdbc.url    = " + jdbcUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Properties readProperties() throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("configuration.xml");
        properties.loadFromXML(fis);

        return properties;
    }
}
