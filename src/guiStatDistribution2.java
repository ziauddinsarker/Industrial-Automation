import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
public class guiStatDistribution2 extends JFrame {

int str = 1;
int dex = 1;
int intel = 1;
int con = 1;
int cha = 1;
int remainingPoints = 45;

JTextField remainingDisplay = new JTextField("You have " + remainingPoints + " points left to distribute.");

SpinnerNumberModel strPoints = new SpinnerNumberModel(1,1,46,1);
SpinnerNumberModel dexPoints = new SpinnerNumberModel(1,1,46,1);
SpinnerNumberModel intPoints = new SpinnerNumberModel(1,1,46,1);
SpinnerNumberModel conPoints = new SpinnerNumberModel(1,1,46,1);
SpinnerNumberModel chaPoints = new SpinnerNumberModel(1,1,46,1);



public guiStatDistribution2() {

    JSpinner strSpin = new JSpinner(strPoints);
    JSpinner dexSpin = new JSpinner(dexPoints);
    JSpinner intSpin = new JSpinner(intPoints);
    JSpinner conSpin = new JSpinner(conPoints);
    JSpinner chaSpin = new JSpinner(chaPoints);
    //instance for strength
    strSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (remainingPoints != 0) {
                str = strPoints.getNumber().intValue();
                remainingPoints = (remainingPoints - (str-1) - (dex-1) - (intel-1) - (con-1) - (cha-1));
                remainingDisplay.revalidate();
            }
            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "No points left. Lower another score to add more.");
            }
        }
    });
    //instance for dexterity
    dexSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent f) {
            if (remainingPoints != 0) {
                dex = dexPoints.getNumber().intValue();
                remainingPoints = (remainingPoints - (str-1) - (dex-1) - (intel-1) - (con-1) - (cha-1));
                remainingDisplay.revalidate();
            }
            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "No points left. Lower another score to add more.");
            }
        }
    });
    //instance for intelligence
    intSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent g) {
            if (remainingPoints != 0) {
                intel = intPoints.getNumber().intValue();
                remainingPoints = (remainingPoints - (str-1) - (dex-1) - (intel-1) - (con-1) - (cha-1));
                remainingDisplay.revalidate();
            }
            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "No points left. Lower another score to add more.");
            }
        }
    });
    //instance for constitution
    conSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent h) {
            if (remainingPoints != 0) {
                con = conPoints.getNumber().intValue();
                remainingPoints = (remainingPoints - (str-1) - (dex-1) - (intel-1) - (con-1) - (cha-1));
                remainingDisplay.revalidate();
            }
            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "No points left. Lower another score to add more.");
            }
        }
    });
    //instance for charisma
    chaSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent i) {
            if (remainingPoints != 0) {
                cha = chaPoints.getNumber().intValue();
                remainingPoints = (remainingPoints - (str-1) - (dex-1) - (intel-1) - (con-1) - (cha-1));
                remainingDisplay.revalidate();
            }
            if (remainingPoints == 0) {
                JOptionPane.showMessageDialog(null, "No points left. Lower another score to add more.");
            }
        }
    });

    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1,2,0,5));
    p1.add(new JTextField("Strength: "));
    p1.add(strSpin);

    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(1,2,0,5));
    p2.add(new JTextField("Dexterity: "));
    p2.add(dexSpin);

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(1,2,0,5));
    p3.add(new JTextField("Intelligence: "));
    p3.add(intSpin);

    JPanel p4 = new JPanel();
    p4.setLayout(new GridLayout(1,2,0,5));
    p4.add(new JTextField("Constitution: "));
    p4.add(conSpin);

    JPanel p5 = new JPanel();
    p5.setLayout(new GridLayout(1,2,0,5));
    p5.add(new JTextField("Charisma: "));
    p5.add(chaSpin);

    JPanel p6 = new JPanel();
    p6.add(remainingDisplay);

    JButton confirm = new JButton("Confirm");
    confirm.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showOptionDialog(null, "Is this okay?\nStrength: " + str + "\nDexterity: " + dex + "\nIntelligence: " + intel + "\nConstitution: " + con + "\nCharisma: " + cha, "Confirm distribution", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    });
    JPanel p7 = new JPanel();
    p7.add(confirm);

    setLayout(new GridLayout(7,1,0,5));
    add(p6);
    add(p1);
    add(p2);
    add(p3);
    add(p4);
    add(p5);
    add(p7);

}
public static void main(String[] args) {
    guiStatDistribution2 frame = new guiStatDistribution2();
    frame.setTitle("Distribute your skill points");
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}