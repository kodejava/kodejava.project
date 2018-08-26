package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.text.DateFormatSymbols;

public class JTreeDemo extends JFrame {
    public JTreeDemo() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(200, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Creating tree node of day names.
        DefaultMutableTreeNode day = new DefaultMutableTreeNode("Days");
        DefaultMutableTreeNode sun = new DefaultMutableTreeNode("Sunday");
        DefaultMutableTreeNode mon = new DefaultMutableTreeNode("Monday");
        DefaultMutableTreeNode tue = new DefaultMutableTreeNode("Tuesday");
        DefaultMutableTreeNode wed = new DefaultMutableTreeNode("Wednesday");
        DefaultMutableTreeNode thu = new DefaultMutableTreeNode("Thursday");
        DefaultMutableTreeNode fri = new DefaultMutableTreeNode("Friday");
        DefaultMutableTreeNode sat = new DefaultMutableTreeNode("Saturday");

        // Adding the days node into day tree node.
        day.add(sun);
        day.add(mon);
        day.add(tue);
        day.add(wed);
        day.add(thu);
        day.add(fri);
        day.add(sat);

        // Creates tree node of month names using a for loop where the
        // month names is obtained using the DateFormatSymbols class.
        DefaultMutableTreeNode month = new DefaultMutableTreeNode("Months");
        String[] months = DateFormatSymbols.getInstance().getMonths();
        for (String monthName : months) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(monthName);
            month.add(node);
        }

        // Creating a root node for our JTree and add day and month items
        // to the tree.
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        root.add(day);
        root.add(month);

        // Creating an instance of JTree using the instance of
        // DefaultMutableTreeNode. We also create a scroll pane for our
        // tree container.
        JTree tree = new JTree(root);
        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(150, 300));
        getContentPane().add(pane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTreeDemo().setVisible(true);
            }
        });
    }
}
