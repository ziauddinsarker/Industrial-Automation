// The event's source i get is always the JSpinner (even with the getModel()).
// Here i used a boolean flag to check if the change has been made by the observer or not.
// It works fine, test it yourself.


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSpinnerTest extends JPanel implements ActionListener, Observer, ChangeListener {

  JButton  myButton  = new JButton("Add 5");
  JSpinner mySpinner = new JSpinner();

  ObservableValue myObservable = new ObservableValue();

  boolean isObserverThatMadeTheChange = false;

  public JSpinnerTest() {

    this.setLayout(new BorderLayout());
    this.add(myButton, BorderLayout.NORTH);
    this.add(mySpinner, BorderLayout.SOUTH);
    myButton.addActionListener(this);
    myObservable.addObserver(this);
    mySpinner.addChangeListener(this);
  }

  // ChangeListener implementation
  public void stateChanged(ChangeEvent e) {
    System.out.println("+++  State Changed  +++");
    if (isObserverThatMadeTheChange) {
      System.out.println("stateChanged  Observer Change ---> : Do nothing");
    } else {
      System.out.println("stateChanged  JSpinner Change ---> : Do extra things here");
    }
    isObserverThatMadeTheChange = false;
  }

  // Observer implementation
  public void update(Observable o, Object arg) {
    System.out.println("+++  Update  +++");
    System.out.println("Changing value thru the Observer");
    isObserverThatMadeTheChange = true;
    mySpinner.getModel().setValue(new Integer(myObservable.getValue()));
  }

  // ActionListener implementation
  public void actionPerformed(ActionEvent ae) {
    System.out.println("+++  Action Performed  +++");
    myObservable.setValue(myObservable.getValue() + 2);
    myObservable.notifyObservers();
  }

  public void showFrame() {
    JFrame myFrame = new JFrame("JSpinner Test");
    myFrame.getContentPane().setLayout(new BorderLayout());
    myFrame.getContentPane().add(this, BorderLayout.CENTER);
    myFrame.pack();
    myFrame.setVisible(true);
  }

  public static void main(String[] args) {
    JSpinnerTest myJSpinnerTest = new JSpinnerTest();
    myJSpinnerTest.showFrame();

  }

  class ObservableValue extends Observable {
    private int value = 0;
    public int  getValue() {
      return value;
    }
    public void setValue(int newvalue) {
      value = newvalue;
      this.setChanged();
    }
  }

}