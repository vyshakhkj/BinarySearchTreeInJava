package net.vys.tree;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TreeGUI extends JFrame {

    private JPanel contentPane;
    public BinarySearchTree tree;
    public DrawTree drawer;

    public TreeGUI(BinarySearchTree tree) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        drawer = new DrawTree(tree);

        contentPane.add(drawer);
        setContentPane(contentPane);
        this.tree = tree;
        setVisible(true);
    }

}
