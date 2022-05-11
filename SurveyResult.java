package survey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyResult 
{
	public void Result()
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	double onetime = 0;
	double tentime = 0;
	double notime = 0;
	double rowcount = 0;
	StringBuffer query = new StringBuffer();
	query.append("select * from \"RESULT\" ");
	
	
	try
	{
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl",
				"System",
				"oracle");
		pstmt = con.prepareStatement(query.toString());
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			rowcount = rs.getInt("Survey_NUM");
			double first = rs.getInt("FIRST");
			double second = rs.getInt("SECOND");
			double third = rs.getInt("THIRD");
			
			onetime += first;
			tentime += second;
			notime += third;
		}
		onetime = (onetime/rowcount)*100;
		tentime = (tentime/rowcount)*100;
		notime = (notime/rowcount)*100;
		System.out.println("�����ο�: "+ (int)rowcount+"��");
		System.out.printf("�Ϸ�  1�ð� �̻� �ϴ� ����� ����: %.2f%%\n",onetime);
		System.out.printf("�����Ͽ� 10�ð� �̻� �ϴ� ����� ����: %.2f%%\n",tentime);
		System.out.printf("������ ���� �ʴ� ����� ����:  %.2f%%\n",notime);			
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
	}
	
	}
}
