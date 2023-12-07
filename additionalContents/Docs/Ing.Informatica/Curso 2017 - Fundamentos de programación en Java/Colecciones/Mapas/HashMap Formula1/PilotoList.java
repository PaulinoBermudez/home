/* @(#)PilotoList.java
 */
/**
 *
 * @author <a href="mailto:gaspy@XiKiTiN">Gaspar Fernández Moreno</a>
 * http://totaki.com/poesiabinaria
 */

import java.util.*;

public class PilotoList
{
    private List<Piloto> pilotos = new ArrayList<Piloto>();

    public PilotoList() 
    {
    }

    public void add(String nombre, String escuderia, String nacimiento, double puntos)
    {
	pilotos.add(new Piloto(nombre, escuderia, nacimiento, puntos));
    }

    public String toString()
    {
	String ret = "";
	for (Piloto p : pilotos)
	    ret+=p+"\n";
	
	return ret;
    }

    public Piloto busca(String nombre)
    {
	for (Piloto p : pilotos)
	    if (p.getNombre().equals(nombre))
		return p;
	
	return null;
    }

    public List<Piloto> buscaEscuderia(String escuderia)
    {
	List <Piloto> lista = new ArrayList<Piloto>();

	for (Piloto p : pilotos)
	    if (p.getEscuderia().equals(escuderia))
		lista.add(p);
	
	return lista;
    }
    
    public List<Piloto> getList()
    {
	return pilotos;
    }

}
