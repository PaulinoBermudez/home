
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MessageDialog {

    //DOS - (Component, Object)
    public void MensajeDos() {
        JOptionPane.showMessageDialog(
                null,
                "Operación realizada correctamente");
    }

    // CUATRO - (Component, Object, String, int)
    public void MensajeCuatro() {
        JOptionPane.showMessageDialog(
                null,
                "Mensaje ventana UNED",
                "Título - Peligro Curso de Java",
                JOptionPane.WARNING_MESSAGE);
    }

    // CINCO - (Component, Object, String, int, Icon)
    public void VentanaDialogo() {
        ImageIcon icon = new ImageIcon("src/iconos/alumno32.png");
        JOptionPane.showMessageDialog(
                null,
                "Icono de un Alumno.",
                "Ventana personalizada",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
}
