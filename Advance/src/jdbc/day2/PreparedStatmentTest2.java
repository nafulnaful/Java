package jdbc.day2;
import java.sql.*;
import javax.swing.*;


public class PreparedStatmentTest2 {

	public static void main(String[] args) throws Exception
	{
		String idx=JOptionPane.showInputDialog("������ �۹�ȣ �Է�");
	    String name=JOptionPane.showInputDialog("������ �ۼ��� �Է�");
	    String msg=JOptionPane.showInputDialog("������ �޸𳻿� �Է�");
	    if(idx==null||name==null||msg==null) return;
	    //1. memo���̺��� �� ����� �ۼ��ڸ� �����ϴ� ��ɹ��� �����Ű��
	    //		preparedStatement�� �̿��ؼ� �����Ű����
	    
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
	    
	    Connection con=DriverManager.getConnection(url,user,pwd);
	    String sql="UPDATE memo SET name=?,msg=? WHERE idx=?";
	    
	    PreparedStatement pstmt=con.prepareStatement(sql);
	    
	    pstmt.setString(1, name);
	    pstmt.setString(2, msg);
	    pstmt.setInt(3, Integer.parseInt(idx));
	    //string���� �ص� ����
	    
	    int cnt=pstmt.executeUpdate();
	    System.out.println(cnt+"���� ���ڵ� ����");
	    
	    pstmt.close();
	    con.close();
	
	
	
	}

}
