package modelo;

/*
 * Javier Abell�n, 30 de Abril de 2003
 *
 * Interface para los observadores de movimientos del modelo de puzzle.
 */ 

/**
 * Aquellas clases interesadas en los movimientos del puzzle (la interface
 * gr�fica, el algoritmo de ordenaci�n, etc), pueden a�adir un observador
 * que cumpla esta interface.
 */
public interface ObservadorMovimiento {
    
    /**
     * Cada vez que en el puzzle se mueva una pieza, se avisar� a los
     * observadores llamando a este m�todo, pasando la antigua posici�n de la
     * pieza dentro del puzzle y su nueva posici�n.
     */
    public void tomaMovimiento (int filaVieja, int columnaVieja,
        int filaNueva, int columnaNueva);
    
    /**
     * Cuando un movimiento haga que el puzzle est� totalmente ordenado, se
     * avisar� a los observadores llamando a este m�todo.
     */
    public void ordenado();
}
