package jdbc.day2;
import java.sql.*;
import javax.swing.*;

import jdbc.util.DBUtil;

//Memo���̺���
//�ۼ��ڸ� �Է¹޾�, �ش� �ۼ��ڰ� �ۼ��ѱ۵��� ��� ������ �����ִ� ���α׷��� �ۼ��ϼ���
// =>PreparedStatement�� �̿��ؼ�
//"ȫ�浿" ==> ȫ�浿�� �ۼ��� �� ��� �����ֱ�
//"��浿" ==> �ۼ��� ���� �����ϴ�.

public class PreparedStatementTest3 {

	public static void main(String[] args) throws SQLException {
		String name=JOptionPane.showInputDialog("�˻��� �ۼ��� �Է�");
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
			System.out.println(name+"���� ���� �����ϴ�.");
		}else {
			System.out.println("�� "+cnt+"���� ���� �ֽ��ϴ�.");
		}
		rs.close();
		pstmt.close();
		con.close();
	}

}
