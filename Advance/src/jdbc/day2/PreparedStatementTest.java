//6.29[1]
package jdbc.day2;
import java.sql.*;
/* PreparedStatement
 *  - �̸� �غ�� Statement
 *  - sql���� �Ź� �����ų �� ���� DBMS ���˿� �°� ������ ��Ű�� ���� �ƴ϶�
 *    �̸� �غ�� sql���� �������Ͽ� ��ó���� ����, ����Ǵ� �� �κи�
 *    �����ų �� �������Ͽ� �����Ų��.
 *    => Statement�� ���� �� �̸� ��ó���ϹǷ� ���ɻ� �پ��.
 * */
import javax.swing.*;
public class PreparedStatementTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		String name=JOptionPane.showInputDialog("�ۼ��� �Է�");
		String msg=JOptionPane.showInputDialog("�޸� ���� �Է�");
		if(name==null||msg==null) return;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//�̰� �������� ClassNotFoundException�� �߻��Ѵ�.
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
	
		Connection con=DriverManager.getConnection(url,user,pwd);
		String sql2="INSERT INTO memo(idx,name,msg,wdate)"
					+" VALUES(memo_seq.nextval, ?,?,sysdate)";
		//? :IN PARAMETER
		PreparedStatement pstmt=con.prepareStatement(sql2);
		//���Ķ���͸� ������ sql������ �̸� ������ ���� �غ��صд�.
		
		//���Ķ���Ͱ� setting�� �ؾ� �Ѵ�.
		pstmt.setString(1, name);//?���� 1�� 2������ set�ϰڴٴ� �ǹ�
		pstmt.setString(2, msg);
		
		//Statement stmt=con.createStatement();
		
//		String sql="INSERT INTO memo(idx,name,msg,wdate)"
//				 +" VALUES(memo_seq.nextval, '"+name+"','"+msg+"', sysdate)";
//		System.out.println(sql);
		
//		int cnt=stmt.executeUpdate(sql);
		int cnt=pstmt.executeUpdate();
		System.out.println(cnt+"���� ���ڵ� ����");
		
		pstmt.close();
		con.close();
	
	}

}
