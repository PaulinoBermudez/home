
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConfirmDialog {

    // DOS - (Component, Object)
    public void Confirmado() {
        int confirmado = JOptionPane.showConfirmDialog(
                null,
                "Reserva");

        if (JOptionPane.OK_OPTION == confirmado) {
            System.out.println("Confirmada");
        } else {
            System.out.println("Anulada");
        }
    }

    // CUATRO - (Component, Object, String, int)
    public void EjecutarAplicacion() {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                "Desea seguir ejecutando la aplicación?",
                "Seleccione una opción",
                JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("Has pulsado SI");
        } else if (opcion == JOptionPane.NO_OPTION) {
            System.out.println("Has pulsado NO");
        }
    }

    // CINCO - (Component, Object, String, int, int)
    public void CursoJava() {
        int codigo = JOptionPane.showConfirmDialog(
                null,
                "5 Créditos",
                "Curso 0 Java UNED",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (codigo == JOptionPane.YES_OPTION) {
            System.out.println("Has pulsado SI");
        } else if (codigo == JOptionPane.NO_OPTION) {
            System.out.println("Has pulsado NO");
        }
    }

    // SEIS - (Component, Object, String, int, int, Icon)
    public void JuegoEstrategia() {
        ImageIcon icon = new ImageIcon("src/iconos/Mafiagame64.png");
        int input = JOptionPane.showConfirmDialog(
                null,
                "¿Te gustas los Juegos de estrategia?",
                "Video Games",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon);
        System.out.println(input);
    }
}
