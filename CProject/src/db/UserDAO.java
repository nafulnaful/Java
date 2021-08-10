package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import page.MainFrame;
import util.DBUtil;

public class UserDAO {
	MainFrame mainF;
	
	private Connection con; //�����ͺ��̽��� �����ϰ� ���ִ� ��ü
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs; //������ ���� �� ����
	
	
	public UserDAO() {
		
	}
	
	/**DB�ݱ� ��� �޼ҵ�*/
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(ps!=null) ps.close();
		} catch (Exception e) {
			System.out.println(e+"=> dbClose fail");
		}
	}//dbClose()---
	
	/**���̵� �ߺ� üũ*/
	public boolean ExistUser(String id) {
		boolean result = true;
		try
		{
			con=DBUtil.getCon();
			String sql="SELECT * FROM user_info"
					+" WHERE userId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id.trim());
			rs=ps.executeQuery();//����
			
			if(rs.next()) {
				result=false; //���̵� �ߺ��Ǹ� false
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}//ExistUser()-------------------
	
	/**�������� insert*/
	public boolean insertUser(UserDB user) {
		try
		{	
			con=DBUtil.getCon();
			String sql="INSERT INTO user_info"
					+" VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserBirth());
			ps.setString(3, user.getUserId());
			ps.setString(4, user.getUserPwd());
			ps.setString(5, user.getUserTel());
			ps.setString(6, user.getUserEmail());
			
			ps.executeUpdate(); //���� -> ����
			return true;
		}catch(Exception e) {
			System.out.println(e+"=> insertUser fail");
			return false;
		}finally {
			dbClose();
		}
		
	}//insertUser()-------------------	
	
	/**�������� update*/
	public int updateUser(UserDB user) {
		int result = 0;
		try
		{
			con=DBUtil.getCon();
			String sql="UPDATE user_info"
					+ " SET userName=?, userBirth=?, userPwd=?, userTel=?, userEmail=?"
					+" WHERE userId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserBirth());
			ps.setString(3, user.getUserPwd());
			ps.setString(4, user.getUserTel());
			ps.setString(5, user.getUserEmail());
			ps.setString(6, user.getUserId());
			
			result=ps.executeUpdate(); //����
			
		}catch(SQLException e) {
			System.out.println(e+"=> updateUser fail");
		}finally {
			dbClose();
		}
		
		return result;
	}//updateUser()----------------------
	
	/**�������� delete*/
	public int deleteUser(String id) {
		int result = 0;
		try
		{
			con=DBUtil.getCon();
			String sql="DELETE FROM user_info"
					+" WHERE userId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id.trim());
			
			result=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
		
	}//deleteUser()----------------------
	
	/**�α��� üũ*/
	public int loginCheck(String userId, String userPwd) {
		
		try {
			con=DBUtil.getCon();
			String SQL="SELECT userPwd FROM user_info WHERE userId=?";
			ps=con.prepareStatement(SQL);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			
			//�α��� �Լ� �����
			if(rs.next()) {
				if(rs.getString(1).contentEquals(userPwd)) {
					return 1; //�α���
				}else {
				return 0; //��й�ȣ�� Ʋ�Ƚ��ϴ�.
				}
			}//if---
			return -1; //���̵� �����ϴ�.
		} catch (Exception e) {
			System.out.println("�α��� ��ȿ�� ����: "+e.getMessage());
		}
		return -2; //DB���� ��Ÿ��
	}//loginCheck()------------------------
	
	/** ȸ���������� selectUserIn: ���̵�� ���� �ҷ����� */
	public Vector<UserDB> selectUserIn(String userId) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT userName, userBirth, userId, userPwd, userTel, userEmail"
					+ " FROM user_info"
					+ " WHERE userId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			rs = ps.executeQuery(); // ����

			// ����� ���� ArrayList����
			Vector<UserDB> list = new Vector<UserDB>();

			// ResultSet�� ��� ����� ArrayList�� ���
			while (rs.next()) {
				UserDB udb = new UserDB();
				udb.setUserName(rs.getString("userName"));
				udb.setUserBirth(rs.getString("userBirth"));
				udb.setUserId(rs.getString("userId"));
				udb.setUserPwd(rs.getString("userPwd"));
				udb.setUserTel(rs.getString("userTel"));
				udb.setUserEmail(rs.getString("userEmail"));
				list.add(udb);
			}
			return list;

		} catch (SQLException e) {
			System.out.println(e + "=> selectUserIn fail");
			e.printStackTrace();
			return null;
		} finally {
			dbClose();
		}

	}
	

}
