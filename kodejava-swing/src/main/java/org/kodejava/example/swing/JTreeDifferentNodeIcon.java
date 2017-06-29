package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class JTreeDifferentNodeIcon extends JFrame {
    public JTreeDifferentNodeIcon() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI() {
        setSize(200, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Countries");
        DefaultMutableTreeNode asia = new DefaultMutableTreeNode("Asia");
        Country[] countries = new Country[]{
            new Country("India", "/flags/in.png"),
            new Country("Singapore", "/flags/sg.png"),
            new Country("Indonesia", "/flags/id.png"),
            new Country("Vietnam", "/flags/vn.png"),
        };

        for (Country country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            asia.add(node);
        }

        DefaultMutableTreeNode northAmerica = new DefaultMutableTreeNode("North America");
        countries = new Country[]{
            new Country("United States", "/flags/us.png"),
            new Country("Canada", "/flags/ca.png")
        };

        for (Country country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            northAmerica.add(node);
        }

        DefaultMutableTreeNode southAmerica = new DefaultMutableTreeNode("South America");
        countries = new Country[]{
            new Country("Brazil", "/flags/br.png"),
            new Country("Argentina", "/flags/ar.png"),
            new Country("Uruguay", "/flags/uy.png")
        };
        for (Country country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            southAmerica.add(node);
        }

        DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");
        countries = new Country[]{
            new Country("United Kingdom", "/flags/gb.png"),
            new Country("Germany", "/flags/de.png"),
            new Country("Spain", "/flags/es.png"),
            new Country("France", "/flags/fr.png"),
            new Country("Italy", "/flags/it.png")
        };
        for (Country country : countries) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(country);
            europe.add(node);
        }

        root.add(asia);
        root.add(northAmerica);
        root.add(southAmerica);
        root.add(europe);

        final JTree tree = new JTree(root);
        tree.setCellRenderer(new CountryTreeCellRenderer());

        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(200, 400));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTreeDifferentNodeIcon().setVisible(true);
            }
        });
    }

    class CountryTreeCellRenderer implements TreeCellRenderer {
        private JLabel label;

        CountryTreeCellRenderer() {
            label = new JLabel();
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {
            Object o = ((DefaultMutableTreeNode) value).getUserObject();
            if (o instanceof Country) {
                Country country = (Country) o;
                URL imageUrl = getClass().getResource(country.getFlagIcon());
                if (imageUrl != null) {
                    label.setIcon(new ImageIcon(imageUrl));
                }
                label.setText(country.getName());
            } else {
                label.setIcon(null);
                label.setText("" + value);
            }
            return label;
        }
    }

    class Country {
        private String name;
        private String flagIcon;

        Country(String name, String flagIcon) {
            this.name = name;
            this.flagIcon = flagIcon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFlagIcon() {
            return flagIcon;
        }

        public void setFlagIcon(String flagIcon) {
            this.flagIcon = flagIcon;
        }
    }
}
