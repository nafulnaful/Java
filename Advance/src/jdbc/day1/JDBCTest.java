//[1]6.28
package jdbc.day1;

/*==JDBC=========================================
 * - Java Database Connectivity�� ����
 * - �ڹ� ���α׷��� �����ͺ��̽��� �����Ǵ� ���α׷�
 * - ���� �ǹ̷δ� java.sql ��Ű���� �ǹ��Ѵ�.
 * [����ȯ��] DB(����Ŭ)�� �����ϱ� ���ؼ��� jdbc driver�� �ʿ��ϴ�.
 * java 8.0 ==> ojdbc6.jar(����̹�)
 * => ����Ŭ ����Ʈ���� jdbc driver�� �˻��ؼ� �ٿ�ε� �޴���
 * �ƴ� ���ÿ� ��ġ�Ǿ� �ִ� �Ʒ� ��η� ���� ã�ƺ���.
 * [1] C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 * 
 * [2] ojdbc6.jar������ �����Ͽ� �Ʒ� ��� �ٿ��ֱ� ����.
 * C:\Program Files\Java\jdk1.8.0_261\jre\lib\ext\
 * 
 * [3] eclipse������ �ش� ������Ʈ�� �����ؼ� Installed JRE ��θ�
 * C:\Program Files\Java\jdk1.8.0_261 �� �����Ͽ� ����������.
 * [4] ����Ŭ ���� ����
 *     ����Ŭ TNS������ ����Ǿ� �־�� ��
 * ================================================
 * #jdbc ����
 * [1] ����̹��� �ε�==> Class.forName("����̹���")�� �̿�
 * [2] DB�� ����==> DriverManager.getConnection(db����url,user,password)
 * [3] sql���� �����ϱ� ���� ��ü Statement�� ���´�.
 *     ==> Connection�� createStatement()�޼ҵ带 �̿��ؼ�
 * [4] ������ �ۼ�
 * [5] Statement�� executeXXX()�޼ҵ�� �ش� �������� �����Ų �� �� ����� �޾ƿ´�.
 * [6] DB���� �ڿ� �ݳ�    
 * */
import java.sql.*;
class JDBCTest 
{
   public static void main(String[] args) 
   {
      try{
      //1. ����̹� �ε� => Class.forName("����̹���")�޼ҵ带 �̿��ؼ� �ε��Ѵ�.
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver Loading Success!!");

      String url="jdbc:oracle:thin:@localhost:1521:XE";
            //��������:dbms����:driverŸ��:host:port:���������ͺ��̽��̸�
      String user="scott", pwd="tiger";

      //2. DB�� ���� => DriverManagerŬ������ getConnection()�޼ҵ� �̿�
      Connection con=DriverManager.getConnection(url, user, pwd);
      System.out.println("DB�� ���� ��...");
      
      //3. Statement ���
      Statement stmt = con.createStatement();//���������� new�� �� �޴´�.
      
      //4. Query��(SQL��) �ۼ�
      String sql="create table memo(";
      		sql+="idx number(4) primary key,";
      		sql+="name varchar2(30) not null,";
      		sql+="msg varchar2(100),";
      		sql+="wdate date default sysdate)";
      
      //5. Statement�� execute()/executeXXX()�޼ҵ带 �̿��� �����Ű��
      		//boolean execute(String sql)
      		//:sql���� �����Ų��. sql���� select���� ��� true�� ��ȯ�ϰ�,
      		// select���� �ƴ� ��쿡�� false�� ��ȯ�Ѵ�.
      		
      boolean b=stmt.execute(sql);
      System.out.println("b=="+b);
      
      //6. DB���� �ڿ�  �ݳ�
      if(stmt!=null) stmt.close();
      if(con!=null) con.close();//close()�����ָ� ���� �ݺ����ư�
      } catch(ClassNotFoundException e) {
         System.out.println("Driver Loading Fail!!");
         e.printStackTrace();
      } catch(SQLException e){
         e.printStackTrace();
      }

   }
}