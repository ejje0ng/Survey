package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SurveySelectAll 
{
	public void selectAll() 
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Connection con2 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs2 = null;
	
	StringBuffer query = new StringBuffer();
	query.append("select * from \"Survey\" ");
	StringBuffer query2 = new StringBuffer();
	query2.append("select * from \"Survey02\" ");
	
	
	try
	{
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"System",
				"1234");
		con2 = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"System",
				"1234");
		
		pstmt = con.prepareStatement(query.toString());
		rs = pstmt.executeQuery();
		
		pstmt2 = con2.prepareStatement(query2.toString());
		rs2 = pstmt2.executeQuery();
		
		while(rs.next() && rs2.next())
		{
			int num = rs.getInt("NUM");
			int age = rs.getInt("AGE");
			String gender = rs.getString("GENDER");
			Survey survey = new Survey(num, age, gender);
			System.out.print(survey+" ");
			int first = rs2.getInt("FIRST");
			int second = rs2.getInt("SECOND");
			int third = rs2.getInt("THIRD");
			
			Survey02 result = new Survey02(first, second, third);
			System.out.println(result);
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		
	
	}

		
}

