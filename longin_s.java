package login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;

public class longin_s {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					longin_s window = new longin_s();
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
	public longin_s() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 980, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELLCOME TO SOFTWARE DEVELOPMENT PROJECT MANAGEMENT SYSTEM  ");
		lblNewLabel.setBounds(161, 105, 739, 90);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(229, 228, 122, 38);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(229, 288, 122, 41);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(372, 227, 195, 41);
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(372, 288, 195, 41);
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(214, 372, 116, 21);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password=txtPassword.getText();
				String username=txtUsername.getText();
				if(password.contains("12345")&&username.contains("ict")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					//new page;
					//show info=new show();
					show.main(null);
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
				
				
			}
		});
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(360, 371, 122, 23);
		btnReset.setBackground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(507, 372, 122, 21);
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "confirm if you want to exit","Login System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Supervised By Dr.Md.Ahsan Habib");
		lblNewLabel_1.setBounds(10, 641, 215, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Developed By Anik Sarker(IT20013),Nazir Hossain(IT20055)");
		lblNewLabel_2.setBounds(600, 641, 339, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("DEPT. OF ICT,MBSTU");
		lblNewLabel_4.setBounds(401, 58, 272, 68);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\nazir1.jpg"));
		lblNewLabel_3.setBounds(0, -30, 975, 705);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
