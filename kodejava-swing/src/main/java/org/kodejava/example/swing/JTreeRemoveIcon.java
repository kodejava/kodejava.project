package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class JTreeRemoveIcon extends JFrame {
    public JTreeRemoveIcon() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI() {
        setSize(200, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Address Book");
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        DefaultMutableTreeNode c = new DefaultMutableTreeNode("C");

        DefaultMutableTreeNode aContact = new DefaultMutableTreeNode("Alice");
        DefaultMutableTreeNode bContact = new DefaultMutableTreeNode("Bob");
        DefaultMutableTreeNode cContact = new DefaultMutableTreeNode("Carol");

        root.add(a);
        root.add(b);
        root.add(c);

        a.add(aContact);
        b.add(bContact);
        c.add(cContact);

        JTree tree = new JTree(root);

        // Remove default JTree icons
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setClosedIcon(null);
        renderer.setOpenIcon(null);

        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(200, 400));

        getContentPane().add(tree);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTreeRemoveIcon().setVisible(true);
            }
        });
    }
}
