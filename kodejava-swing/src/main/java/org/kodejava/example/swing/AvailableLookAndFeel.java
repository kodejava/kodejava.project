package org.kodejava.example.swing;

import javax.swing.*;

public class AvailableLookAndFeel {
    public static void main(String[] args) {
        UIManager.LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo lookAndFeel : lookAndFeels) {
            // Get the name of the look and feel
            String name = lookAndFeel.getName();
            System.out.println("Name      = " + name);

            // Get the implementation class for the look and feel
            String className = lookAndFeel.getClassName();
            System.out.println("ClassName = " + className);
        }
    }
}
