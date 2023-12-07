package modelo;

/*
 * Javier Abell�n. 27 de Abril de 2003
 *
 * Clase para mantener fila y columna de una casilla del puzzle.
 */

/**
 * Mantiene la fila y columna de una casilla del puzzle.
 * No realiza ning�n tipo de verificaci�n.
 */
public class Casilla implements Comparable {
    
    /**
     * Constructor. Se le pasa una fila y una columna
     */
    public Casilla(int fila, int columna) 
    {
        this.fila = fila;
        this.columna = columna;
    }
    
    
 
    /**
     * Compara este objeto con el que recibe.
     * Devuelve 0 si son iguales.
     * Devuelve -1 si este objeto es anterior al que se le pasa. Se entiende
     * por anterior que sea de una fila superior o, si es de la misma fila, que
     * sea de una columna anterior.
     * Devuelve 1 si este objeto es posterior al que se le pasa.
     */
    public int compareTo(Object o)
    {
        /* Auxiliar para hacer el cast de Object a Casilla */
        Casilla aux;
        
        /* Se verifica que el par�metro no es null y que es instancia de 
         * Casilla */
        if (o == null) throw new ClassCastException();
        if (!(o instanceof Casilla)) throw new ClassCastException();
        
        /* Se hace el cast */
        aux = (Casilla)o;
                
        /* Si el objeto que nos pasan es de una fila posterior a este,
         * devolvemos 1. */
        if (aux.fila > this.fila)
            return -1;
        
        /* Si el que nos pasan  es de una fila anterior a este, devolvemos -1
         */
        if (aux.fila < this.fila)
            return 1;
        
        /* Si llegamos hasta aqui es que son de la misma fila. Devolvemos -1
         * si el que nos pasan es de una columna posterior al nuestro */
        if (aux.columna > this.columna)
            return -1;
        
        /* Si el que nos pasan es de una columna anterior al nuestro, devolvemos
         * uno.
         */
        if (aux.columna < this.columna)
            return 1;
        
        /* Si llegamos hasta aqu�, es que es la misma fila y columna, devolvemos
         * cero */
        return 0;
    }
    
    /** Fila de la casilla */
    public int fila;
    
    /** Columna de la casilla */
    public int columna;
    
}
