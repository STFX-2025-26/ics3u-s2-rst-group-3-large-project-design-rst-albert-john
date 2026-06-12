package AlbertJavaCode;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypeRacer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String currentSentence;
	private long startTime;
	private boolean gameActive;
	String [] randomText = {"This is a  text, type as fast as you can.","Hawian pizza is delicious.","You have so much aura.","You are really slow at typing aren't you","You type like a cheetah bro. Keep it up."};
	String userText = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeRacer window = new TypeRacer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TypeRacer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 161, 244, 89);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(10, 79, 244, 53);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTypeRacer = new JLabel("Type Racer");
		lblTypeRacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTypeRacer.setBounds(139, 11, 166, 21);
		frame.getContentPane().add(lblTypeRacer);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Start button code
				int n = 4;
				int correct = 0;
				int attempted = 0;
				int random = (int)(Math.random()* (n+1));
				textField_1.setText(randomText[random]);
				userText = textField.getText();
				for (int i= 0; i<randomText[random].length();i++) {
					attempted++;
					
					if (randomText[random].charAt(i)== userText.charAt(i) ) {
						correct++;
						
					}
				}
				
				
				//Start button code end
			}
		});
		btnNewButton.setBounds(300, 55, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("A random text will be displayed and you will have to type it accurately to win.  ");
		lblNewLabel.setBounds(10, 33, 414, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Click the start button.");
		lblNewLabel_1.setBounds(10, 59, 166, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Statistics");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(315, 139, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("WPM");
		lblNewLabel_2.setBounds(279, 173, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(318, 170, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 230, 129, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
