/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

/**
 * Circle.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class Circle extends Shape {
    private int x, y, radius;

    @Override
    public void draw(Canvas c) {
        System.out.println("Circle.draw");
    }
}
