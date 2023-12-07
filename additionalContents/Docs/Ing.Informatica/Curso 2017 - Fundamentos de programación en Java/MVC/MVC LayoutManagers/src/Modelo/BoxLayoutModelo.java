package Modelo;

import java.awt.Button;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutModelo {

    private JFrame frame;

    public void BoxLayout1() {
        frame = new JFrame("BoxLayout Ejemplo");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(new JButton("Primero"));
        contentPane.add(new JButton("Segundo"));
        contentPane.add(new JButton("El Tercer botón es el más largo de todos"));
        contentPane.add(new JButton("Cuarto"));
        contentPane.add(new JButton("Quinto"));

        frame.pack();
        frame.setVisible(true);
    }

    // https://www.javatpoint.com/BoxLayout
    public void BoxLayout2() {
        frame = new JFrame();
        Container contentPane = frame.getContentPane();
        Button buttons[];
        buttons = new Button[5];

        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("Botón " + (i + 1));
            frame.add(buttons[i]);
        }

        frame.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void BoxLayout3() {
        frame = new JFrame();
        Container contentPane = frame.getContentPane();
        Button buttons[];
        buttons = new Button[5];

        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("Botón " + (i + 1));
            frame.add(buttons[i]);
        }

        frame.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
