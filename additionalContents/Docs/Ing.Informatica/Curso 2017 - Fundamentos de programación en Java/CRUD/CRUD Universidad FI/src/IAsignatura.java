
/**
 * @(#)IAsignatura.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/24
 */
public interface IAsignatura {

    /**
     * Agrego objetos en el ArrayList
     *
     * @param alumno
     */
    public void agregarAlumnos(Alumno alumno);

    /**
     * Agrego objetos en el ArrayList en una poscion
     *
     * @param pos
     * @param alumno
     */
    public void agregarAlumnosPos(int pos, Alumno alumno);

    /**
     * Agrego objetos en el ArrayList Comprobando si el alumno ya se ha agregado
     *
     * @param alumno
     */
    public void agregarAlumnos2(Alumno alumno);

    /**
     * Imprimo los Alumnos reccorriendo el ArrayList con un Iterator
     */
    public void listarAlumnosIterator();

    /**
     * Imprimo los Alumnos reccorriendo el ArrayList con un for
     */
    public void listarAlumnosFor();

    /**
     * Imprimo los Alumnos reccorriendo el ArrayList con un for each
     */
    public void listarAlumnosForEach();

    /**
     * Con este metodo buscamos Objetos de tipo Alumno comparandolo con el
     * Telefono de contacto.
     */
    public void buscarAlumno();

    /**
     * Con este metodo eliminamos Objetos de tipo Alumno comparandolo con el
     * Telefono de contacto.
     */
    public void eliminarAlumno1();

    /**
     * Con este metodo eliminamos Objetos de tipo Alumno comparandolo con el
     * Telefono de contacto.
     */
    public void eliminarAlumno2();

    /**
     * Con este metodo eliminamos Objetos de tipo Alumno comparandolo con el
     * Telefono de contacto.
     */
    public void eliminarAlumno3();

}
