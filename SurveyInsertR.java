package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyInsertR
{	public void InsertR(int first, int second, int third)
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
	StringBuffer query = new StringBuffer ();
	query.append("insert into \"RESULT\" ");
	query.append("(Survey_NUM\", \"FIRST\", \"SECOND\",\"THIRD\")");
	query.append("values (\"RESULT_SEQ\".nextval, ?, ?, ?)");
	
	try
	{
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"system",
				"1234");
		pstmt = con.prepareStatement(query.toString());
		pstmt.setInt(1, first);
		pstmt.setInt(2, second);
		pstmt.setInt(3, third);
		
		result = pstmt.executeUpdate();
		
		if(result > 0)
		{
			System.out.println("입력완료");
			if(first == 0)
			{
				System.out.println("가끔은 취미도 즐겨보세요!");
			}
			else if(first + second + third == 3)
			{
				System.out.println("취미생활 잘 즐기고 계시네요!");
			}
		}
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con !=null)
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
		
		if(pstmt != null)
		{
			try
			{
				pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
				
		}
	}
}
