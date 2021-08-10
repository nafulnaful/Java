package jdbc.day2;
import java.sql.*;
import javax.swing.*;


public class PreparedStatmentTest2 {

	public static void main(String[] args) throws Exception
	{
		String idx=JOptionPane.showInputDialog("수정할 글번호 입력");
	    String name=JOptionPane.showInputDialog("수정할 작성자 입력");
	    String msg=JOptionPane.showInputDialog("수정할 메모내용 입력");
	    if(idx==null||name==null||msg==null) return;
	    //1. memo테이블의 글 내용과 작성자를 수정하는 명령문을 실행시키되
	    //		preparedStatement를 이용해서 실행시키세요
	    
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
	    
	    Connection con=DriverManager.getConnection(url,user,pwd);
	    String sql="UPDATE memo SET name=?,msg=? WHERE idx=?";
	    
	    PreparedStatement pstmt=con.prepareStatement(sql);
	    
	    pstmt.setString(1, name);
	    pstmt.setString(2, msg);
	    pstmt.setInt(3, Integer.parseInt(idx));
	    //string으로 해독 가능
	    
	    int cnt=pstmt.executeUpdate();
	    System.out.println(cnt+"개의 레코드 삽입");
	    
	    pstmt.close();
	    con.close();
	
	
	
	}

}
