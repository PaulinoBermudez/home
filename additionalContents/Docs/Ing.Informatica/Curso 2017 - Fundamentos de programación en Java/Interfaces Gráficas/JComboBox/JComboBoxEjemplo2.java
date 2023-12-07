import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @(#)JComboBoxEjemplo2.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/8/14
 */


public class JComboBoxEjemplo2 {

  public static void main(final String args[]) {
    final String labels[] = { "A", "B", "C", "D", "E" };
    JFrame frame = new JFrame("JComboBox Editable");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JComboBox comboBox = new JComboBox(labels);
    comboBox.setMaximumRowCount(5);
    comboBox.setEditable(true);
    frame.add(comboBox, BorderLayout.NORTH);

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        System.out.print("Selecionado: " + comboBox.getSelectedItem());
        System.out.println(", Posicion: " + comboBox.getSelectedIndex());
      }
    };
    comboBox.addActionListener(actionListener);

    frame.setSize(300, 200);
    frame.setVisible(true);

  }

}