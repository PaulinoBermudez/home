package Modelo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutModelo {

    private JFrame frame;

    public void BorderLayout1() {
        System.out.println("BorderLayout1");
        frame = new JFrame("BorderLayout Ejemplo");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JButton("Norte"), BorderLayout.NORTH);
        contentPane.add(new JButton("Sur"), BorderLayout.SOUTH);
        contentPane.add(new JButton("UNED CURSO JAVA"), BorderLayout.CENTER);
        contentPane.add(new JButton("Oeste"), BorderLayout.WEST);
        contentPane.add(new JButton("Este"), BorderLayout.EAST);
        // El metodo pack() hace que la ventana coja el tamaño mas 
        // pequeño posible que permita ver todos los componentes.
        frame.pack();
        frame.setVisible(true);
    }// FIN BorderLayout1

    // https://www.javatpoint.com/java-layout-manager
    public void BorderLayout2() {
        System.out.println("BorderLayout2");
        frame = new JFrame();
        JButton b1 = new JButton("Norte");
        JButton b2 = new JButton("Sur");
        JButton b3 = new JButton("Este");
        JButton b4 = new JButton("Oeste");
        JButton b5 = new JButton("Centro");
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.SOUTH);
        frame.add(b3, BorderLayout.EAST);
        frame.add(b4, BorderLayout.WEST);
        frame.add(b5, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }// FIN BorderLayout2

    public void BorderLayout3() {
        System.out.println("BorderLayout3");
        frame = new JFrame("BorderLayout Ejemplo");
        int i = 0;
        frame.setLayout(new BorderLayout());
        frame.add("North", new Button("Button " + i++));
        frame.add("South", new Button("Button " + i++));
        frame.add("East", new Button("Button " + i++));
        frame.add("West", new Button("Button " + i++));
        frame.add("Center", new Button("Button " + i++));
        frame.setSize(300, 300);
        frame.setVisible(true);
    }// FIN BorderLayout3

}
