package jdbc.day3;
import java.sql.*;
import javax.swing.*;
import jdbc.util.DBUtil;
/*emp�� �μ���ȣ, �μ���, �����, ����, �ٹ����� �������� ���ν��� �ۼ��ؼ�
 *�ڹ��ʿ��� ȣ���غ���
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
      
      String dno=JOptionPane.showInputDialog("�μ���ȣ�� �Է��ϼ���");
      if(dno==null) return;
      
      Connection con=DBUtil.getCon();
      
      String sql="{call emp_sel(?,?)}";
            //call + ������ ���̺�? ������? + (�ζ��Ĺ���,�ƿ��Ķ����)
      CallableStatement cstmt=con.prepareCall(sql);
      
      //���Ķ���� ����
      cstmt.setInt(1, Integer.parseInt(dno));
      
      //�ƿ��Ķ���� ���� ==> registerOutParameter()�޼ҵ� �̿�
      cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
                        //�Ķ���� �ε���, SQLtype
      cstmt.execute();//���ν��� ����
      
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