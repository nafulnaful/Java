package jdbc.day1;
import java.sql.*;
import javax.swing.*;

public class MemoUpdate {

	public static void main(String[] args) 
	throws Exception{
		String idx=JOptionPane.showInputDialog("수정할 글번호 입력");
		String msg=JOptionPane.showInputDialog("수정할 글내용 입력");
		String name=JOptionPane.showInputDialog("수정할 작성자 입력");
		if(idx==null||msg==null)return;
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
		//2.
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3.
		Statement stmt=con.createStatement();
		//4. update문 작성하기
		String sql="update memo set msg='"+msg+"', name='"+name+"'where idx="+idx;
		System.out.println(sql);
		//5.
		int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt+"개의 레코드를 수정");
		//6.
		if(stmt!=null)stmt.close();
		if(con!=null)con.close();
	}

}
