/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

/**
 * Rectangle.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class Rectangle extends Shape {
    private int x, y, width, height;

    @Override
    public void draw(Canvas c) {
        System.out.println("Rectangle.draw");
    }
}
