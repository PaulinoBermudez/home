
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;

/**
 * @(#)ModeloCompartido.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/14
 */
public class ModeloCompartido extends JFrame {

    public ModeloCompartido() {
        JTextArea areaTexto1;
        JTextArea areaTexto2;
        Document documento;
        areaTexto1 = new JTextArea(10, 100);
        documento = areaTexto1.getDocument();
        areaTexto2 = new JTextArea(documento);
        areaTexto2.setColumns(100);
        areaTexto2.setRows(10);
        TitledBorder titulo1;
        titulo1 = BorderFactory.createTitledBorder("Area de texto l");
        areaTexto1.setBorder(titulo1);
        TitledBorder titulo2;
        titulo2 = BorderFactory.createTitledBorder("Area de texto 2");
        areaTexto2.setBorder(titulo2);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JScrollPane(areaTexto1));
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JScrollPane(areaTexto2));
        add(panel);
    }

    public static void main(String args[]) {
        ModeloCompartido aplicacion = new ModeloCompartido();
        aplicacion.setTitle("Prueba documento compartido");
        aplicacion.setSize(500, 300);
        aplicacion.setVisible(true);
    }
}
