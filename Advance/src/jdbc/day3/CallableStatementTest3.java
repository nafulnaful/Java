package jdbc.day3;
import java.sql.*;
import javax.swing.*;
import jdbc.util.DBUtil;
/*emp의 부서번호, 부서명, 사원명, 업무, 근무지를 가져오는 프로시저 작성해서
 *자바쪽에서 호출해보자
 */

/*
 create or replace procedure emp_sel
(pdno in dept.deptno%type, cr out sys_refcursor)
is
begin
open cr for
select e.deptno, dname, ename, job, loc
from emp e join dept d
on e.deptno = d.deptno and d.deptno=pdno;
end;
/
 */
public class CallableStatementTest3 {

   public static void main(String[] args) 
   throws SQLException
   {
      
      String dno=JOptionPane.showInputDialog("부서번호를 입력하세요");
      if(dno==null) return;
      
      Connection con=DBUtil.getCon();
      
      String sql="{call emp_sel(?,?)}";
            //call + 가져올 테이블? 시퀀스? + (인라파미터,아웃파라미터)
      CallableStatement cstmt=con.prepareCall(sql);
      
      //인파라미터 세팅
      cstmt.setInt(1, Integer.parseInt(dno));
      
      //아웃파라미터 세팅 ==> registerOutParameter()메소드 이용
      cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                        //파라미터 인덱스, SQLtype
      cstmt.execute();//프로시저 실행
      
      ResultSet rs=(ResultSet)cstmt.getObject(2);
      
      while(rs.next()) {
         int deptno=rs.getInt("deptno");
         String dname=rs.getString("dname");
         String ename=rs.getString("ename");
         String job=rs.getString("job");
         String loc=rs.getString("loc");
         System.out.println(deptno+"\t"+ename+"\t"+job+"\t"+loc);
      }
      rs.close();
      cstmt.close();
      
      con.close();
   }

}