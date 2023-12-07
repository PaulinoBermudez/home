
/**
 * @(#)VehiculoAlquilado.java
 *
 * @author Antonio Rivero
 * @version 1.00 2017/7/6
 *
 * Creamos la clase VehiculoAlquilado
 */
public class VehiculoAlquilado {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private int diaAlquiler;
    private int mesAlquiler;
    private int anioAlquiler;
    private int totalDiasAlquiler;

    public VehiculoAlquilado(Cliente cliente,
            Vehiculo vehiculo,
            int diaAlquiler,
            int mesAlquiler,
            int anioAlquiler,
            int totalDiasAlquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.diaAlquiler = diaAlquiler;
        this.mesAlquiler = mesAlquiler;
        this.anioAlquiler = anioAlquiler;
        this.totalDiasAlquiler = totalDiasAlquiler;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
}
