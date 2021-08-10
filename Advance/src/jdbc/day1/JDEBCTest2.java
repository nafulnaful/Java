package jdbc.day1;
import java.sql.*;
import javax.swing.*;
//jdbc는 auto commit된다.
//sql에서는 했어야 했다

public class JDEBCTest2 {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException{
		String name=JOptionPane.showInputDialog("작성자를 입력하세요");
		String msg=JOptionPane.showInputDialog("메모 내용을 입력하세요");
		if(name==null||msg==null){
			System.out.println("이름은 반드시 입력해야 합니다.");
			return;
		}
		
		
		/*memo테이블에 아래와 같은 데이터를 삽입하는 문장을 작성해서 실행시키세요
		 * 1. 홍길동 안녕하세요? 반갑습니다. 21/06/28
		 * ===>INSERT문
		 * 
		 * */
		
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott",pwd="tiger";
		
		Connection con=DriverManager.getConnection(url, user, pwd);
		
		//3. STATEMENT얻기
		Statement stmt= con.createStatement();
		//시퀀스명: my_seq->알아서 증가하는 것-->왜 my일까	 memo가 아니고
		
		//4. 쿼리문 작성==> INSERT문 작성
		String sql="insert into memo(idx,name,msg,wdate) ";
				sql+= "values(my_seq.nextval,'"+name+"','"+msg+"',sysdate)";
		System.out.println(sql);
		
		//5. 실행시키기
		boolean b=stmt.execute(sql);//select타입은 true 나머지는 false
		System.out.println("b=="+b);
		//6. 자원반납
		if(stmt!=null) stmt.close();
		if(con!=null)con.close();
		
		
	}

}
