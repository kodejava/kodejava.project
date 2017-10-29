/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * RetConfig.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class RetConfig {
    public static String retConfig(String param) {
        Properties prop = new Properties();
        try (InputStream is = new FileInputStream("resources/config.properties")) {
            prop.load(is);
            System.out.println(prop.getProperty("url"));
            System.out.println(prop.getProperty("user"));
            System.out.println(prop.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(param);
    }

    public static void main(String[] args) {
        System.out.println(retConfig("url"));
    }
}
