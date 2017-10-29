/*
 * $Id:$
 * ---------------------------------------------------------------------------------------------------------------------
 * Copyright (c) 2017 - PT Sigma Cipta Caraka. All rights reserved.
 * http://www.telkomsigma.co.id
 */
package org.kodejava.example;

import java.util.List;

/**
 * Canvas.
 *
 * @author Wayan Saryada
 * @version $Rev:$
 */
public class Canvas {
    public void draw(Shape s) {
        s.draw(this);
    }

    public void drawAll(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw(this);
        }
    }
}
