package IAGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestClass {
    public static BufferedReader input;
    public static OutputStream output;

    public static synchronized void writeData(String data) {
        System.out.println("Sent: " + data);
        try {
            output.write(data.getBytes());
        } catch (Exception e) {
            System.out.println("could not write to port");
        }
    }

    public static void main(String[] args) {
        
      
      
        try {
            SerialClass obj = new SerialClass();
            int c = 0;
            obj.initialize();
            input = SerialClass.input;
            output = SerialClass.output;
            InputStreamReader Ir = new InputStreamReader(System.in);
            BufferedReader Br = new BufferedReader(Ir);
            while (c != 3) {
                System.out.println("LED ON / OFF MENU.");
                System.out.println("1.LED ON");
                System.out.println("2.LED OFF");
                System.out.print("Enter your choice :");
                c = Integer.parseInt(Br.readLine());

                switch (c) {
                    case 1:
                        writeData("1");
                        break;

                    case 2:
                        writeData("0");
                        break;

                    case 3:
                        System.exit(0);
                }
            }


            String inputLine = input.readLine();
            System.out.println(inputLine);

            obj.close();

        } catch (Exception e) {
        
        }

    }
}