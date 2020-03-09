package org.kodejava.example.spring.inject;

public class DrawingBean {
    private String colour;
    private Shape shape;

    public DrawingBean() {
    }

    public void drawShape() {
        getShape().draw();
        System.out.printf("The colour is %s.", getColour());
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
