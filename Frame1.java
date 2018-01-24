package securitysystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Frame1 {

	private JFrame frmLogin;
	private JTextField textField_1;
	
	Validator val = new Validator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(192, 192, 192));
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 345, 424);
		frmLogin.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon Im1 = new ImageIcon(Frame1.class.getResource("/pictures/0b350b39b80c2c6cf3f7a6ace18bacc1.jpg"));
		Image image = Im1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(350, 427,  java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(newimg));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel((String) null);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userIn =textField_1.getText();
				if (userIn.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter the text  \"This is my typing speed\" in the given text field." );
				}else {
				System.out.println(val.start);
				System.out.println(val.end);
				Long first=val.start.get(0);
				Long last=val.end.get(val.end.size()-1);
				//val.checkSpeed(first,last);
				val.authenticateUser(first,last, userIn);
				}
				
				 
			}
		});
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 27));
		btnNewButton.setBounds(377, 370, 326, 46);
		frmLogin.getContentPane().add(btnNewButton);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(377, 126, 326, 2);
		frmLogin.getContentPane().add(separator);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Long startT = System.currentTimeMillis();
				val.start.add(startT);
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				Long endT = System.currentTimeMillis();
				val.end.add(endT);
			}
		});
		textField_1.setFont(new Font("Gabriola", Font.BOLD, 28));
		textField_1.setColumns(10);
		textField_1.setBounds(377, 175, 326, 39);
		frmLogin.getContentPane().add(textField_1);
		
		JLabel lblPassword = new JLabel("Enter the following text to login.");
		lblPassword.setFont(new Font("Gabriola", Font.PLAIN, 28));
		lblPassword.setBounds(377, 50, 326, 26);
		frmLogin.getContentPane().add(lblPassword);
		
		JLabel lblthisIsMy = new JLabel("\"This is my typing speed\"");
		lblthisIsMy.setFont(new Font("Gabriola", Font.PLAIN, 28));
		lblthisIsMy.setBounds(377, 89, 326, 26);
		frmLogin.getContentPane().add(lblthisIsMy);
		frmLogin.setBackground(new Color(221, 160, 221));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 745, 485);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
