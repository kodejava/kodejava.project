package org.kodejava.example.hibernate.app;

import org.kodejava.example.hibernate.model.Label;

import java.util.List;

public class LimitDemo {
    public static void main(String[] args) {
        LabelManager manager = new LabelManager();

        List<Label> labels = manager.getLabels(1, 10);
        for (Label label : labels) {
            System.out.println("Label = " + label);
        }
    }
}
