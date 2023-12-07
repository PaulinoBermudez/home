package controlador;

/*
 * Javier Abell�n. 30 de Abril de 2003
 *
 * Clase de control para el puzzle. Permite ordenar y desordenar el puzzle.
 */
import java.lang.Runnable;
import java.lang.Thread;
import java.util.LinkedList;
import modelo.Casilla;
import modelo.ObservadorMovimiento;
import modelo.Puzzle;

/**
 * Ordena y desordena el puzzle.
 * Para poder ordenar el puzzle, la clase Ordenador se suscribe a los 
 * movimientos del puzzle para almacenarlos y poder repetirlos luego en orden 
 * inverso. Cuando el puzzle est� ordenado, borrar� todos los movimientos de
 * su almac�n de movimientos.
 * Para desordenar el puzzle se hacen 10 movimientos al azar.
 */
public class Ordenador implements Runnable {
    
    /**
     * Constructor.
     * Se le pasa un modelo de puzzle y se suscribe a sus movimientos.
     * @param unPuzzle
     */
    public Ordenador (Puzzle unPuzzle)
    {
        this.unPuzzle = unPuzzle;
        
        /* Se crea el observador */
        observador = new ObservadorMovimiento() {
            public void tomaMovimiento (int filaVieja, int columnaVieja,
                int filaNueva, int columnaNueva)
            {
                /* Cuando se produce un movimiento, se guarda dicho movimiento
                 */
                anhadeMovimiento (filaNueva, columnaNueva);
            }
            public void ordenado()
            {
                /* Cuando el puzzle est� ordenado, se borran todos los
                 * movimientos almacenados */
                borraMovimientos();
            }
        };
        
        /* Se a�ade el observador */
        unPuzzle.anhadeObservador(observador);
        
        /* Se crea la lista de movimientos */
        movimientos = new LinkedList();
    }
    
    /**
     * Se le dice a esta clase que ordene el puzzle. Se hace con un hilo
     * separado, de forma que mientras este hilo ordena el puzzle, el hilo
     * de AWT (de eventos y repintados) pueda ir dibujando los movimientos
     * de las piezas.
     */
    public void ordena()
    {
        /* Se pone el comando de ordenar y se le indica al hilo que arranque */
        comando = ORDENA;
        arrancaHilo();
    }
    
    /**
     * Se le dice a la clase que desordene el puzzle. Se hace con un hilo 
     * separado por el mismo motivo que el m�todo ordena().
     */
    public void desordena()
    {
        /* Se pone el comando de desordenar y se le indica al hilo que arranque
         */
        comando=DESORDENA;
        arrancaHilo();
    }
    
    /**
     * Bucle infinito con un retardo y que ejecuta en cada iteraci�n el comando
     * que se indique.
     */
    public void run() {
        while (true)
        {
            /* Si es el comando de ordenar, se ordena el puzzle y se vuelve
             * a poner el comando de no hacer nada. */
            if (comando == ORDENA)
            {
                ordenaPuzzle();
                comando=Ordenador.HACER_NADA;
            }
            
            /* Si el comando es de desordenar, se desordena el puzzle y se
             * vuelve a poner el comando de no hacer nada */
            else if (comando == DESORDENA)
            {
                desordenaPuzzle();
                comando=Ordenador.HACER_NADA;
            }
            else
            {
                /* Si no es ninguno de los dos comandos anteriores, se espera
                 * 100 ms y se vuelve a repetir el proceso */
                try {
                    Thread.sleep (100);}
                catch (Exception e){}
            }
        } /* Fin del while */
    } 
      
    /**
     * A�ade el movimiento a la lista de movimientos que se han realizado en
     * el puzzle.
     */
    void anhadeMovimiento (int fila, int columna)
    {
        movimientos.add (new Casilla(fila, columna));
    }
    
    /**
     * Elimina todos los movimientos de la lista de movimientos realizados en
     * el puzzle.
     */
    void borraMovimientos ()
    {
        movimientos.clear();
    }
    
    /**
     * Si el hilo no esta creado, lo crea. En caso contrario no hace nada. 
     */
    void arrancaHilo()
    {
        if (unHilo == null)
        {
            unHilo = new Thread (this);
            unHilo.start();
        }
    }
    
    /**
     * Ordena el puzzle, deshaciendo todos los movimientos que se hab�an hecho
     * previamente en �l.
     */
    void ordenaPuzzle()
    {
        int i;
        Casilla aux;
        if (unPuzzle == null)
            return;
        
        /* Quitamos el observador para no registrar nuestros propios movimientos
         * de ordenaci�n */
        unPuzzle.quitaObservador(observador);
        
        /* Recorremos la lista de movimientos en orden inverso y los vamos
         * deshaciendo en el puzzle */
        for (i=movimientos.size()-1; i>=0; i--)
        {
            aux = (Casilla)movimientos.get(i);
            unPuzzle.mueve (aux.fila, aux.columna);
            
            /* Se pone un retardo para que la interface de usuario vaya moviendo
             * las piezas lentamente */
            try {
            Thread.sleep (500);
            } catch (Exception e){}
        }
        
        /* Volvemos a poner el observador */
        unPuzzle.anhadeObservador(observador);
        
        /* Se supone que el puzzle est� ordenado. Borramos nuestra lista de
         * movimientos. Esta llamada hace falta, puesto que al habernos borrado
         * como observadores, el modelo de puzzle no nos avis� que el puzzle
         * estaba ordenado */
        borraMovimientos();
        
    }
    
    /**
     * Desordena el puzzle, realizando 10 movimientos aletatorios en �l.
     */
    void desordenaPuzzle ()
    {
        int i;
        int eleccion;
        Casilla [] posiblesMovimientos;
        
        if (unPuzzle == null)
            return;
        
        /* Bucle para realizar 10 movimientos aleatorios */
        for (i=0; i<10; i++)
        {
            /* Se pide a unPuzzle los posibles movimientos v�lidos en la
             * situaci�n actual del tablero */
            posiblesMovimientos = unPuzzle.damePosiblesMovimientos();
            
            /* Se elige al azar uno de los movimientos */
            eleccion = (int)(Math.random()*posiblesMovimientos.length);
            
            /* Si ya se hab�a realizado alg�n movimiento antes, se comprueba que
             * el movimiento reci�n elegido no lo deshace (comprobando con el
             * �ltimo movimiento de la lista movimientos). Si es as�, se coge
             * el siguiente movimiento posible, yendo al primero si nos pasamos 
             * con la operaci�n m�dulo */
            
            /* Si hay movimientos anteriores */
            if (movimientos.size() != 0)
                
                /* Si la pieza aleatoria elegida para mover coincide con la 
                 * �ltima pieza movida ... */
                if (posiblesMovimientos[eleccion].compareTo (
                    (Casilla)(movimientos.get(movimientos.size()-1)))==0)
                {
                    /* ... se elige el siguiente movimiento aleatorio,
                     * asegurando de no salirnos del array de movimientos
                     * posibles por medio de la operaci�n m�dulo % */
                    eleccion=(eleccion+1)%posiblesMovimientos.length;
                }
            
            /* Se realiza el movimiento elegido */
            unPuzzle.mueve (posiblesMovimientos[eleccion].fila,
                posiblesMovimientos[eleccion].columna);
            
            /* Un retardo para que la interface gr�fica pueda hacer el
             * movimiento */
            try { Thread.sleep (500);
            } catch (Exception e) {};
        }
    }
    
    /* El modelo con el tablero del puzzle y las piezas */
    Puzzle unPuzzle;
    
    /* Comando que debe realizar el hilo */
    int comando = Ordenador.HACER_NADA;
    
    /* Comando de ordenar */
    static final int ORDENA=0;
    
    /* Comando de desordenar */
    static final int DESORDENA=1;
    
    /* Comando de no hacer nada */
    static final int HACER_NADA=-1;
    
    /* El hilo encargado de ordenar y desordenar */
    Thread unHilo;
    
    /* Lista de movimientos realizados en el puzzle */
    LinkedList movimientos;
    
    /* Observador de movimientos del puzzle */
    ObservadorMovimiento observador;
}


