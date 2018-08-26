package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class DocumentFilterExample extends JFrame {
    public DocumentFilterExample() throws HeadlessException {
        initComponents();
    }

    protected void initComponents() {
        setSize(250, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField firstName = new JTextField();
        firstName.setPreferredSize(new Dimension(150, 20));
        JTextField lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(150, 20));

        DocumentFilter filter = new UppercaseDocumentFilter();
        AbstractDocument firstNameDoc = (AbstractDocument) firstName.getDocument();
        firstNameDoc.setDocumentFilter(filter);

        AbstractDocument lastNameDoc = (AbstractDocument) lastName.getDocument();
        lastNameDoc.setDocumentFilter(filter);

        getContentPane().add(new JLabel("First Name: "));
        getContentPane().add(firstName);
        getContentPane().add(new JLabel("Last Name: "));
        getContentPane().add(lastName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DocumentFilterExample().setVisible(true));
    }

    class UppercaseDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            fb.insertString(offset, text.toUpperCase(), attr);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            fb.replace(offset, length, text.toUpperCase(), attrs);
        }
    }
}
