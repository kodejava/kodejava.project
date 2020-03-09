package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

public class LoadDemo {
    public static void main(String[] args) {
        // Create an instance of LabelManager.
        LabelManager manager = new LabelManager();

        // We call the getLabel() method an pass the label id to load it
        // from the database and print out the label string.
        Label label = manager.getLabel(1L);
        System.out.println("label = " + label);
    }
}
