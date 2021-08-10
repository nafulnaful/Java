package jdbc.day3;
import java.sql.*;
import jdbc.util.*;
/*CREATE OR REPLACE PROCEDURE MEMO_DEL
(NUM IN NUMBER)
IS
BEGIN
    DELETE FROM MEMO WHERE IDX=NUM;
    END;*/


public class CallableStatementTest2 {

	public static void main(String[] args) throws SQLException {
		if(args.length!=1) {
			System.out.println("명령줄 인수를 1개 입력하세요");
			return;
		}
		String num=args[0];
		
		Connection con=DBUtil.getCon();
		String sql="{call memo_del(?)}";
		CallableStatement cstmt=con.prepareCall(sql);//불러오는 코드
		cstmt.setInt(1,  Integer.parseInt(num));
		int cnt=cstmt.executeUpdate();
		System.out.println(cnt+"개의 레코드 삭제됨");
		cstmt.close();
		con.close();

	}

}
