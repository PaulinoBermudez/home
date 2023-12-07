/**
 * @(#)Peliculas.java
 *
 * Peliculas application
 *
 * @author Antonio Rivero
 * @version 1.00 2015/3/17
 */
 import java.util.ArrayList;
 
 /*
  * Ejemplo en donde se muestra como funciona
  * un ArrayList
  */
  
public class Peliculas {
	
	// Este atributo representa el titulo de la pelicula.
	private String titulo;
	// Este atributo representa al director de la misma.
	private String director;
	// Este atributo identifica el anyo de estreno de la pelicula.
	private int anyo;
	// Almacena el genero de la pelicula.
	private Tgenero genero;
	// Este atributo representa un breve resumen de la pelicula.
	private String sinopsis;
	
     /**
     * Constructor con 5 parametros
     * @param titulo Titulo de la Pelicula
     * @param director nombre del Director
     * @param anyo anyo de la Pelicula
     * @param genero genero de la Pelicula
     * @param sinopsis Sinopsis de la Pelicula
     */
    public Peliculas(String titulo, String director, int anyo, Tgenero genero, String sinopsis){
        this.titulo=titulo;
        this.director=director;
        this.anyo=anyo;
        this.genero=genero;
        this.sinopsis=sinopsis;
    }	
    	
    /**
    * Devuelve el Titulo de la Pelicula
    * @return Titulo de la Pelicula
    */
    public String getTitulo() {
        return titulo;
    }
 
    /**
    * Modifica el Titulo de la Pelicula
    * @param Titulo
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
    * Devuelve el nombre del Director
    * @return nombre del Director
    */
    public String getDirector() {
        return director;
    }
 
    /**
    * Modifica el nombre del Director
    * @param Director
    */
    public void setDirector(String director) {
        this.director = director;
    }
    
    /**
    * Devuelve el anyo de la Pelicula
    * @return anyo de la Pelicula
    */
    public int getanyo() {
        return anyo;
    }
 
    /**
     * Modifica el anyo de la Pelicula
     * @param anyo
     */
    public void setanyo(int anyo) {
        this.anyo = anyo;
    }
    
    /**
    * Devuelve el Genero de la Pelicula
    * @return Genero de la Pelicula
    */
    public Tgenero getTgenero() {
        return genero;
    }
 
    /**
    * Modifica el Genero de la Pelicula
    * @param Genero
    */
    public void setTgenero(Tgenero genero) {
        this.genero = genero;
    }
    
     /**
     * Devuelve un breve resumen de la Pelicula
     * @return resumen de la Pelicula
     */
    public String getSinopsis() {
        return sinopsis;
    }
 
    /**
    * Modifica la Sinopsis de la Pelicula
    * @param Sinopsis
    */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    /**
    * Metodo que imprime la informacion sobre la pelicula.
    *
    */
    public void mostrarInfoPelicula(){
    	System.out.println(getTitulo());
		System.out.println(getDirector());
		System.out.println(getanyo());
		System.out.println(getTgenero());
		System.out.println(getSinopsis());	
    }
}
