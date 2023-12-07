/* @(#)PilotoHashmap.java
 */
/**
 * 
 *
 * @author <a href="mailto:gaspy@XiKiTiN">Gaspar Fernández Moreno</a>
 * http://totaki.com/poesiabinaria
 */
import java.util.*;

public class PilotoHashmap
{
    private HashMap<String, Piloto> nombres = new HashMap<String, Piloto>();

    public PilotoHashmap ()
    {
    }

    public void add(String nombre, String escuderia, String nacimiento, double puntos)
    {
	Piloto p=new Piloto(nombre, escuderia, nacimiento, puntos);
	nombres.put(nombre, p);
    }

    public String toString()
    {
	String ret = "";
	for (Piloto p : nombres.values())
	    ret+=p+"\n";
	
	return ret;
    }

    public Piloto busca (String nombre)
    {
	return nombres.get(nombre);
    }

    public Collection<Piloto> getList()
    {
	return nombres.values();
    }

}
