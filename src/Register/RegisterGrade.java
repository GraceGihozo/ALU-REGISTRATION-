package Register;
import java.util.Calendar;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class RegisterGrade {

	public JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField name1;
	private JTextField grade1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGrade window = new RegisterGrade();
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
	public RegisterGrade() {
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
		panel.setBackground(new Color(102- 51- 0));
		panel.setBounds(10, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("full name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(65, 60, 46, 14);
		panel.add(lblNewLabel);
		
		name1 = new JTextField();
	name1.setBounds(131, 57, 153, 20);
		panel.add(name1);
		name1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" ALU Registration form");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(131, 11, 130, 14);
		panel.add(lblNewLabel_1);
		
		grade1 = new JTextField();
		grade1.setBounds(131, 102, 153, 20);
		panel.add(grade1);
		grade1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("grade");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(65, 108, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int grade = Integer.parseInt(grade1.getText());
				String name = name1.getText();
				String course="";
				
//			        
//			}
				
				String URL = "jdbc:mysql://localhost:3306/studentsinformation";
				String username = "root";
				String password = "";
				if (grade>=18||grade>=20) {
					course="Computer Science";
					try {
						Connection conn = DriverManager.getConnection(URL, username, password);
						
						 
					    String query = "insert into stundentinfo( names, grades,programme,roll_number,Id)values(?,?,?,?,?)";
						PreparedStatement ps = conn.prepareStatement(query);
						int year = Calendar.getInstance().get(Calendar.YEAR);
						String roll_number = String.valueOf(year) + "/" + Login.user_id;

						ps.setString(1, name.toString());
						ps.setInt(2, grade);
						ps.setString(3, course);
						ps.setString(4, roll_number);
						ps.setInt(5, Integer.parseInt(Login.user_id));
						int rows = ps.executeUpdate();
						if (rows>0) {
							JOptionPane.showMessageDialog(null, "registered successfully!!");
							new Studentportal().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Not registered!!");
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}else if (grade>=15||grade>=17) {
					course="Global Challanges";
					try {
					Connection conn = DriverManager.getConnection(URL, username, password);
					
					 
				    String query = "insert into admissioninfo( names, grades,programme,roll_number,Id)values(?,?,?,?,?)";
				    int year = Calendar.getInstance().get(Calendar.YEAR);
					String roll_number = String.valueOf(year) + "/" + Login.user_id;
				    PreparedStatement ps = conn.prepareStatement(query);
				    
					ps.setString(1, name.toString());
					ps.setInt(2, grade);
					ps.setString(3, course);
					ps.setString(4, roll_number);
					ps.setInt(5, Integer.parseInt(Login.user_id));
					int rows = ps.executeUpdate();
					if (rows>0) {
						JOptionPane.showMessageDialog(null, "registered successfully!!!!");
						new Studentportal().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Not registered!!");
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				}else if (grade>=12||grade>=14) {
					course="Business Studies";
						try {
					Connection conn = DriverManager.getConnection(URL, username, password);
					
					 
				    String query ="insert into admissioninfo( names, grades,programme,roll_number,Id)values(?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(query);
					int year = Calendar.getInstance().get(Calendar.YEAR);
					String roll_number = String.valueOf(year) + "/" + Login.user_id;
					ps.setString(1, name.toString());
					ps.setInt(2, grade);
					ps.setString(3, course);
					ps.setString(4, roll_number);
					ps.setInt(5, Integer.parseInt(Login.user_id));
					int rows = ps.executeUpdate();
					if (rows>0) {
						JOptionPane.showMessageDialog(null, "registered successfully!!");
						new Studentportal().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Not registered!!");
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
						}else {
			JOptionPane.showMessageDialog(null, "Hey " + name +" You Are not Qualified to Study in ALU");
			
	}
				


			}
			});
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(144, 169, 89, 23);
		panel.add(btnNewButton);
	}
}
