
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * @(#)EstadisticaTexto.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/14
 */
public class EstadisticaTexto extends JFrame {

    private JTextArea areaTexto;
    private JCheckBox casillaLineas;
    private JCheckBox casillaPalabras;
    private JCheckBox casillaCaracteres;
    private JEditorPane panelEditor;

    public EstadisticaTexto() {
        JButton calcular = new JButton("Calcular");
        calcular.addActionListener(new OyenteCalcular());
        JButton limpiar = new JButton("<html>Limpiar área <br> de texto");
        limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                areaTexto.setText("");
                panelEditor.setText("");
            }
        });
        JPanel panel = new JPanel();
        panel.add(panelEleccion());
        panel.add(calcular);
        panel.add(limpiar);
        add(panel, BorderLayout.NORTH);
        add(panelTexto(), BorderLayout.CENTER);
        add(panelEditor(), BorderLayout.SOUTH);
    }

    private JScrollPane panelTexto() {
        areaTexto = new JTextArea(10, 50);
        JScrollPane panelScroll = new JScrollPane(areaTexto);
        panelScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TitledBorder titulo;
        titulo = BorderFactory.createTitledBorder("Texto a analizar");
        panelScroll.setBorder(titulo);
        return panelScroll;
    }

    private JPanel panelEleccion() {
        JPanel panel = new JPanel();
        casillaCaracteres = new JCheckBox("Caracteres", true);
        casillaPalabras = new JCheckBox("Palabras");
        casillaLineas = new JCheckBox("Lineas");
        panel.add(casillaCaracteres);
        panel.add(casillaPalabras);
        panel.add(casillaLineas);
        TitledBorder titulo;
        titulo = BorderFactory.createTitledBorder("Datos deseados");
        panel.setBorder(titulo);
        return panel;
    }

    private JEditorPane panelEditor() {
        panelEditor = new JEditorPane();
        panelEditor.setEditable(false);
        panelEditor.setContentType("text/html");
        panelEditor.setPreferredSize(new Dimension(200, 125));
        panelEditor.setMinimumSize(new Dimension(10, 10));
        TitledBorder titulo;
        titulo = BorderFactory.createTitledBorder("Resultados (texto html)");
        panelEditor.setBorder(titulo);
        return panelEditor;
    }

    private int calcularCaracteres(String cadena) {
        return cadena.length();
    }

    private int calcularPalabras(String cadena) {
        Scanner scaner = new Scanner(cadena);
        int palabras = 0;
        while (scaner.hasNext()) {
            scaner.next();
            palabras++;
        }
        return palabras;
    }

    private int calcularLineas(String cadena) {
        Scanner scaner = new Scanner(cadena);
        int lineas = 0;
        while (scaner.hasNextLine()) {
            scaner.nextLine();
            lineas++;
        }
        return lineas;
    }

    class OyenteCalcular implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            String texto = areaTexto.getText();
            StringBuffer resultado = new StringBuffer("<html>");
            if (casillaCaracteres.isSelected()) {
                resultado.append("<strong>Caracteres: </strong>");
                resultado.append("<em>" + calcularCaracteres(texto) + "</em> <br>");
            }
            if (casillaPalabras.isSelected()) {
                resultado.append("<strong>Pa1abras: </strong>");
                resultado.append("<em>" + calcularPalabras(texto) + "</em> <br>");
            }
            if (casillaLineas.isSelected()) {
                resultado.append("<strong>Líneas: </strong>");
                resultado.append("<em>" + calcularLineas(texto) + "</em> <br>");
            }
            panelEditor.setText(resultado.toString() + "</html>");
        }
    }

    public static void main(String args[]) {
        EstadisticaTexto aplicacion = new EstadisticaTexto();
        aplicacion.setTitle("Estadistica Texto");
        aplicacion.pack();
        aplicacion.setVisible(true);
    }
}
