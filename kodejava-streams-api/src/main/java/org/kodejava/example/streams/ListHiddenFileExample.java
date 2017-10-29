/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example.streams;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * ListHiddenFileExample.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class ListHiddenFileExample {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles(File::isHidden);

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
