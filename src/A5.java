
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;


public class A5 extends JPanel {

public A5() {
    super(new GridLayout(1, 1));
    //creating tabbed pane
    JTabbedPane tabbedPane = new JTabbedPane();
    //calling question 1 tab method
    JComponent q1 = makeq1panel("Question 1");
    q1.setPreferredSize(new Dimension(420, 150));
    tabbedPane.addTab("Question 1", q1);
    add(tabbedPane);    
}


private JComponent makeq1panel(String question) {
    //making panel and title for it
    final JPanel panel = new JPanel(false);
    panel.setLayout(new GridLayout(3, 1));
    JLabel title = new JLabel("Enter a number and press confirm");
    title.setHorizontalAlignment(JLabel.CENTER);
    panel.add(title);
    //spinner for input
    int spinnerstart = 1;
    SpinnerModel number = new SpinnerNumberModel(spinnerstart, spinnerstart - 1, spinnerstart + 50, 1);
    final JSpinner spin = addSpinner(panel,number);
    //confirm button
    JButton btconfirm = new JButton("Confirm");
    btconfirm.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            String output = null;
            //checking if value is correct
            int inputINT = (Integer)spin.getValue();
            if (inputINT <10 && inputINT >1) 
                output = "True";
            else output = "False";
            //Question output
            JLabel d2 = new JLabel("Output: " + output);
            java.awt.Font subfont = new java.awt.Font("Dialog",Font.BOLD,14);
            d2.setFont(subfont);
            d2.setHorizontalAlignment(JLabel.CENTER);
            panel.removeAll();
            panel.add(d2);
            //reset button
            JButton btclose = new JButton("Close Program");
            btclose.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
            //adding close button and refreshing
            panel.add(btclose);
            revalidate();
            repaint();
        }
    });
    panel.add(btconfirm);
    return panel;
}



private static void makewindow() {
    //Create and set up the window.
    JFrame frame = new JFrame("Assignment 5");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Add content to the window.
    frame.add(new A5(), BorderLayout.CENTER);
    //Display the window.
    frame.pack();
    frame.setVisible(true);
}

static protected JSpinner addSpinner(Container c, SpinnerModel model) {
    JSpinner spinner = new JSpinner(model);
    c.add(spinner);

    return spinner;
}

public static void main(String[] args) {
    //run it
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            makewindow();


        }


    });
}
}