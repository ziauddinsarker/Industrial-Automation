import java.awt.BorderLayout;
 
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
 
 
public class SpinnerExample {
     
    JFrame f ;
 
    public SpinnerExample() {
    f = new JFrame();
    f.setSize(300, 400);
    f.setVisible(true);
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
     
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
  
    f.setLayout( new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS) );
      
    // create the two spinners with two different models
    SpinnerNumberModel model1 = new SpinnerNumberModel( 5.0, 0.0, 10.0, 0.2 );
    SpinnerNumberModel model3 = new SpinnerNumberModel( 5.0, 0.0, 10.0, 0.2 );
    JSpinner spin1 = new JSpinner( model1 );
    JSpinner spin3 = new JSpinner (model3);
    spin1.addChangeListener(new SpinnerListener(spin3));
      
    p1.add(spin1);
    p2.add(spin3);
      
    f.add(p1, BorderLayout.CENTER);
    f.add(p2, BorderLayout.SOUTH);
      
    f.pack();
    p1.setVisible( true );
    }
    public static void main(String[] args) {
        new SpinnerExample();
    }
 
}