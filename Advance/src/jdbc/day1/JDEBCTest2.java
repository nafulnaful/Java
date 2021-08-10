package jdbc.day1;
import java.sql.*;
import javax.swing.*;
//jdbc�� auto commit�ȴ�.
//sql������ �߾�� �ߴ�

public class JDEBCTest2 {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException{
		String name=JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���");
		String msg=JOptionPane.showInputDialog("�޸� ������ �Է��ϼ���");
		if(name==null||msg==null){
			System.out.println("�̸��� �ݵ�� �Է��ؾ� �մϴ�.");
			return;
		}
		
		
		/*memo���̺� �Ʒ��� ���� �����͸� �����ϴ� ������ �ۼ��ؼ� �����Ű����
		 * 1. ȫ�浿 �ȳ��ϼ���? �ݰ����ϴ�. 21/06/28
		 * ===>INSERT��
		 * 
		 * */
		
		//1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB����
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott",pwd="tiger";
		
		Connection con=DriverManager.getConnection(url, user, pwd);
		
		//3. STATEMENT���
		Statement stmt= con.createStatement();
		//��������: my_seq->�˾Ƽ� �����ϴ� ��-->�� my�ϱ�	 memo�� �ƴϰ�
		
		//4. ������ �ۼ�==> INSERT�� �ۼ�
		String sql="insert into memo(idx,name,msg,wdate) ";
				sql+= "values(my_seq.nextval,'"+name+"','"+msg+"',sysdate)";
		System.out.println(sql);
		
		//5. �����Ű��
		boolean b=stmt.execute(sql);//selectŸ���� true �������� false
		System.out.println("b=="+b);
		//6. �ڿ��ݳ�
		if(stmt!=null) stmt.close();
		if(con!=null)con.close();
		
		
	}

}
