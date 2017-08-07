package org.kodejava.example.lang;

import java.util.Date;

public class ObtainingPackageName {
    public static void main(String[] args) {
        // Create an instance of Date class, and then obtain the class package
        // name.
        Date date = new Date();
        Package pack = date.getClass().getPackage();
        String packageName = pack.getName();
        System.out.println("Package Name = " + packageName);

        // Create an instance of our class and again get its package name
        ObtainingPackageName o = new ObtainingPackageName();
        packageName = o.getClass().getPackage().getName();
        System.out.println("Package Name = " + packageName);
    }
}
