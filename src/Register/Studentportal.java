package Register;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Register.RegisterGrade;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Studentportal extends JFrame {

	JFrame frame;

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentportal frame = new Studentportal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Studentportal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 721, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 733, 462);
		panel.setBackground(new Color(102- 51- 0));
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Admission slot", null, panel_1, null);
		panel_1.setLayout(null);
		new RegisterGrade().frame.setVisible(true);
		
		JPanel panel_2 = new JPanel();
		
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsinformation","root","");
				Statement stmt=	con.createStatement();
				String sql="Select registrationnumber,names,grades from stundentinfo where programme='Computer Science'";
				ResultSet rs = stmt.executeQuery(sql);
				
				con.close();
				} catch(Exception e1){System.out.print(e1); 
					
				}
			}
		});
		btnNewButton.setBounds(304, 11, 89, 23);
		panel_2.add(btnNewButton);
		
		table_1 = new JTable();
		table_1.setBounds(34, 48, 684, 364);
		panel_2.add(table_1);
		
		Degree cs = new Degree("Computer Science");
		Degree gc = new Degree("Global Challenges");
		Degree bs = new Degree("Business Studies");

		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Computer science", cs.studentsPanel);
		tabbedPane.addTab("global challenge", gc.studentsPanel);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Business studies", bs.studentsPanel);
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(106, 114, 126, -98);
		panel_4.add(table);
		

	}
}