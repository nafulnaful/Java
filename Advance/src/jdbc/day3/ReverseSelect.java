package jdbc.day3;
import java.sql.*;
import jdbc.util.DBUtil;

public class ReverseSelect {

	public static void main(String[] args) throws SQLException {
		Connection con=DBUtil.getCon();
		String sql="select empno,ename, job from emp order by empno asc";
		//��� ������������ ��������
		//PreparedStatement ps=con.prepareStatement(sql);==> rs.next()�� ������
		
		PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//Ŀ���� ��������� �̵��ϰ� �ʹٸ� �ɼ��� �־�� �Ѵ�.
		ResultSet rs=ps.executeQuery();
		//Ŀ���� ���������� ���ķ� �̵����Ѻ���.
		rs.afterLast();//rs.beforeFirst();=>rs.next();
		
		while(rs.previous()){//Ŀ���� ����	�� �̵���Ű��.
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
         * rs.berforeFirst() : ù��° ���� ������ ��ġ
         * rs.first() : ù��° �࿡ ��ġ��Ų��.
         * rs.last() : ������ �࿡ ��ġ
         * rs.absolute(5) : 5��° ������ �̵�
         *   - ��� ==> next(), ����==>previous()�� ���� ����
         * rs.getRow() : ���� Ŀ���� ��ġ�� ���� ���� ��ȣ�� ��ȯ  
         */
		rs.close();
		ps.close();
		con.close();
	}

}
