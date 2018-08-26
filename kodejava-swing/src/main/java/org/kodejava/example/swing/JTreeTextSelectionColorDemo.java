package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class JTreeTextSelectionColorDemo extends JFrame {
    public JTreeTextSelectionColorDemo() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI() {
        setSize(150, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Department");
        DefaultMutableTreeNode book = new DefaultMutableTreeNode("Books");
        DefaultMutableTreeNode fiction = new DefaultMutableTreeNode("Fictions");
        DefaultMutableTreeNode science = new DefaultMutableTreeNode("Sciences");
        DefaultMutableTreeNode text = new DefaultMutableTreeNode("Text Books");
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Children");

        root.add(book);
        book.add(fiction);
        book.add(science);
        book.add(text);
        book.add(children);

        JTree tree = new JTree(root);

        // Get the DefaultTreeCellRenderer instance of the JTree
        // component. Then we customize the color of the selection
        // node using blue background, white font color and black
        // border.
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        renderer.setTextSelectionColor(Color.white);
        renderer.setBackgroundSelectionColor(Color.blue);
        renderer.setBorderSelectionColor(Color.black);

        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(150, 300));

        getContentPane().add(pane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTreeTextSelectionColorDemo().setVisible(true);
            }
        });
    }
}
