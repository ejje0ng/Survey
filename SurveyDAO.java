package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyDAO 
{
	public void InsertS(int age, String gender)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		StringBuffer query = new StringBuffer();
		query.append("insert into \"Survey\" ");
		query.append("(\"NUM\", \"AGE\", \"GENDER\")");
		query.append("values (\"Survey_SEQ\".nextval, ?,?)");
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"system",
					"1234");
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1,  age);
			pstmt.setString(2, gender);
			
			result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt !=null)
			{
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	}

	