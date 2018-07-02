package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ComboBoxCreate extends JFrame {
    public ComboBoxCreate() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label1 = new JLabel("Month  :");
        JLabel label2 = new JLabel("Number :");

        // Create some items for our JComboBox component. In this example we are
        // going to pass an array of string which are the name of the month.
        String[] months = {"January", "February", "March", "April", "Mei", "June",
            "July", "August", "September", "October", "November", "December"};

        // Create a month selection combo box.
        JComboBox<String> comboBox = new JComboBox<>(months);

        // Below, instead of passing directly a string array we create a ComboBoxModel
        // as the combo box data model. Using a model we can for example define the
        // selected item of the combo box.
        ComboBoxModel<String> model =
            new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5"});
        model.setSelectedItem("3");
        JComboBox<String> numberComboBox = new JComboBox<>(model);

        // We also set the combo box to be editable so that user can enter their own
        // value other that those defined in the combo box.
        numberComboBox.setEditable(true);

        // Add the entire component to out frame content pane.
        getContentPane().add(label1);
        getContentPane().add(comboBox);

        getContentPane().add(label2);
        getContentPane().add(numberComboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxCreate().setVisible(true);
            }
        });
    }
}
