
/**
 * @(#)MisVehiculos.java
 *
 * @author Antonio Rivero
 * @version 1.00 2017/7/6
 *
 * Creamos la clase MisVehiculos
 */

public class MisVehiculos {

    public static void main(String args[]) {

        // Se crean dos instancias de la clase Vehiculo
        Vehiculo vehiculo1 = new Vehiculo("4050ABJ", "VW", "GTI", "Blanco", 100.0);

        Vehiculo vehiculo2 = new Vehiculo("2345JVM", "SEAT", "Leon", "Negro", 80.0);

        // Se crea una instancia de la clase Cliente
        Cliente cliente1 = new Cliente("30435624X", "Juan", "Perez");

        // Se crea una instancia de la clase VehiculoAlquilado que
        // relaciona al cliente1 con el vehiculo1, el vehiculo se
        // alquila con fecha 11/11/2011 durante 2 dias
        VehiculoAlquilado alquiler1 = new VehiculoAlquilado(cliente1, vehiculo1, 11, 11, 2011, 2);

        System.out.println("Vehiculo alquilado");
        System.out.println("Cliente : "
                + alquiler1.getCliente().getNIF() + " "
                + alquiler1.getCliente().getNombre() + " "
                + alquiler1.getCliente().getApellidos());

        System.out.println("Vehiculo: "
                + alquiler1.getVehiculo().getMatricula());

        System.out.println("Cambio de matricula");
        alquiler1.getVehiculo().setMatricula("1234 ABC");
        System.out.println(alquiler1.getVehiculo().getMatricula());

    }
}
