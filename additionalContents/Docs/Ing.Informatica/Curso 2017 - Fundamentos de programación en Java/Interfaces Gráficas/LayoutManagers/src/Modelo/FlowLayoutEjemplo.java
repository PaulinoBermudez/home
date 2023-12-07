package Modelo;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEjemplo {

    private JFrame frame;

    public void FlowLayout1() {
        frame = new JFrame("FlowLayout Ejemplo");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("Primero"));
        contentPane.add(new JButton("Segundo"));
        contentPane.add(new JButton("El Tercero es muy largo"));
        contentPane.add(new JButton("Cuarto"));
        contentPane.add(new JButton("Quinto"));
        frame.pack();
        frame.setVisible(true);
    }

    // https://www.javatpoint.com/FlowLayout
    public void FlowLayout2() {
        frame = new JFrame();

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
