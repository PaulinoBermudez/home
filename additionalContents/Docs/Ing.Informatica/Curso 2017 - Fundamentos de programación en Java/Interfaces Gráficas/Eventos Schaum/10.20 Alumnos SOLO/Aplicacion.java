
/**
 * @(#)Aplicacion.java
 *
 *
 * @author
 * @version 1.00 2017/4/25
 */
import java.util.List;
import java.util.ArrayList;

public class Aplicacion {

    private ArrayList<Alumno> lista;

    public Aplicacion() {

        this.lista = new ArrayList<Alumno>();
    }

    public void agregarAlumno(Alumno alumno) {
        lista.add(alumno);
    }

    public java.util.List<Alumno> dameContenido() {
        return lista;
    }
}
