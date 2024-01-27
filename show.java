package login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class show {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldSearch;
private JComboBox comboBoxSelection;
private JTextField SI_no;
private JTextField Student_ID;
private JTextField Student_Name;
private JTextField Supervisor_Name;
private JTextField Group_;
private JTextField Project_Name;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show window = new show();
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
	public show() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1362, 704);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnshow = new JButton("Display Data");
		btnshow.setBounds(63, 452, 157, 36);
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","12345");
						Statement st=con.createStatement();
						String query="select * from student";
					ResultSet rs=st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String sid,gr,stid,stn,prna,sn;
					while(rs.next()) {
						sid=rs.getString(1);
						gr=rs.getString(2);
						stid=rs.getString(3);
						stn=rs.getString(4);
						prna=rs.getString(5);
						sn=rs.getString(6);
						String[] row= {sid,gr,stid,stn,prna,sn};
						model.addRow(row);
					}
					st.close();
					con.close();
					
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		frame.getContentPane().setLayout(null);
		btnshow.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnshow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 98, 926, 467);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(63, 515, 105, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						String selection=(String)comboBoxSelection.getSelectedItem();
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","12345");
						Statement st=con.createStatement();
						String query="select * from student where "+selection+"=?";
						PreparedStatement pst=con.prepareStatement(query);
						pst.setString(1,textFieldSearch.getText());
					ResultSet rs=pst.executeQuery();
					ResultSetMetaData rsmd=rs.getMetaData();
					
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String sid,gr,stid,stn,prna,sn;
					while(rs.next()) {
						sid=rs.getString(1);
						gr=rs.getString(2);
						stid=rs.getString(3);
						stn=rs.getString(4);
						prna=rs.getString(5);
						sn=rs.getString(6);
						String[] row= {sid,gr,stid,stn,prna,sn};
						model.addRow(row);
					}
					st.close();
					con.close();
					
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		textFieldSearch.setBounds(936, 26, 206, 42);
		textFieldSearch.addKeyListener(new KeyAdapter() {
		
				
			
		});
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		 comboBoxSelection = new JComboBox();
		 comboBoxSelection.setBounds(743, 26, 168, 42);
		 comboBoxSelection.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxSelection.setModel(new DefaultComboBoxModel(new String[] {"Supervisor_ID", "Group_", "Student_ID"}));
		frame.getContentPane().add(comboBoxSelection);
		
		JLabel lblNewLabel = new JLabel("Supervisor_ID");
		lblNewLabel.setBounds(28, 117, 149, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student_ID");
		lblNewLabel_1.setBounds(25, 204, 116, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student_Name");
		lblNewLabel_2.setBounds(25, 249, 152, 24);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Supervisor_Name");
		lblNewLabel_3.setBounds(10, 328, 179, 36);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel_3);
		
		SI_no = new JTextField();
		SI_no.setBounds(187, 113, 173, 29);
		SI_no.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(SI_no);
		SI_no.setColumns(10);
		
		Student_ID = new JTextField();
		Student_ID.setBounds(187, 199, 173, 36);
		Student_ID.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(Student_ID);
		Student_ID.setColumns(10);
		
		Student_Name = new JTextField();
		Student_Name.setBounds(187, 244, 173, 36);
		Student_Name.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(Student_Name);
		Student_Name.setColumns(10);
		
		Supervisor_Name = new JTextField();
		Supervisor_Name.setBounds(187, 332, 173, 29);
		Supervisor_Name.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(Supervisor_Name);
		Supervisor_Name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update ");
		btnNewButton_1.setBounds(148, 390, 116, 21);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","12345");

						String query="update student set Supervisor_ID='"+SI_no.getText()+"',Group_='"+Group_.getText() +"',Student_ID='"+Student_ID.getText()+"',Student_Name='"+Student_Name.getText()+"',Project_Name='"+Project_Name.getText()+"',Supervisor_Name='"+Supervisor_Name.getText()+"' where Student_ID='"+Student_ID.getText()+"' ";
						PreparedStatement pst=con.prepareStatement(query);
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog( null, "Data Update Successfully","Message",JOptionPane.NO_OPTION);
						
						pst.close();
					
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showInputDialog(null, "Data NOT Update","Message",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showInputDialog(null, "Data NOT Update","Message",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
				
			
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Insert");
		btnNewButton_2.setBounds(25, 390, 116, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","12345");
				
						String query="insert into student values(?,?,?,?,?,?)";
						PreparedStatement pst=con.prepareStatement(query);
						pst.setString(1,SI_no.getText());
						pst.setString(2,Group_.getText());
						pst.setString(3, Student_ID.getText());
						pst.setString(4, Student_Name.getText());
						pst.setString(5, Project_Name.getText());
						pst.setString(6, Supervisor_Name.getText());
						pst.executeUpdate();
						JOptionPane.showMessageDialog( null, "Data Stored Successfully","Message",JOptionPane.NO_OPTION);
						
						con.close();
					
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showInputDialog(null, "Data NOT Stored","Message",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showInputDialog(null, "Data NOT Stored","Message",JOptionPane.ERROR_MESSAGE);
				}
			
				
			}
				
				
				
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBounds(273, 390, 129, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root","12345");
		
						//String query="delete from student where Group_='"+Group_.getText()+"'";
						String query="delete from student where Student_ID='"+Student_ID.getText()+"'";
						PreparedStatement pst=con.prepareStatement(query);
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog( null, "Data Delete Successfully","Message",JOptionPane.NO_OPTION);
						
						pst.close();
					
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showInputDialog(null, "Data NOT Delete","Message",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showInputDialog(null, "Data NOT Delete","Message",JOptionPane.ERROR_MESSAGE);
				}
				
				
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("STUDENT INFORMATION");
		lblNewLabel_4.setBounds(409, 10, 282, 42);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setBounds(74, 162, 67, 23);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel_5);
		
		Group_ = new JTextField();
		Group_.setBounds(187, 158, 173, 31);
		Group_.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(Group_);
		Group_.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Project Name");
		lblNewLabel_6.setBounds(25, 294, 134, 24);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(lblNewLabel_6);
		
		Project_Name = new JTextField();
		Project_Name.setBounds(187, 289, 173, 33);
		Project_Name.setFont(new Font("Tahoma", Font.BOLD, 19));
		frame.getContentPane().add(Project_Name);
		Project_Name.setColumns(10);
		
		//refreshtable();
	}
}
