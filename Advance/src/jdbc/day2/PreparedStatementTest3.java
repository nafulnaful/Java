package jdbc.day2;
import java.sql.*;
import javax.swing.*;

import jdbc.util.DBUtil;

//Memo테이블에서
//작성자를 입력받아, 해당 작성자가 작성한글들을 모두 가져와 보여주는 프로그램을 작성하세요
// =>PreparedStatement를 이용해서
//"홍길동" ==> 홍길동이 작성한 글 모두 보여주기
//"김길동" ==> 작성한 글이 없습니다.

public class PreparedStatementTest3 {

	public static void main(String[] args) throws SQLException {
		String name=JOptionPane.showInputDialog("검색할 작성자 입력");
		if(name==null) return;
		Connection con=DBUtil.getCon();
		//System.out.println("con=="+con);
		
		String sql="Select * FROM memo WHERE name=? ORDER BY idx DESC";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		int cnt=0;
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name2=rs.getString("name");
			String msg=rs.getString("msg");
			Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+wdate+"\t"+msg);
		}
		if(cnt==0) {
			System.out.println(name+"님의 글은 없습니다.");
		}else {
			System.out.println("총 "+cnt+"개의 글이 있습니다.");
		}
		rs.close();
		pstmt.close();
		con.close();
	}

}
