/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

import java.util.*;

/**
 * Main.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());

        Canvas c = new Canvas();
        c.drawAll(shapes);

        Map<String, Driver> allDrivers = new HashMap<>();
        Census.addRegistry(allDrivers);
    }
    
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }
}
