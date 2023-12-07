
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputDialog {

    // UNO - (Object)
    public void UnParametro() {
        String m = JOptionPane.showInputDialog("Agregar Texto...");
        System.out.println(m);
    }

    // DOS - (Object , Object)
    public void EscribeNombre() {
        String nombre = JOptionPane.showInputDialog(
                "Escribe tu nombre",
                "Toni");
        System.out.println(nombre);
    }

    // DOS - (Component, Object)
    public void EscribirTexto() {
        JFrame frame = new JFrame("Ejemplo InputDialog");
        String nombre = JOptionPane.showInputDialog(
                frame,
                "Escribe tu nombre:");
        System.out.printf("El nombre es: %s.\n", nombre);
    }

    // TRES - (Component, Object, Object)
    public void CajaTexto() {
        String seleccion = JOptionPane.showInputDialog(
                null,
                "InputDialog",
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println("El usuario ha escrito " + seleccion);
    }

    // CUATRO - (Component, Object, String, int)
    public void IntroducirDato() {
        String seleccion = JOptionPane.showInputDialog(
                null,
                "Introduce un dato",
                "Título",
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println("El usuario ha escrito " + seleccion);
    }

    // SIETE - (Component, Object, String, int, Icon, Object[], Object)
    public void ComboMecanico() {
        String[] mecanico = {"Manolo", "Juan", "Pedro", "David"};
        ImageIcon icono = new ImageIcon("src/iconos/alumno64.png");
        JFrame frame = new JFrame("InputDialog Mecanicos");
        String mecanicoElegido = (String) JOptionPane.showInputDialog(
                frame,
                "Elegir Mecanico",
                "Mecanico",
                JOptionPane.QUESTION_MESSAGE,
                icono,
                mecanico,
                mecanico[0]);
        System.out.printf("Mecanico %s.\n", mecanicoElegido);
        System.exit(0);
    }
}
