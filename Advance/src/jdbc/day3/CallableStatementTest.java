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
		//{call 프로시저명(?,?.....)}
		String sql="{call memo_add(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);//불러오는 코드
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		
		int n=cstmt.executeUpdate();
		System.out.println(n+"개의 레코드 삽입");
		cstmt.close();
		con.close();

	}

}
