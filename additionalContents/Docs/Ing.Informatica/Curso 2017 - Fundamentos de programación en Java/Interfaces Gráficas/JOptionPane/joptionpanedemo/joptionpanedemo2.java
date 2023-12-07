
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class joptionpanedemo2 {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("JOptionPane Demo");

        // implement ItemListener interface
        class MyItemListener implements ItemListener {

            public void itemStateChanged(ItemEvent ev) {
                boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
                AbstractButton button = (AbstractButton) ev.getItemSelectable();
                String command = button.getActionCommand();
                if (selected) {
                    int optionType = -1;

                    if (command.equals("YES_NO_OPTION")) {
                        optionType = JOptionPane.YES_NO_OPTION;
                    } else if (command.equals("YES_NO_CANCEL_OPTION")) {
                        optionType = JOptionPane.YES_NO_CANCEL_OPTION;
                    }

                    JOptionPane.showOptionDialog(frame,
                            "Are you sure to confirm the action you've made?",
                            "JOptionPane Demo",
                            optionType,
                            JOptionPane.INFORMATION_MESSAGE, // icon
                            null,
                            null,
                            null);
                }
            }
        }

        JRadioButton r1 = new JRadioButton("Yes / No Options");
        r1.setActionCommand("YES_NO_OPTION");

        JRadioButton r2 = new JRadioButton("Yes / No / Cancel Options");
        r2.setActionCommand("YES_NO_CANCEL_OPTION");

        // add event handlers
        MyItemListener myItemListener = new MyItemListener();
        r1.addItemListener(myItemListener);
        r2.addItemListener(myItemListener);

        // add radio buttons to a ButtonGroup
        final ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        Container cont = frame.getContentPane();
        cont.setLayout(new GridLayout(0, 1));
        cont.add(new JLabel("Please choose the options type:"));
        cont.add(r1);
        cont.add(r2);

        frame.setVisible(true);
    }
}
