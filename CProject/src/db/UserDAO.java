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
	
	private Connection con; //데이터베이스에 접근하게 해주는 객체
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs; //정보를 담을 수 있음
	
	
	public UserDAO() {
		
	}
	
	/**DB닫기 기능 메소드*/
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(ps!=null) ps.close();
		} catch (Exception e) {
			System.out.println(e+"=> dbClose fail");
		}
	}//dbClose()---
	
	/**아이디 중복 체크*/
	public boolean ExistUser(String id) {
		boolean result = true;
		try
		{
			con=DBUtil.getCon();
			String sql="SELECT * FROM user_info"
					+" WHERE userId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id.trim());
			rs=ps.executeQuery();//실행
			
			if(rs.next()) {
				result=false; //아이디 중복되면 false
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}//ExistUser()-------------------
	
	/**유저정보 insert*/
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
			
			ps.executeUpdate(); //실행 -> 저장
			return true;
		}catch(Exception e) {
			System.out.println(e+"=> insertUser fail");
			return false;
		}finally {
			dbClose();
		}
		
	}//insertUser()-------------------	
	
	/**유저정보 update*/
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
			
			result=ps.executeUpdate(); //실행
			
		}catch(SQLException e) {
			System.out.println(e+"=> updateUser fail");
		}finally {
			dbClose();
		}
		
		return result;
	}//updateUser()----------------------
	
	/**유저정보 delete*/
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
	
	/**로그인 체크*/
	public int loginCheck(String userId, String userPwd) {
		
		try {
			con=DBUtil.getCon();
			String SQL="SELECT userPwd FROM user_info WHERE userId=?";
			ps=con.prepareStatement(SQL);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			
			//로그인 함수 만들기
			if(rs.next()) {
				if(rs.getString(1).contentEquals(userPwd)) {
					return 1; //로그인
				}else {
				return 0; //비밀번호가 틀렸습니다.
				}
			}//if---
			return -1; //아이디가 없습니다.
		} catch (Exception e) {
			System.out.println("로그인 유효성 예외: "+e.getMessage());
		}
		return -2; //DB오류 나타냄
	}//loginCheck()------------------------
	
	/** 회원정보수정 selectUserIn: 아이디로 정보 불러오기 */
	public Vector<UserDB> selectUserIn(String userId) {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT userName, userBirth, userId, userPwd, userTel, userEmail"
					+ " FROM user_info"
					+ " WHERE userId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			rs = ps.executeQuery(); // 실행

			// 결과를 담을 ArrayList생성
			Vector<UserDB> list = new Vector<UserDB>();

			// ResultSet에 담긴 결과를 ArrayList에 담기
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
