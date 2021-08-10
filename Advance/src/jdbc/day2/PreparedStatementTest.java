//6.29[1]
package jdbc.day2;
import java.sql.*;
/* PreparedStatement
 *  - 미리 준비된 Statement
 *  - sql문을 매번 실행시킬 때 마다 DBMS 포맷에 맞게 컴파일 시키는 것이 아니라
 *    미리 준비된 sql문을 컴파일하여 전처리해 놓고, 변경되는 값 부분만
 *    실행시킬 때 컴파일하여 실행시킨다.
 *    => Statement와 비교할 때 미리 전처리하므로 성능상 뛰어나다.
 * */
import javax.swing.*;
public class PreparedStatementTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		String name=JOptionPane.showInputDialog("작성자 입력");
		String msg=JOptionPane.showInputDialog("메모 내용 입력");
		if(name==null||msg==null) return;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//이게 없을때는 ClassNotFoundException이 발생한다.
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
	
		Connection con=DriverManager.getConnection(url,user,pwd);
		String sql2="INSERT INTO memo(idx,name,msg,wdate)"
					+" VALUES(memo_seq.nextval, ?,?,sysdate)";
		//? :IN PARAMETER
		PreparedStatement pstmt=con.prepareStatement(sql2);
		//인파라미터를 제외한 sql문장을 미리 컴파일 시켜 준비해둔다.
		
		//인파라미터값 setting을 해야 한다.
		pstmt.setString(1, name);//?값을 1번 2번으로 set하겠다는 의미
		pstmt.setString(2, msg);
		
		//Statement stmt=con.createStatement();
		
//		String sql="INSERT INTO memo(idx,name,msg,wdate)"
//				 +" VALUES(memo_seq.nextval, '"+name+"','"+msg+"', sysdate)";
//		System.out.println(sql);
		
//		int cnt=stmt.executeUpdate(sql);
		int cnt=pstmt.executeUpdate();
		System.out.println(cnt+"개의 레코드 삽입");
		
		pstmt.close();
		con.close();
	
	}

}
