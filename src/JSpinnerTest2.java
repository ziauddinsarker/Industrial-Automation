import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

/**
 * @see http://stackoverflow.com/questions/2010819
 * @see http://stackoverflow.com/questions/3949518
 */
public class JSpinnerTest2 extends JPanel {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("JSpinnerTest");
                f.add(new JSpinnerTest());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public JSpinnerTest2() {
        super(new GridLayout(0, 1));
        final JLabel label = new JLabel();
        final JSpinner spinner = new JSpinner();
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -5);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 10);
        Date latestDate = calendar.getTime();
        spinner.setModel(new SpinnerDateModel(
            initDate, earliestDate, latestDate, Calendar.MONTH));
        DateEditor editor = new JSpinner.DateEditor(spinner, "MMM yyyy");
        spinner.setEditor(editor);
        JFormattedTextField jtf = editor.getTextField();
        DefaultFormatter formatter = (DefaultFormatter) jtf.getFormatter();
        formatter.setCommitsOnValidEdit(true);
        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner s = (JSpinner) e.getSource();
                label.setText(s.getValue().toString());
            }
        });
        label.setText(initDate.toString());
        this.add(spinner);
        this.add(label);
    }
}