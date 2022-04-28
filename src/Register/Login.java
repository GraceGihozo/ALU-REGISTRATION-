package Register;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;
	/**
	 * @wbp.nonvisual location=-10,19
	 * 
	 */
	
	private final JPanel panel = new JPanel();
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	static String user_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel.setBackground(Color.BLACK);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 549, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionText);
		panel_1.setBounds(10, 11, 513, 347);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102- 51- 0));
		panel_2.setBounds(183, 0, 330, 347);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		user = new JTextField();
		user.setBounds(130, 92, 168, 20);
		panel_2.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(130, 133, 168, 20);
		panel_2.add(pass);
		
		lblNewLabel = new JLabel("userName");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(29, 92, 76, 20);
		panel_2.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(29, 133, 66, 20);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				try { Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsinformation","root","");
				Statement stmt=	con.createStatement();
				String sql="Select * from student where username='"+user.getText()+"' and password='"+pass.getText()+"'";
				ResultSet rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Login successful");
					user_id = String.valueOf(rs.getInt("Id"));
					new RegisterGrade().frame.setVisible(true);
					
					 
					
				}
				else {
					JOptionPane.showMessageDialog(null, " invalid username or Password");	
					}
				con.close();
				} catch(Exception e1){System.out.print(e1); 
					
				}
			}
		});
		btnNewButton.setBounds(112, 188, 89, 23);
		panel_2.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 330, 347);
	
		lblNewLabel_2.setIcon(null);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-12, -12, 193, 359);
		panel_1.add(lblNewLabel_3);
	}
}
