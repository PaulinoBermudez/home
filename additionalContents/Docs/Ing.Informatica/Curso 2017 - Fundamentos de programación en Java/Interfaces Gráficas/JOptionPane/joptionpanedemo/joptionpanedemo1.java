
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class joptionpanedemo1 {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("JOptionPane Demo");

        // implement ItemListener interface
        class MyItemListener implements ItemListener {

            public void itemStateChanged(ItemEvent ev) {
                boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
                AbstractButton button = (AbstractButton) ev.getItemSelectable();
                String command = button.getActionCommand();
                if (selected) {
                    int messageType = -1;
                    String message = "";
                    if (command.equals("INFORMATION")) {
                        messageType = JOptionPane.INFORMATION_MESSAGE;
                        message = "Information Message";
                    } else if (command.equals("WARNING")) {
                        messageType = JOptionPane.WARNING_MESSAGE;
                        message = "Warning Message";
                    } else if (command.equals("ERROR")) {
                        messageType = JOptionPane.ERROR_MESSAGE;
                        message = "Error Message";
                    } else if (command.equals("QUESTION")) {
                        messageType = JOptionPane.QUESTION_MESSAGE;
                        message = "Question Message";
                    }
                    // show message
                    JOptionPane.showMessageDialog(frame,
                            message,
                            "Message Dialog",
                            messageType);
                }
            }
        }

        JRadioButton r1 = new JRadioButton("Information Message");
        r1.setActionCommand("INFORMATION");

        JRadioButton r2 = new JRadioButton("Warning Message");
        r2.setActionCommand("WARNING");

        JRadioButton r3 = new JRadioButton("Error Message");
        r3.setActionCommand("ERROR");

        JRadioButton r4 = new JRadioButton("Question Message");
        r4.setActionCommand("QUESTION");

        // add event handler
        MyItemListener myItemListener = new MyItemListener();
        r1.addItemListener(myItemListener);
        r2.addItemListener(myItemListener);
        r3.addItemListener(myItemListener);
        r4.addItemListener(myItemListener);

        // add radio buttons to a ButtonGroup
        final ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        // Frame setting
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        Container cont = frame.getContentPane();

        cont.setLayout(new GridLayout(0, 1));
        cont.add(new JLabel("Please choose the message type:"));
        cont.add(r1);
        cont.add(r2);
        cont.add(r3);
        cont.add(r4);

        frame.setVisible(true);
    }
}
