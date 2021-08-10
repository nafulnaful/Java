package common.pool;
import java.util.*;
import java.sql.*;

public class ConnectionPoolBean {
	
	private Hashtable<Connection, Boolean> ht;
	private String url,user, pwd;
	private int increment = 3;//����ġ

	public ConnectionPoolBean() throws ClassNotFoundException, SQLException{
		ht=new Hashtable<>();
		//Ŀ�ؼ��� ������ �ڷᱸ��
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url="jdbc:oracle:thin:@localhost:1521:XE";
		user="tis_shop"; pwd="tiger";
		//Ŀ�ؼ��� �̸� 5�� �����ؼ� ht�� ������ ����.
		Connection con=null;
		for(int i=0;i<5;i++) {
			con=DriverManager.getConnection(url, user, pwd);
			ht.put(con, Boolean.FALSE);//FALSE�� VALUE�� ����. ������ �ʴ´ٴ� �ǹ�
		}
		System.out.println("ConnectionPoolBean created...");
	}//-----------------------
	
	public synchronized Connection getConnection() throws SQLException{
		Enumeration<Connection> en=ht.keys();//key������ Enumeration ���·� ����
		while(en.hasMoreElements()) {
			Connection con = en.nextElement();
			Boolean b = ht.get(con);
			if(b==Boolean.FALSE) {
				ht.put(con, Boolean.TRUE);//���Ϸ� ���� �ǹ̷� TRUE�� ��ŷ
				return con;
			}
		}//while------
		//����ִ� con�� �ϳ��� ���ٸ� ����ġ��ŭ Ŀ�ؼ��� ����� ����.
		for(int i=0;i<increment;i++) {
			Connection con2=DriverManager.getConnection(url,user,pwd);
			ht.put(con2, Boolean.FALSE);
		}
		return getConnection();//��� ȣ��
	}//-----------------------
	
	public void returnConnection(Connection returnCon)
	throws SQLException{
		Set<Connection> set = ht.keySet();//key������ ��ȯ
		for(Connection con:set) {
			if(con==returnCon) {
				//��ȯ�Ǵ� Ŀ�ؼǰ� �ּҰ��� ���ٸ�..False�� ǥ��������.
				ht.put(con, Boolean.FALSE);
				break;
			}
		}//for--------
		removeCon();
		//Ŀ�ؼ��� �⺻������ 5���� �����ϵ���...
	}//-----------------------

	private void removeCon() throws SQLException {
		Enumeration<Connection> en =ht.keys();
		int count=0;//false�� con�� ������ ���� ����
		while(en.hasMoreElements()) {
			Connection con=en.nextElement();
			Boolean b = ht.get(con);
			if(!b) {
				count++;
				if(count>5) {
					//false�� con�� 5�� �̻��̶�� ht���� ������ �ڿ�
					//con�� close()�Ѵ�.
					ht.remove(con);
					con.close();
				}
			}
		}
	}//----------------------------
	public void closeAll() {
		Set<Connection> set = ht.keySet();
		for(Connection con:set) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println("closeAll()����: "+e);
			}
		}
	}//----------------------------
}///////////////////////////////////////////////////



