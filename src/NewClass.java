import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewClass extends JFrame {
    private int num = 50;
    private JButton increment;
    private JButton decrement;
    private JLabel label;
    private JPanel buttonPanel;
    private JPanel displayPanel;

    public NewClass() {
        increment = new JButton ("Increase");
        decrement = new JButton ("Decrease");
        increment.addActionListener (new incListener());
        decrement.addActionListener (new decListener());
        increment.addActionListener (new incListener());
        decrement.addActionListener (new decListener());

        num = 9;
        label = new JLabel ("" + num);

        buttonPanel = new JPanel();
        displayPanel = new JPanel();

        buttonPanel.add(increment);
        buttonPanel.add(decrement);
        displayPanel.add(label);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);
    }

    private class incListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            num++;
            label.setText("" + num);
        }
    }

    private class decListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            num--;
            label.setText("" + num);
        }
    }

    public static void main(String[] args) {
        NewClass win = new NewClass();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);
    }
}
