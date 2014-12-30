package com.java.myapp;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class MyForm extends JFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyForm frame = new MyForm();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 249);
		setTitle("ThaiCreate.Com Java GUI Tutorial");
		getContentPane().setLayout(null);
		
		// Text Field
		final JTextField txt = new JTextField();
		txt.setBounds(103, 41, 144, 20);
		getContentPane().add(txt);
		txt.setColumns(10);
		
		// Label
		final JLabel lbl = new JLabel("Result");
		lbl.setBounds(103, 120, 144, 14);
		getContentPane().add(lbl);
		
		// Button
		JButton btn1 = new JButton("Button 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl.setText("Hello : "+ txt.getText());
			}
		});
		btn1.setBounds(128, 72, 99, 23);
		getContentPane().add(btn1);
		
	}
}

