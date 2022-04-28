package Register;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class Register {

	private JFrame frame;
	private JTextField email1;
	private JTextField user1;
	private JPasswordField pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 503, 335);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 11, 483, 313);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102- 51- 0));
		panel_2.setBounds(153, 0, 320, 313);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		email1 = new JTextField();
		email1.setBounds(141, 57, 169, 20);
		panel_2.add(email1);
		email1.setColumns(10);
		
		user1 = new JTextField();
		user1.setBounds(141, 101, 169, 20);
		panel_2.add(user1);
		user1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(33, 63, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(33, 104, 70, 14);
		panel_2.add(lblNewLabel_1);
		
		pass1 = new JPasswordField();
		pass1.setBounds(141, 148, 169, 20);
		panel_2.add(pass1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(33, 151, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("sign_up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnNewButton) {

					
					String URL = "jdbc:mysql://localhost:3306/studentsinformation";
					String username = "root";
					String password = "";
					String email3= email1.getText();
					String username3=user1.getText();
					String password3= pass1.getText();
					
					
					String tp = String.valueOf(pass1.getPassword());
					try {
						Connection conn = DriverManager.getConnection(URL, username, password);
						
						Statement stmt = conn.createStatement();
						String query = "insert into student( email, username, password) values (?, ?, ?)";
						PreparedStatement preparedStatement = conn.prepareStatement(query);
						preparedStatement.setString(1, email3.toString());
						preparedStatement.setString (2, username3.toString());
						preparedStatement.setString   (3, tp.toString());
						int rows = preparedStatement.executeUpdate();
						if (rows > 0) {
							JOptionPane.showMessageDialog(null,"You have successfully signed up");
							new Login().frame.setVisible(true);
					               // JOptionPane.INFORMATION_MESSAGE);
							return;

						}	

						conn.close(); 
					    
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
						
						
					
				}

				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(107, 142, 35));
		btnNewButton.setBounds(93, 202, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Already have accounts , click ");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(103, 231, 82, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("sign up");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(129, 11, 89, 35);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("login");
		btnNewButton_1.setBounds(193, 227, 89, 23);
		panel_2.add(btnNewButton_1);
	    new Login().frame.setVisible(true);
		
		JLabel lblNewLabel_5 = new JLabel("");
		
		lblNewLabel_5.setBounds(0, 62, 158, 171);
		panel_1.add(lblNewLabel_5);
	}
}