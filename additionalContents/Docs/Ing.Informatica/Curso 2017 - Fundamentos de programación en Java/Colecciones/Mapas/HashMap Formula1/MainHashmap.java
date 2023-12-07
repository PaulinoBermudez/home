/* @(#)MainHashmap.java
 */
/**
 * 
 * @author <a href="mailto:gaspy@XiKiTiN">Gaspar Fernández Moreno</a>
 * http://totaki.com/poesiabinaria
 */
import java.util.*;

public class MainHashmap{
	
    public static void main(String argv[]){
    	
		PilotoHashmap pilotos=new PilotoHashmap();
		
		pilotos.add("Sebastian Vettel", "Red Bull", "1987/07/03", 1057);
		pilotos.add("Mark Webber", "Red Bull", "1976/08/27", 848.5);
		pilotos.add("Jenson Button", "McLaren", "1980/01/19", 999);
		pilotos.add("Lewis Hamilton", "McLaren", "1985/01/17", 913);
		pilotos.add("Fernando Alonso", "Ferrari", "1981/07/29", 1367);
		pilotos.add("Nico Rosberg", "Mercedes", "1985/06/27", 399.5);
		pilotos.add("Kimi Raikkonen", "Lotus", "1979/10/17", 785);
		pilotos.add("Paul di Resta", "Force India", "1986/04/16", 73);
		pilotos.add("Kaumi Kobayasi", "Sauber", "1986/09/13", 125);
		pilotos.add("Daniel Ricciardo", "Toro Rosso", "1989/07/01", 10);
		pilotos.add("Pastor Maldonado", "Williams", "1985/03/09", 43);
		pilotos.add("Vitaly Petrov", "Caterham", "1984/09/08", 64);
		pilotos.add("Pedro de la Rosa", "HRT", "1971/02/24", 35);
		pilotos.add("Timo Glock", "Marussia", "1982/03/18", 51);
		pilotos.add("Felipe Massa", "Ferrari", "1985/04/25", 704);
		pilotos.add("Michael Schumacher", "Mercedes", "1969/01/03", 1566);
		pilotos.add("Romain Grosjean", "Lotus", "1986/04/17", 86);
		pilotos.add("Nico Hulkenberg", "Force India", "1987/08/19", 85);
		pilotos.add("Sergio Perez", "Sauber", "1980/01/26", 80);
		pilotos.add("Jean Eric Vergne", "Toro Rosso", "1980/04/25", 12);
		pilotos.add("Bruno Serna", "Williams", "1983/10/15", 33);
		pilotos.add("Heikki Kovalainen", "Caterham", "1989/10/19", 105);
		pilotos.add("Narain Karthikeyan", "HRT", "1977/01/14", 5);
		pilotos.add("Charles Pic", "Marussia", "1980/02/15", 0);

		// System.out.println(pilotos.buscaEscuderia("Ferrari"));
		// System.out.println(pilotos.getList());
		// String s="";
		// for (int i=0; i<100000; i++)
		//     s = pilotos.toString();
	
		// System.out.println(s);

		Collection <Piloto> ps = pilotos.getList();
	
		for (int i=0; i<10000000; i++)
		    {
			for (Piloto p : ps)
			    {
				Piloto pn = pilotos.busca(p.getNombre());
			    }
		    }

    }
}
