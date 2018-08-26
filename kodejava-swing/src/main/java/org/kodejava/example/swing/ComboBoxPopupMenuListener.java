package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.*;

public class ComboBoxPopupMenuListener extends JFrame {
    public ComboBoxPopupMenuListener() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        Integer[] years = new Integer[] {2005, 2006, 2007, 2008, 2009, 2010};
        JComboBox<Integer> comboBox = new JComboBox<>(years);
        comboBox.setEditable(true);

        // Adds a PopupMenu listener which will listen to notification
        // messages from the popup portion of the combo box.
        comboBox.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                // This method is called before the popup menu becomes visible.
                System.out.println("PopupMenuWillBecomeVisible");
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // This method is called before the popup menu becomes invisible
                System.out.println("PopupMenuWillBecomeInvisible");
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
                // This method is called when the popup menu is canceled
                System.out.println("PopupMenuCanceled");
            }
        });

        getContentPane().add(comboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxPopupMenuListener().setVisible(true);
            }
        });
    }
}
