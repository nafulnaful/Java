package jdbc.day3;
import java.sql.*;
import jdbc.util.DBUtil;

public class ReverseSelect {

	public static void main(String[] args) throws SQLException {
		Connection con=DBUtil.getCon();
		String sql="select empno,ename, job from emp order by empno asc";
		//사번 오름차순으로 가져오기
		//PreparedStatement ps=con.prepareStatement(sql);==> rs.next()만 가능함
		
		PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//커서를 자유자재로 이동하고 싶다면 옵션을 주어야 한다.
		ResultSet rs=ps.executeQuery();
		//커서를 마지막형의 직후로 이동시켜보자.
		rs.afterLast();//rs.beforeFirst();=>rs.next();
		
		while(rs.previous()){//커서를 역으	로 이동시키자.
		int eno=rs.getInt(1);
		String ename=rs.getString(2);
		String job=rs.getString(3);
		System.out.println(eno+"\t"+ename+"\t"+job);
		}
		System.out.println("------------------------------------------------------");
		System.out.println(rs.getRow());
		
		rs.absolute(-5);
		System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
		/**
         * rs.berforeFirst() : 첫번째 행의 직전에 위치
         * rs.first() : 첫번째 행에 위치시킨다.
         * rs.last() : 마지막 행에 위치
         * rs.absolute(5) : 5번째 행으로 이동
         *   - 양수 ==> next(), 음수==>previous()와 같은 역할
         * rs.getRow() : 실제 커서가 위치한 곳의 행의 번호를 반환  
         */
		rs.close();
		ps.close();
		con.close();
	}

}
