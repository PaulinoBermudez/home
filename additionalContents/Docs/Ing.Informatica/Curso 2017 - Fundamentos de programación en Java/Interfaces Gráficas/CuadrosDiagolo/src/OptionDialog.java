
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionDialog {

    // OCHO - (Component, Object, String, int, int, Icon, Object[], Object)
    public void Opciones() {
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione opción",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"opción 1", "opción 2", "opción 3"},
                "opcion 1");
        if (seleccion != -1) {
            System.out.println("seleccionada opción " + (seleccion + 1));
        }
    }

    public void Options() {
        String[] options = {"Opción A", "Opción B", "Opción C", "Opción D"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Es necesario que seleccione una opción",
                "Título",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        
        if (seleccion == 0) {
            System.out.println("Opción A");
        } else if (seleccion == 1) {
            System.out.println("Opción B");
        } else if (seleccion == 2) {
            System.out.println("Opción C");
        } else {
            System.out.println("Opción D");
        }
    }

    public void Alumno() {
        Object[] options = {"Alumno", "Profesor"};
        ImageIcon icono = new ImageIcon("src/iconos/alumno64.png");
        int opcion = JOptionPane.showOptionDialog(
                null,
                "Elige Alumno o Profesor",
                "Aviso",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icono,
                options,
                options[0]);

        if (opcion == 0) {
            System.out.println("Has elegido Alumno");
        } else {
            System.out.println("Has elegido Profesor");
        }
    }

    public void Medidas() {

        Object[] options = {"Métrico", "Imperial"};
        int n = JOptionPane.showOptionDialog(null,
                "Tipo de Medida",
                "Sistemas de Medidas",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.DEFAULT_OPTION,
                null,
                options,
                options[1]);

        System.out.println(n);

        JFrame metrico = new JFrame("Métrico");
        metrico.setBounds(0, 0, 320, 240);

        JFrame imperial = new JFrame("Imperial");
        imperial.setBounds(0, 0, 320, 240);

        if (n == 0) {
            metrico.setVisible(true);
        } else if (n == 1) {
            imperial.setVisible(true);
        } else {
            System.out.println("No se ha elegido Opción");
        }

    }

}
