package jdbc.day1;
import java.sql.*;
import javax.swing.*;

public class MemoUpdate {

	public static void main(String[] args) 
	throws Exception{
		String idx=JOptionPane.showInputDialog("������ �۹�ȣ �Է�");
		String msg=JOptionPane.showInputDialog("������ �۳��� �Է�");
		String name=JOptionPane.showInputDialog("������ �ۼ��� �Է�");
		if(idx==null||msg==null)return;
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
		//2.
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3.
		Statement stmt=con.createStatement();
		//4. update�� �ۼ��ϱ�
		String sql="update memo set msg='"+msg+"', name='"+name+"'where idx="+idx;
		System.out.println(sql);
		//5.
		int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt+"���� ���ڵ带 ����");
		//6.
		if(stmt!=null)stmt.close();
		if(con!=null)con.close();
	}

}
