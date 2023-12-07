package principal;

/*
 * Javier Abell�n. 27 de Abril de 2003
 *
 * main del juego del puzzle.
 */
import controlador.Ordenador;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import modelo.Puzzle;
import vista.GuiTableroBotones;

/**
 * Clase principal del juego del puzzle.
 * Es un JFrame en el que se instanciar� y ver� un GuiTableroBotones. Instancia
 * el Puzzle y el Ordenador. Elige las imagenes del puzzle.
 */
public class mainPuzzle extends JFrame{
    /**
     * Constructor.
     * Crea un array de string con los ficheros .gif que ser�n los dibujos de
     * las piezas del puzzle.
     * Crea un Puzzle, un Ordenador y un GuiTableroBotones.
     */
    public mainPuzzle() {
        int i;
        Image []iconos;
        
        /* A�ade el path completo a los ficheros de imagen */
        String path="E:\\Netbeans Proyectos\\Puzzle\\src\\imagenes\\";
  //      String path="c:\\windows\\puzzle\\";
 //       String path="c:\\windows\\profiles\\javier\\Mis Documentos\\puzzle\\GUI_Puzzle\\";
        for (i=0; i<imagenes.length; i++)
            imagenes[i] = path + imagenes[i];
        
        /* Se obtienen las Image de los ficheros */
        iconos = this.dameImagenes (imagenes);
        
        /* Crea el modelo del puzzle */
        puzzle = new Puzzle (3,3);
        
        /* Cree el control del puzzle, el Ordenador */
        ordenador = new Ordenador (puzzle);
        
        /* Al cerrar la ventana, nos salimos de la aplicaci�n */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        /* Crea la interface gr�fica del puzzle y la hace visible. */
        guiTableroBotones = new GuiTableroBotones (ordenador, iconos, puzzle);
        this.getContentPane().add(guiTableroBotones);
        this.pack();
        this.setVisible(true);
    }
        
    /**
     * Programa principal. Crea una instancia de mainPuzzle.
     */
    public static void main(String[] args) {
        new mainPuzzle();
    }
    
    /**
     * Carga los ficheros de imagen que se le pasan y los devuelve en un array
     * de Image.
     */
    private Image[] dameImagenes (String[] ficheros)
    {
        Image []imagenes;
        int i;
        
        imagenes = new Image[ficheros.length];
        
        for (i=0; i<imagenes.length; i++)
            imagenes[i] = (new ImageIcon(ficheros[i])).getImage();
        
        return imagenes;
    }
    
    /** El modelo del puzzle */
    Puzzle puzzle;
    
    /** La interface gr�fica del puzzle */
    GuiTableroBotones guiTableroBotones;
    
    /** La clase de control del puzzle */
    Ordenador ordenador;
    
    /** Los ficheros de imagen del puzzle */
    String [] imagenes = { 
        "hueco.gif", "uno.gif", "dos.gif", "tres.gif",
        "cuatro.gif", "cinco.gif", "seis.gif", "siete.gif", "ocho.gif"};    
}