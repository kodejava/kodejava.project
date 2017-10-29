/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * LocateFile.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class LocateFile {
    public static void main(String[] args) {
        File file = new File("../demo/google.html");
        System.out.println("file = " + file);
        System.out.println(System.getProperty("user.dir"));

        try {
            FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
