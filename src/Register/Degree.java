package Register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


public class Degree {
	JPanel studentsPanel = new JPanel();
	
	public Degree(String program) {
		JTable students = new JTable();
		students.setSize(400,400);
		students.setLocation(0,0);
		
		studentsPanel.setBounds(0,0,450,450);
		
		
		JScrollPane scrollbar = new JScrollPane(students,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentsPanel.add(scrollbar);
		
		try { Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsinformation","root","");
			Statement stmt=	con.createStatement();
			String sql="Select * from stundentinfo where programme='"+ program+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String[] columns = {"Roll number","Names","Grade"};
			DefaultTableModel model = (DefaultTableModel)students.getModel();
			model.setColumnIdentifiers(columns);
			
			String rollNum;
			String names;
			String grade;		
			
			while (rs.next()){
				rollNum = rs.getString("regnumber");
				names = rs.getString("names");
				grade = rs.getString("grades");
				String[] record = {rollNum,names,grade};
				model.addRow(record);
			}
			
			con.close();
		} catch(Exception e1){System.out.print(e1); 
			
		}
		studentsPanel.setVisible(true);
	}
}