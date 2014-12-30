import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class GUI_PHASE3_1 extends JFrame
{
    String[] name;
    int[] price;
    String[] value = new String [13];
    JSpinner quantity;

    JTextField text1 = new JTextField (20);
    JTextField text3 = new JTextField (20);
    JTextField text4 = new JTextField (20);
    JTextField text5 = new JTextField (20);
    JTextField text7 = new JTextField (20);

    JTextField text8 = new JTextField ("Optional", 20);
    JTextField text9 = new JTextField ("Optional", 20);
    JTextArea text10 = new JTextArea ("Optional", 2, 20);

    JLabel nameL = new JLabel ();
    JLabel address1 = new JLabel ();
    JLabel address2 = new JLabel ();
    JLabel address3 = new JLabel ();
    JLabel contact = new JLabel ();
    JLabel contact2 = new JLabel ();
    JLabel contact3 = new JLabel ();
    JLabel comments = new JLabel ();

    public GUI_PHASE3_1 ()
    {

        JPanel jp1 = new JPanel (); //This will create the first tab
        JPanel jp2 = new JPanel (); //This will create the second tab
        JPanel jp3 = new JPanel ();
        JPanel jp4 = new JPanel ();

        try
        {
            name = new String [13];
            price = new int [13];
            int size = 0;

            BufferedReader infil = new BufferedReader (new FileReader ("KFCMenu.txt"));
            String line = infil.readLine ();
            while (line != null)
            {
                String field[] = line.split ("#");
                name [size] = field [0];
                price [size] = Integer.parseInt (field [1]);
                size++;
                line = infil.readLine ();

                JLabel o1 = new JLabel (field [0]);
                JLabel o2 = new JLabel (field [1]);
                JLabel randC = new JLabel ("~R");
                JLabel ospace = new JLabel ("______________________________");

                SpinnerModel sm = new SpinnerNumberModel (0, 0, 10, 1);
                JSpinner quantity1 = new JSpinner (sm);

                jp2.add (o1);
                jp2.add (randC);
                jp2.add (o2);
                jp2.add (quantity1);
                jp2.add (ospace);
                
                for (int x = 0; x < 13; x++)
                {
                    value[x] = quantity.getValue ().toString ();
                    if (Integer.parseInt (value[x]) > 0)
                    {
                        System.out.println (value[x]);
                    }
                }

            }

            infil.close ();

        }
        catch (IOException ioe)
        {

        }

        //This will create the title you see in the upper left of the window
        setTitle ("Courier-IT Like a Boss");
        setSize (300, 575); //set size so the user can "see" it
        setResizable (false);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //Here we are creating the object
        JTabbedPane jtp = new JTabbedPane ();

        //This creates the template on the windowed application that we will be using
        getContentPane ().add (jtp);

        //This creates a non-editable label, sets what the label will read
        //and adds the label to the first tab

        JLabel label1 = new JLabel ("Name of Client:");

        JLabel label2 = new JLabel ("Delivery Address Details");

        JLabel label3 = new JLabel ("Street Address:");

        JLabel label4 = new JLabel ("Town/Suburb:");

        JLabel label5 = new JLabel ("Date of Delivery:");

        JLabel space1 = new JLabel ("______________________________");

        JLabel label6 = new JLabel ("Contact Details of Client");
        JLabel label7 = new JLabel ("Contact Number 1:");
        JLabel label8 = new JLabel ("Contact Number 2:");
        JLabel label9 = new JLabel ("Additional Number:");
        JLabel label10 = new JLabel ("Comments:");
        JLabel space2 = new JLabel ("______________________________");

        jp1.add (label1);
        jp1.add (text1);

        jp1.add (label2);
        jp1.add (space1);

        jp1.add (label3);
        jp1.add (text3);

        jp1.add (label4);
        jp1.add (text4);

        jp1.add (label5);
        jp1.add (text5);

        jp1.add (label6);
        jp1.add (space2);

        jp1.add (label7);
        jp1.add (text7);

        jp1.add (label8);
        jp1.add (text8);

        jp1.add (label9);
        jp1.add (text9);

        jp1.add (label10);
        jp1.add (text10);

        //This adds the first and second tab to our tabbed pane object and names it
        jtp.addTab ("KFC", jp1);
        jtp.addTab ("Menu", jp2);
        jtp.addTab ("Order Details", jp3);
        jtp.addTab ("Confirm", jp4);

        JLabel od = new JLabel ("Order Details:");
        JLabel space4 = new JLabel ("______________________________");
        JLabel spaceNew = new JLabel ("______________________________");

        GridBagLayout gb = (new GridBagLayout ());
        GridBagConstraints c = new GridBagConstraints ();
        GridBagConstraints c2 = new GridBagConstraints ();
        GridBagConstraints c3 = new GridBagConstraints ();
        GridBagConstraints c4 = new GridBagConstraints ();
        GridBagConstraints c5 = new GridBagConstraints ();
        GridBagConstraints c6 = new GridBagConstraints ();
        GridBagConstraints c7 = new GridBagConstraints ();
        GridBagConstraints c8 = new GridBagConstraints ();
        GridBagConstraints c9 = new GridBagConstraints ();
        GridBagConstraints divider = new GridBagConstraints ();
        GridBagConstraints spaceNew2 = new GridBagConstraints ();

        jp3.setLayout (gb);
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c2.gridy = 3;
        c3.gridy = 4;
        c4.gridy = 5;
        c5.gridy = 6;
        c6.gridy = 7;
        c7.gridy = 8;
        c8.gridy = 9;
        c9.gridy = 10;
        divider.gridy = 2;
        spaceNew2.gridy = 12;

        JButton refresh = new JButton ("Refresh");
        gb.setConstraints (refresh, c);
        gb.setConstraints (nameL, c2);
        gb.setConstraints (address1, c3);
        gb.setConstraints (address2, c4);
        gb.setConstraints (address3, c5);
        gb.setConstraints (contact, c6);
        gb.setConstraints (contact2, c7);
        gb.setConstraints (contact3, c8);
        gb.setConstraints (comments, c9);
        gb.setConstraints (space4, divider);
        gb.setConstraints (spaceNew, spaceNew2);

        jp3.add (od);
        jp3.add (refresh);
        jp3.add (space4);
        jp3.add (nameL);
        jp3.add (address1);
        jp3.add (address2);
        jp3.add (address3);
        jp3.add (contact);
        jp3.add (contact2);
        jp3.add (contact3);
        jp3.add (comments);
        jp3.add (spaceNew);

        //This is an Action Listener which reacts to clicking on
        //the test button called "Press"
        ButtonHandler phandler = new ButtonHandler ();
        refresh.addActionListener (phandler);
        setVisible (true);
    }


    public class ButtonHandler implements ActionListener
    {
        public void actionPerformed (ActionEvent s)
        {

            nameL.setText (text1.getText ());
            address1.setText (text3.getText ());
            address2.setText (text4.getText ());
            address3.setText (text5.getText ());
            contact.setText (text7.getText ());
            contact2.setText (text8.getText ());
            contact3.setText (text9.getText ());
            comments.setText (text10.getText ());
        }

    }


    //This is the internal class that defines what the above Action Listener
    //will do when the test button is pressed.
    //example usage
    public static void main (String[] args)
    {
        GUI_PHASE3_1 tab = new GUI_PHASE3_1 ();
    }
}

