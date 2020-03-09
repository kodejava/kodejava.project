package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.Date;

public class DeleteDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        // Creates a Label object we are going to stored in the database.
        // We set the name and created date information.
        Label label = new Label();
        label.setName("Sony Music");
        label.setCreated(new Date());

        // Call the LabelManager saveLabel method.
        manager.saveLabel(label);

        // Read the object back from database.
        label = manager.getLabel(label.getId());
        System.out.println("Label = " + label);

        manager.deleteLabel(label.getId());
    }
}
