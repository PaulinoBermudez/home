package Modelo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GridLayoutModelo {

    private JFrame frame;

    public void GridLayout1() {
        frame = new JFrame("GridLayout Ejemplo");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 2));
        contentPane.add(new JButton("Primero"));
        contentPane.add(new JButton("Segundo"));
        contentPane.add(new JButton("El Tercero es muy largo"));
        contentPane.add(new JButton("Cuarto"));
        contentPane.add(new JButton("Quinto"));
        contentPane.add(new JButton("Sexto"));
        frame.pack();
        frame.setVisible(true);
    } // FIN GridLayout1

    // https://www.javatpoint.com/GridLayout
    public void GridLayout2() {
        frame = new JFrame();

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);

        frame.setLayout(new GridLayout(3, 3));

        frame.setSize(300, 300);
        frame.setVisible(true);
    }// FIN GridLayout2

    public void GridLayout3() {

        JPanel panelSuperior, panelInferior;
        JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btRT, btCE, btCL, btMas, btMenos, btMul, btDiv, btIgual, btMN, btPunto;
        JTextField pantalla;

        panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        pantalla = new JTextField(20);
        panelSuperior.add(pantalla);

        panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(5, 4, 8, 8));
        bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt3 = new JButton("3");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        bt0 = new JButton("0");
        btRT = new JButton("Rtc");
        btCE = new JButton("CE");
        btCL = new JButton("CL");
        btMas = new JButton("+");
        btMenos = new JButton("-");
        btMul = new JButton("x");
        btDiv = new JButton("/");
        btIgual = new JButton("=");
        btMN = new JButton("+/-");
        btPunto = new JButton(".");
        panelInferior.add(btRT);
        panelInferior.add(btCE);
        panelInferior.add(btCL);
        panelInferior.add(btMN);
        panelInferior.add(bt7);
        panelInferior.add(bt8);
        panelInferior.add(bt9);
        panelInferior.add(btDiv);
        panelInferior.add(bt4);
        panelInferior.add(bt5);
        panelInferior.add(bt6);
        panelInferior.add(btMul);
        panelInferior.add(bt1);
        panelInferior.add(bt2);
        panelInferior.add(bt3);
        panelInferior.add(btMenos);
        panelInferior.add(bt0);
        panelInferior.add(btPunto);
        panelInferior.add(btIgual);
        panelInferior.add(btMas);

        frame = new JFrame("Calculadora ");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panelSuperior);
        frame.add(panelInferior);
        frame.pack();
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
