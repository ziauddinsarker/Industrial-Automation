import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class SpinnerListener implements ChangeListener {
    JSpinner j;
 
    public SpinnerListener(JSpinner spinner) {
        j = spinner;
    }
 
    public void stateChanged(ChangeEvent evt) {
        JSpinner spinner = (JSpinner) evt.getSource();
        // get the value of sp1
        double value = Double.parseDouble(spinner.getValue().toString());
        // set the value of sp2 according to sp1 + 1
        j.setValue(value + 1);
 
    }
}