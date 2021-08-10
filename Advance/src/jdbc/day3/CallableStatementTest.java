package jdbc.day3;
import java.sql.*;
import jdbc.util.*;
/*create or replace procedure memo_add
(pname in memo.name%type,
pmsg in memo.msg%type)
is
begin
    insert into memo
    values(memo_seq.nextval,pname, pmsg, sysdate);
end;*/


public class CallableStatementTest {

	public static void main(String[] args) throws SQLException {
		String name=args[0];
		String msg=args[1];
		Connection con=DBUtil.getCon();
		//{call ���ν�����(?,?.....)}
		String sql="{call memo_add(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);//�ҷ����� �ڵ�
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		
		int n=cstmt.executeUpdate();
		System.out.println(n+"���� ���ڵ� ����");
		cstmt.close();
		con.close();

	}

}
