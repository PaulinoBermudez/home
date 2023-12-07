
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Aplicacion grafica con una ventana que
 * tenga dos etiquetas y dos botones de operacion.
 * El comportamiento de la aplicadon debe reflejar en
 * el texto de las etiqueta el numero de veces que el
 * usuario ha hecho clic en cada uno de los botones.
 *
 */
public class BotonesEtiquetaOyenteExterno extends JFrame {

    private JLabel etiquetaUno;
    private JLabel etiquetaDos;
    private JButton botonUno;
    private JButton botonDos;
    private JPanel panel;

    public BotonesEtiquetaOyenteExterno() {
        etiquetaUno = new JLabel("Boton Uno: 0 veces");
        etiquetaDos = new JLabel("Boton Dos: 0 veces");
        botonUno = new JButton("Boton Uno");
        botonDos = new JButton("Boton Dos");
        panel = new JPanel();

        //Los componentes se presentan en el panel en el orden en que se agregan
        panel.add(etiquetaUno);
        panel.add(botonUno);
        panel.add(etiquetaDos);
        panel.add(botonDos);
        add(panel);

        //En este caso se crean dos objetos oyentes y 
        //se les pasa como parametro la etiqueta correspondiente
        OyenteExternoAccion oyenteBotonUno = new OyenteExternoAccion(etiquetaUno);
        OyenteExternoAccion oyenteBotonDos = new OyenteExternoAccion(etiquetaDos);

        //Se registran dos oyentes creando un objeto de la interfaz ActionListener.
        botonUno.addActionListener(oyenteBotonUno);
        botonDos.addActionListener(oyenteBotonDos);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana gestor de eventos");
        setSize(300, 100);
        //pack();
        setVisible(true);
    }

    
}// BotonesEtiquetasOyenteExterno
