package jdbc.day1;
import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) throws Exception
	{
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    String url="jdbc:oracle:thin:@localhost:1521:XE";
	    String user="scott",pwd="tiger";
		//2.
		Connection con=DriverManager.getConnection(url,user,pwd);
		//3.
		Statement stmt=con.createStatement();
		//4. select문 작성
		String sql="SELECT idx, name, msg, wdate FROM memo ORDER BY idx ASC";
		
		//5. ResultSet executeQuery(String sql)
		ResultSet rs=stmt.executeQuery(sql);
		/*ResultSet은 select문에 의해 영향받은 결과 테이블을 참조한다.
		 * - 논리적인 커서를 이동시키는 방식으로 데이터를 추출한다.
		 * -논리적 커서는 첫번째 행의 직전에 위치하고 있다가 (before first)
		 *  next()메소드가 호출되면 커서를 다음 칸으로 이동시키고, 이동한 위치에
		 *  레코드가 있다면 true를 반환한다.
		 *  boolean next()
		 * */
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		
		//6.
		rs.close();
		if(stmt!=null)stmt.close();
		if(con!=null)con.close();
	}

}
