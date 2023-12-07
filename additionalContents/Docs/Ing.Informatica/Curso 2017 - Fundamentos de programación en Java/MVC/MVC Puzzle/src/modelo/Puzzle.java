package modelo;

/**
 * Javier Abell�n. 25 de Abril de 2003
 *
 * Juego del puzzle en el que hay varias piezas y un hueco.
 */

import java.util.LinkedList;
import java.awt.Point;

/**
 * Juego del puzzle. Mantiene el tablero y permite mover las piezas si el
 * movimiento es correcto.
 * Las piezas van de 1 en adelante. El hueco es el 0.
 */
public class Puzzle {
    public Puzzle (int numeroFilas, int numeroColumnas)
    {
        int i, j;
        int contador = 1;
        
        /* Se comprueban los par�metros de entrada */
        if (numeroFilas > 0)
            this.numeroFilas = numeroFilas;
              
        if (numeroColumnas > 0)
            this.numeroColumnas = numeroColumnas;
        
        /* Se crea el array que representa el tablero */
        tablero = new int [numeroFilas][numeroColumnas];
        
        /* Se ponen las piezas en la posici�n inicial */
        for (i=0; i<numeroFilas; i++)
            for (j=0; j<numeroColumnas; j++)
            {
                tablero [i][j] = contador;
                contador++;
            }
        
        /* Se situa el hueco en la posici�n inicial */
        tablero [numeroFilas -1][numeroColumnas -1] = HUECO;
        this.filaHueco = numeroFilas -1;
        this.columnaHueco = numeroColumnas -1;
    }
        
    /**
     * Mueve la pieza en fila,columna al hueco. Devuelve true si se ha podido
     * efectuar el movimiento. false si esa pieza no se puede mover porque no
     * tiene el hueco al lado o porque se da una fila,columna fuera del 
     * tablero.
     */
    public boolean mueve (int fila, int columna)
    {
        /* Se comprueba que las coordenadas caen dentro del tablero */
        if (!compruebaCoordenadas(fila, columna))
            return false;
        
        /* Si no es la primera fila, se mira a ver si el hueco est� encima
         * de la pieza */
        if (fila != 0)
            if (tablero[fila-1][columna] == HUECO)
            {
                /* Se hace el movimiento de la pieza a la fila superior */
                mueve (fila, columna, fila-1, columna);
                return true;
            }

        /* Si la fila no es la �litma, se mira a ver si el hueco est� en la
         * fila de abajo de la pieza */
        if (fila != (numeroFilas -1))
            if (tablero[fila+1][columna] == HUECO)
            {
                /* Se hace el movimiento hacia abajo */
                mueve (fila, columna, fila+1, columna);
                return true;
            }
        
        /* Si la columna no es la de la izquierda, se mira a ver si el hueco
         * est� a la izquierda de la pieza */
        if (columna != 0)
            if (tablero[fila][columna-1] == HUECO)
            {
                /* Se hace el movimiento hacia la izquierda */
                mueve (fila, columna, fila, columna-1);
                return true;
            }
        
        /* Si la columna no es la de la derecha del todo, se mira a ver si el
         * hueco est� a la derecha de la pieza */
        if (columna != (numeroColumnas-1))
            if (tablero[fila][columna+1] == HUECO)
            {
                /* Se hace el movimiento hacia la derecha */
                mueve (fila, columna, fila, columna+1);
                return true;
            }
        
        /* Si se llega hasta aqu�, es que la pieza no tiene el hueco alrdedor y
         * por tanto no se puede mover */
        return false;
    }
    
    /**
     * Devuelve la pieza que est� en la fila, columna indicadas. -1 si
     * fila,columna est� fuera del tablero.
     */
    public int damePieza (int fila, int columna)
    {
        /* Si fila,columna no est� dentro del tablero, se devuelve -1 */
        if (!compruebaCoordenadas (fila, columna))
            return -1;
        
        /* Se devuelve la pieza en fila,columna */
        return tablero[fila][columna];
    }
    
    /**
     * A�ade el observador que se le pasa a la lista de observadores.
     */
    public void anhadeObservador (ObservadorMovimiento nuevoObservador)
    {
        if (nuevoObservador != null)
            observadores.add (nuevoObservador);
    }
    
    /**
     * Se elimina el observador que se le pasa de la lista de observadores
     */
    public void quitaObservador (ObservadorMovimiento unObservador)
    {
        if (unObservador != null)
        {
            observadores.remove (unObservador);
        }
    }
    
    /**
     * Devuelve el n�mero de filas del tablero
     */
    public int dameFilas()
    {
        return numeroFilas;
    }
    
    /**
     * Devuelve el n�mero de columnas del tablero
     */
    public int dameColumnas()
    {
        return numeroColumnas;
    }

    /**
     * Devuelve el numero de piezas que se pueden mover.
     */
    public int dameNumeroPosiblesMovimientos()
    {
        int numeroPosiblesMovimientos = 4;
        
        /* Si el hueco est� en la primera fila o en la �ltima fila, hay
         * un movimiento menos. No se puede mover la pieza desde fuera
         * del tablero. */
        if ((this.filaHueco == 0) || (this.filaHueco == numeroFilas-1))
            numeroPosiblesMovimientos--;
        
        /* Idem si es primera o �ltima columna */
        if ((this.columnaHueco == 0) || (this.columnaHueco == numeroColumnas-1))
            numeroPosiblesMovimientos--;
        
        return numeroPosiblesMovimientos;
            
    }
    
    /**
     * Devuelve un array con las posiciones de las piezas que se pueden mover.
     */
    public Casilla[] damePosiblesMovimientos ()
    {
        /* Array auxiliar para poner las posiciones de las piezas que se pueden
         * mover y devolverlo */
        Casilla [] aux = new Casilla[dameNumeroPosiblesMovimientos()];
        int i=0;
        
        /* Si el huecho no esta en la primera fila, se puede bajar la pieza que 
         * est� encima del hueco. */
        if (this.filaHueco != 0)
        {
            aux[i] = new Casilla (this.filaHueco-1, this.columnaHueco);
            i++;
        }
        
        /* Si el hueco no est� en la �ltima fila, se puede subir la pieza que
         * est� debajo del hueco. */
        if (this.filaHueco != (numeroFilas -1))
        {
            aux[i] = new Casilla (this.filaHueco+1, this.columnaHueco);
            i++;
        }
        
        /* si el hueco no est� en la primera columna, se puede mover la pieza
         * que est� a la izquierda del hueco. */
        if (this.columnaHueco != 0)
        {
            aux[i] = new Casilla (this.filaHueco, this.columnaHueco-1);
            i++;
        }
        
        /* Si el hueco no est� en la �ltima columna, se puede mover la pieza
         * que est� a la derecha del hueco */
        if (this.columnaHueco != (numeroColumnas -1))
        {
            aux[i] = new Casilla (this.filaHueco, this.columnaHueco+1);
            i++;            
        }
        
        return aux;
    }
    
    /**
     * Devuelve true si el puzzle est� ordenado. false en caso contrario.
     *
     * Se inicializa un contador con el valor de pieza 1, que debe estar en
     * la posici�n 1,1. Se incrementa el contador y se pasa a la siguiente
     * casilla. Comparando el contador con el contenido de la casilla, se sabe
     * si el puzzle est� ordenado.
     */
    public boolean estaOrdenado()
    {
        /* Para recorrer el tablero */
        int fila, columna;
        /* Para ver la pieza que toca en cada casilla */
        int contador = 1;
        
        /* Bucle doble para cada fila y columna, recorriendo as� todo el
         * tablero */
        for (fila=0; fila < numeroFilas; fila++)
            for (columna=0; columna < numeroColumnas; columna++)
            {
                /* Tratamiento especial para el hueco en la �ltima posici�n
                 * del tablero. Si hemos llegado hasta la �ltima posici�n del
                 * tablero, todas las dem�s piezas est�n en su sitio. La �ltima
                 * posici�n estar� ocupada por el hueco (el 0) y no por la pieza
                 * n�mero filas*columnas, que no existe. */
                if (contador == numeroFilas*numeroColumnas)
                    return true;
                
                /* Si la pieza no es la que debe, se devuelve false */
                if (tablero[fila][columna] != contador)
                    return false;
                
                /* Se pone en contador el valor de la siguiente pieza del
                 * del puzzle */
                contador++;
            }
        
        /* Si se llega hasta aqu�, el puzzle est� ordenado */
        return true;
    }
    
    /**
     * Mueve una pieza al hueco. Presupone que los par�metros que se le pasan
     * son correctos y no los verifica.
     * Notifica del movimiento a los observadores de movimiento de piezas.
     * Verifica si el puzzle ya est� ordenado para avisar a los observadores.
     */
    private void mueve (int fila, int columna, int filaHueco, int columnaHueco)
    {
        /* Se realiza el movimiento */
        tablero [filaHueco][columnaHueco] = tablero[fila][columna];
        tablero [fila][columna] = HUECO;
        
        /* Se actuliazan las variables que mantienen la posici�n actual del
         * hueco */
        this.filaHueco=fila;
        this.columnaHueco=columna;
       
        /* Notifica del movimiento a los suscriptores de movimientos de pieza */
        notificaMovimiento (fila, columna, filaHueco, columnaHueco);
        
        /* Verifica si est� ordenado para notificar a los suscriptores de
         * tablero ordenado */
        if (estaOrdenado())
            notificaOrdenado();
    }
    
    /**
     * Notifica a los suscriptores el movimiento de una pieza.
     */
    private void notificaMovimiento (
        int filaVieja, int columnaVieja,
        int filaNueva, int columnaNueva)
    {
        int i;
        /* Variable auxiliar para hacer el cast m�s c�modo */
        ObservadorMovimiento aux;
        
        /* Bucle para cada observador */
        for (i=0; i<observadores.size(); i++)
        {
            aux =(ObservadorMovimiento)observadores.get(i);
            /* Se notifica el movimiento */
            aux.tomaMovimiento (
                filaVieja, columnaVieja, 
                filaNueva, columnaNueva);
        }
    }
    
    /**
     * Notifica a los observadores que el puzzle est� ordenado
     */
    private void notificaOrdenado()
    {
        int i;
        /* Variable auxiliar para hacer m�s c�modo el cast */
        ObservadorMovimiento aux;
        
        /* Bucle para cada observador */
        for (i=0; i<observadores.size(); i++)
        {
            aux =(ObservadorMovimiento)observadores.get(i);
            /* Se notifica que est� ordenado */
            aux.ordenado();
        }
    }
    
    /**
     * Devuelve true si la fila,columna cae dentro del tablero. false en
     * caso contario
     */
    private boolean compruebaCoordenadas (int fila, int columna)
    {   
        // Si la fila, columna no es del tablero, se devuelve false y no se
        // hace nada.
        if ( (fila < 0) || (fila >= numeroFilas) ||
            (columna < 0) || (columna >=numeroColumnas))
                return false;
        
        return true;
    }
    
    /** N�mero de filas del puzzle. Por defecto 3 */
    private int numeroFilas = 3;
    
    /** N�mero de columnas del puzzle. Por defecto 3 */
    private int numeroColumnas = 3;
    
    /** Array bidimensional que representa el tablero. Las piezas ser�n enteros
     * 1, 2, 3, etc. El Hueco es el 0 */
    private int [][] tablero;
    
    /* Fila en la que est� el hueco */
    private int filaHueco;
    
    /* Columna en la que est� el hueco */
    private int columnaHueco;
    
    /** Entero que representa el hueco en el puzzle */
    static public final int HUECO=0;
    
    /** Lista de observadores */
    private LinkedList observadores = new LinkedList();
}
