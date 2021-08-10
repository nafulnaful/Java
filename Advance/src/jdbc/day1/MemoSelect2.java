package jdbc.day1;
import java.sql.*;
import javax.swing.*;

public class MemoSelect2 {

	public static void main(String[] args) throws Exception
	{
		
		String name=JOptionPane.showInputDialog("�˻��� �ۼ��ڸ� �Է��ϼ���");
		if(name==null)return;
		
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
	   
		String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
		//2.
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3.
		Statement stmt=con.createStatement();
		
		//4. select�� �ۼ� where�� �ʿ�
		String sql="SELECT * FROM memo where name='"+name+"' ORDER BY idx ASC";
		System.out.println(sql);
		
		//5.
		ResultSet rs=stmt.executeQuery(sql);
		
		//6.
		while(rs.next()) {
			int idx=rs.getInt(1);//ù��° �÷��� ������ �������ڴٶ�� �ǹ�
			String name2=rs.getString(2);
			String msg=rs.getString(3);
			String wdate=rs.getString(4);
			System.out.println(idx+"\t"+name2+"\t"+msg+"\t"+wdate);
		}
	
		rs.close();
		stmt.close();
		con.close();
	}

}
