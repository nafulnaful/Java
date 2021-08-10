package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String sql="SELECT * FROM user_info"
					+" WHERE userId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id.trim());
			rs=ps.executeQuery();//����
			
			if(rs.next()) {
				result=false; //���̵� �ߺ��Ǹ� false
			}
		}catch(SQLException e) {
			System.out.println(e+"=> ExistUser fail");
		}finally {
			dbClose();
		}
		return result;
	}//ExistUser()-------------------
	
	/**�������� insert*/
	public boolean insertUser(UserDB user) {//ȸ������
		try
		{
			System.out.println("����");
			con =DBUtil.getCon();
			String sql="INSERT INTO user_info"
					+" VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserBirth());
			ps.setString(3, user.getUserId());
			ps.setString(4, user.getUserPwd());
			ps.setString(5, user.getUserTel());
			ps.setString(6, user.getUserEmail());
			
			int result=ps.executeUpdate(); //���� -> ����
			System.out.println("����Ʈ!!"+user.getUserName());
			System.out.println(result);
			return (result>0)? true:false;
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
	
	/** select user_info ȸ������ �����Ҷ�*/
	public UserDB selectUser(String userId)
	{
		try {
			con=DBUtil.getCon();
			String sql="select * from user_info where userid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs=ps.executeQuery();
			
			ArrayList<UserDB> arrList=makeList(rs);
			
			if(arrList!=null && arrList.size()==1) {
				UserDB userd=arrList.get(0);
				return userd;
			}
			
			return null;
		} catch (SQLException e) {
			System.out.println("selectUser() ����: "+e);
		} finally {
			dbClose();
		}
		return null;
	}

	private ArrayList<UserDB> makeList(ResultSet rs) throws SQLException
	{
		con=DBUtil.getCon();
		ArrayList<UserDB> arrList=new ArrayList<>();
		while(rs.next()) {
			String name=rs.getString("userName");
			String birth=rs.getString("userBirth");
			String pwd=rs.getString("userPwd");
			String tel=rs.getString("userTel");
			String email=rs.getString("userEmail");
			String id=rs.getString("userId");
			UserDB userd=new UserDB(name, birth, id, pwd, tel, email);
			arrList.add(userd);
			
		}
		return arrList;
		
	}
	
}
