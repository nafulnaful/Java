package jdbc.day1;
import java.sql.*;
import javax.swing.*;

public class MemoDelete {

	public static void main(String[] args)
	throws Exception
	{
		String idx=JOptionPane.showInputDialog("삭제할 글 번호를 입력하세요");
		if(idx==null) return;
		//1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.db연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott",pwd="tiger";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3. statment 열기
		Statement stmt= con.createStatement();
		//4. sql=>delete문 작성
		String sql="delete from memo where idx="+idx;//넘버유형은 홋따움표 안 붙여도 괜찮다.
		
		/* Statement의 메소드
		 * [1] boolean execute(String sql):모든 sql문을 실행시킨다.
		 * [2] int executeUpdate(String sql): DML문장(INSERT,DELETE,UPDATE)을
		 * 			실행시키고, DML문장에 의해 영향받은 레코드 개수를 반환한다.
		 * [3] ResultSet executeQuery(String sql): DQL(SELECT문) 문장을 싱행시키고
		 * 			그 결과 셋을 반환한다.
		 * */
		
		//5. statement를 execute메소드로 실행
		//boolean b=stmt.execute(sql);
		int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt+"개의 레코드를 삭제했습니다.");
		
		//6.
		if(stmt!=null) stmt.close();
		if(con!=null)con.close();
	}

}
