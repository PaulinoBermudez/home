import java.util.*;

/**
 * Esta clase devuelve un objeto cliente con los datos insertados obtenidos de la linea pasda 
 * como parametro, leida desde el fichero de entrada 
 * 
 * @author José Luis
 * @version 1.00
 */
public class Tokenizer
{
    //Variable cadena de la instacia
    private String cadena;
    //Variable para separar los tokens de la linea parametro
    private StringTokenizer token;

    
    //Constructor
    /**
     *
     */
    public Tokenizer (String cadena)
    {
        this.cadena = cadena;
        token = new StringTokenizer(cadena);
    }

    //Métodos de la clase
    
    /**
     * 
     */
    public float getTokens()
    {
        int i = 0;
        List<Float> retorno = new LinkedList<Float>();
        while(token.hasMoreTokens())
        {
               Float unfloat = Float.parseFloat(token.nextToken());
               retorno.add(unfloat);
        }
        return retorno.get(0);
    }
    
    
}
