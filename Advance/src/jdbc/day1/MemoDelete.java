package jdbc.day1;
import java.sql.*;
import javax.swing.*;

public class MemoDelete {

	public static void main(String[] args)
	throws Exception
	{
		String idx=JOptionPane.showInputDialog("������ �� ��ȣ�� �Է��ϼ���");
		if(idx==null) return;
		//1.����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.db����
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott",pwd="tiger";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3. statment ����
		Statement stmt= con.createStatement();
		//4. sql=>delete�� �ۼ�
		String sql="delete from memo where idx="+idx;//�ѹ������� Ȫ����ǥ �� �ٿ��� ������.
		
		/* Statement�� �޼ҵ�
		 * [1] boolean execute(String sql):��� sql���� �����Ų��.
		 * [2] int executeUpdate(String sql): DML����(INSERT,DELETE,UPDATE)��
		 * 			�����Ű��, DML���忡 ���� ������� ���ڵ� ������ ��ȯ�Ѵ�.
		 * [3] ResultSet executeQuery(String sql): DQL(SELECT��) ������ �����Ű��
		 * 			�� ��� ���� ��ȯ�Ѵ�.
		 * */
		
		//5. statement�� execute�޼ҵ�� ����
		//boolean b=stmt.execute(sql);
		int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt+"���� ���ڵ带 �����߽��ϴ�.");
		
		//6.
		if(stmt!=null) stmt.close();
		if(con!=null)con.close();
	}

}
