
/**
 * En esta clase implementaré los nodos enlazados para la estructura de datos de lista con la que representaré el grafo indicado 
 * en el enunciado mediante una lista de adyacencia
 * 
 * @author Alejandro Angel Rodriguez Simón
 * @version Alfa0.1 - Simplemente la implementación básica de la estructura, sin funcionalidades adicionales propias de la práctica
 */
public class Nodo 
{
    private int nodo, coste;
    private Nodo siguiente;
 
    /**
     * Constructor del elemento de datos Nodo
     * En la inicialización de este elemento de datos se realizan las siguientes asignaciones:
     * - siguiente será null puesto que al incializar el nodo no conocemos cual será el siguiente.
     * - nodo será el número asignado en la estructura de datos a la que pertenezca el elemento.
     * - peso representará el coste de este elemento para los objetivos de la estructura de datos.
     */
    public Nodo(int numeroNodo, int costeNodo)
    {
        nodo = numeroNodo;
        coste = costeNodo;
        siguiente = null;
    }
    
    public Nodo(int numeroNodo, String costeNodo)
    {
        nodo = numeroNodo;
        if (costeNodo.equals("O")){
            coste = Integer.MAX_VALUE;
        } else {
            if (costeNodo.equals("S")){
                coste = 0;
            } else {                
                if (costeNodo.equals("R")){
                    coste = 0;
                } else {
                    coste = Integer.parseInt(costeNodo);
                }
            }
        }              
    }    

    /**
     * Este método lo usaremos para recuperar la numeración del nodo y tratarlo entonces de forma apropiada
     */
    public int getNodo() 
    {
        return nodo;
    }
    
    /**
     * Con este método fijamos el atributo nodo que identificará al elemento
     */
    public void setNodo(int referenciaNodo) 
    {
        this.nodo = referenciaNodo;
    }    
    
    /**
     * Con este método fijamos el atributo peso para aplicar el algoritmo de cálculo
     */
    public void setCoste(int costeNodo) 
    {
        this.coste = costeNodo;
    }        

    /**
     * Para obtener el peso del nodo y emplearlo en el algoritmo que estemos implementando usaremos este método
     */    
    public int getCoste() 
    {
        return coste;
    }   
    
    /**
     * Con este método añadimos un nuevo Nodo como siguiente
     */
    public void setSiguiente(Nodo otroNodo) 
    {
        this.siguiente = otroNodo;
    }        

    /**
     * Para obtener el siguiente nodo
     */    
    public Nodo getSiguiente() 
    {
        return siguiente;
    }     
     
}
