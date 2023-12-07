package vista;

/*
 * Javier Abell�n. 27 de Abril de 2003
 * 
 * Juego del puzzle. Clase GuiTablero, que es un Canvas en el que se pintan
 * las piezas. Hace las veces de tablero visual.
 */
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import modelo.ObservadorMovimiento;
import modelo.Puzzle;

/**
 * Tablero visual para el puzzle.
 * Dibuja las piezas del puzzle y recoge los eventos de rat�n al pincharlas con
 * el rat�n.
 * Utiliza la clase Puzzle, que es la que tiene el juego, para saber d�nde
 * dibujar las piezas en pantalla.
 */
public class GuiTablero extends Canvas
{
    public GuiTablero (Image [] imagenes, Puzzle unPuzzle)
    {
        /* Se guarda el puzzle */
        this.puzzle = unPuzzle;
        
        /* Se guarda las imagenes */
        this.iconos = imagenes;
        
        /* A�ade un observador de movimientos a Puzzle, de forma que cada vez
         * que se mueva una pieza en Puzzle, esta clase se entera y llama al
         * repintado de pantalla */
        puzzle.anhadeObservador (new ObservadorMovimiento() {
            public void tomaMovimiento (int filaVieja, int columnaVieja,
                int filaNueva, int columnaNueva)
            {
                repaint();
            }
            public void ordenado()
            {
            }
        });
        
        /* A�ade un MouseListener para enterarse de cuando se hace click en
         * una pieza del puzzle. Cuando pasa esto, se llama a mueve() */
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {
                mueve (e.getX(), e.getY());
            }
        });
        
    }

    /**
     * Mueve la pieza del puzzle que contiene las coordenadas x,y del tablero
     * en pantalla.
     * Recibe la posici�n x,y en la que se ha pinchado con el rat�n, la traduce
     * a una fila, columna del tablero y llama a Puzzle.mueve().
     */
    public void mueve (int x, int y)
    {
        int fila,columna;
        
        /* Traducci�n de pixel x,y a fila,columna del tablero */
        fila = y/32;
        columna = x/32;
        
        /* Se mueve la pieza del puzzle en fila,columna al hueco */
        if (puzzle != null)
            puzzle.mueve (fila, columna);
    }
    
    /**
     * Devuelve el tama�o preferido para el tablero en pixels.
     * Se le pide a Puzzle el n�mero de filas y columnas. Como cada imagen
     * se supone que ocupa 32x32, se obtiene f�cilmente el ancho y alto 
     * deseado para el dibujo del tablero.
     */
    public Dimension getPreferredSize()
    {
        dimension.setSize(
            puzzle.dameColumnas()*32, 
            puzzle.dameFilas()*32);
        
        return dimension;
    }
    
    /**
     * Redibuja el tablero, llamando al m�todo paint().
     */
    public void update(Graphics g)
    {
        paint(g);
    }

    /**
     * Dibuja el tablero con las piezas.
     * Pregunta a Puzzle por la pieza en cada fila,columna y dibuja en pantalla
     * la imagen adecuada.
     */
    public void paint (Graphics g)
    {
        int fila, columna;
        int pieza;
        
        /* Bucle anidado para cada fila y columna */
        for (fila=0; fila < puzzle.dameFilas(); fila++)
            for (columna=0; columna < puzzle.dameColumnas(); columna++)
            {
                /* Se recoge el n�mero de la pieza en fila,columna */
                pieza = puzzle.damePieza (fila, columna);
                
                /* Se dibuja la imagen correspondiente */
                g.drawImage (iconos[pieza], columna*32, fila*32, 32, 32, this);
            }
    }
    
    
    /**
     * Puzzle en el que se desarrolla el juego
     */
    Puzzle puzzle = null;
    
    /**
     * Array de imagenes para dibujar las piezas
     */
    Image [] iconos;
    
    /**
     * Dimensi�n preferida para el tablero en pixels de pantalla.
     */
    Dimension dimension = new Dimension();
}
