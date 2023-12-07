/**
 * @(#)Text8.java
 *
 *
 * @author 
 * @version 1.00 2014/4/15
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GlueSample {
  public static void main(String args[]) {
    Box horizontalBox;
    JPanel panel;
    JFrame frame = new JFrame("Horizontal Glue");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new GridLayout(0, 1));

    horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(Box.createGlue());
    horizontalBox.add(new JButton("Left"));
    horizontalBox.add(new JButton("Middle"));
    horizontalBox.add(new JButton("Right"));
    panel = new JPanel(new BorderLayout());
    panel.add(horizontalBox);
    panel.setBorder(BorderFactory.createTitledBorder("Beginning Glue"));
    contentPane.add(panel);

    horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new JButton("Left"));
    horizontalBox.add(Box.createGlue());
    horizontalBox.add(new JButton("Middle"));
    horizontalBox.add(Box.createGlue());
    horizontalBox.add(new JButton("Right"));
    panel = new JPanel(new BorderLayout());
    panel.add(horizontalBox);
    panel.setBorder(BorderFactory.createTitledBorder("2 Middle Glues"));
    contentPane.add(panel);

    horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(Box.createGlue());
    horizontalBox.add(new JButton("Left"));
    horizontalBox.add(new JButton("Middle"));
    horizontalBox.add(new JButton("Right"));
    horizontalBox.add(Box.createGlue());
    panel = new JPanel(new BorderLayout());
    panel.add(horizontalBox);
    panel
        .setBorder(BorderFactory
            .createTitledBorder("Beginning/End Glues"));
    contentPane.add(panel);

    horizontalBox = Box.createHorizontalBox();
    horizontalBox.add(new JButton("Left"));
    horizontalBox.add(new JButton("Middle"));
    horizontalBox.add(new JButton("Right"));
    panel = new JPanel(new BorderLayout());
    horizontalBox.add(Box.createGlue());
    panel.add(horizontalBox);
    panel.setBorder(BorderFactory.createTitledBorder("End Glue"));
    contentPane.add(panel);

    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}