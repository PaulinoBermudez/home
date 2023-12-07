
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @(#)BoxCardLayout.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/14
 */
public class BoxCardLayout extends JFrame {

    final static String BOXSIMPLE = "BoxLayout simple";
    final static String BOXCONGLUE = "BoxLayout con glue";
    final static String BOXCONSTRUT = "BoxLayout con strut";
    private CardLayout gestorTarjetas;
    private JPanel panelTarjetas;
    private JLabel etiqueta;

    public BoxCardLayout() {
        etiqueta = new JLabel(BOXSIMPLE);
        add(etiqueta, BorderLayout.NORTH);
        panelTarjetas = new JPanel();
        gestorTarjetas = new CardLayout();
        panelTarjetas.setLayout(gestorTarjetas);
        add(panelTarjetas, BorderLayout.CENTER);
        add(panelBotones(), BorderLayout.SOUTH);
        panelTarjetas.add(panelBox(), BOXSIMPLE);
        panelTarjetas.add(panelBoxConGlue(), BOXCONGLUE);
        panelTarjetas.add(panelBoxStrut(), BOXCONSTRUT);
        setTitle("Pruebas de BoxLayout y CardLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private JPanel panelBotones() {
        JPanel panel = new JPanel();
        OyenteBoton oyente = new OyenteBoton();
        JButton bs = new JButton(BOXSIMPLE);
        bs.addActionListener(oyente);
        panel.add(bs);
        JButton bg = new JButton(BOXCONGLUE);
        bg.addActionListener(oyente);
        panel.add(bg);
        JButton bstrut = new JButton(BOXCONSTRUT);
        bstrut.addActionListener(oyente);
        panel.add(bstrut);
        return panel;
    }

    private JPanel panelBoxConGlue() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JButton("Botón 1"));
        panel.add(Box.createGlue());
        panel.add(new JButton("Segundo Botón"));
        panel.add(Box.createGlue());
        panel.add(new JButton("3 Botón"));
        panel.add(Box.createGlue());
        panel.add(new JButton("Botón 4"));
        panel.add(Box.createGlue());
        panel.add(new JButton("Botón 5"));
        return panel;
    }

    private JPanel panelBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Segundo Botón"));
        panel.add(new JButton("3 Botón"));
        panel.add(new JButton("Botón 4"));
        panel.add(new JButton("Botón 5"));
        return panel;
    }

    private JPanel panelBoxStrut() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Segundo Botón"));
        panel.add(new JButton("3 Botón"));
        panel.add(Box.createHorizontalStrut(10));
        panel.add(new JButton("Botón 4"));
        panel.add(new JButton("Botón 5"));
        return panel;
    }

    class OyenteBoton implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            JButton boton = (JButton) evento.getSource();
            etiqueta.setText(boton.getText());
            gestorTarjetas.show(panelTarjetas, boton.getText());
        }
    }

    public static void main(String args[]) {
        BoxCardLayout ventana = new BoxCardLayout();
    }
}
