package jdbc.day1;
import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) throws Exception
	{
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
		//2.
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3.
		Statement stmt=con.createStatement();
		//4. select�� �ۼ�
		String sql="SELECT idx, name, msg, wdate FROM memo ORDER BY idx ASC";
		
		//5. ResultSet executeQuery(String sql)
		ResultSet rs=stmt.executeQuery(sql);
		/*ResultSet�� select���� ���� ������� ��� ���̺��� �����Ѵ�.
		 * - ������ Ŀ���� �̵���Ű�� ������� �����͸� �����Ѵ�.
		 * -���� Ŀ���� ù��° ���� ������ ��ġ�ϰ� �ִٰ� (before first)
		 *  next()�޼ҵ尡 ȣ��Ǹ� Ŀ���� ���� ĭ���� �̵���Ű��, �̵��� ��ġ��
		 *  ���ڵ尡 �ִٸ� true�� ��ȯ�Ѵ�.
		 *  boolean next()
		 * */
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		
		//6.
		rs.close();
		if(stmt!=null)stmt.close();
		if(con!=null)con.close();
	}

}
