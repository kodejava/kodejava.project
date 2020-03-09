package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.Date;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        // Creates a Label object we are going to stored in the database.
        // We set the name, modified by and modified date information.
        Label newLabel = new Label();
        newLabel.setName("PolyGram");
        newLabel.setCreated(new Date());

        // Call the LabelManager saveLabel method.
        manager.saveLabel(newLabel);

        List<Label> labels = manager.getLabels();
        for (Label label : labels) {
            System.out.println("Label = " + label);
        }
    }
}
