package memo.persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import memo.domain.MemoVO;
import javax.naming.*;
import javax.sql.*;

//���Ӽ�����(Persistence Layer)
//DAO : Data Access Object
//�����ͺ��̽��� �����ؼ� CRUD ����� �����ϴ� ��ü
public class MemoDAO {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public MemoDAO() {
		//ds����ϱ�
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/myoracle/tis_shop");
			System.out.println("ds��� ����");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	//scott�������� 
	//grant all on memo to tis_shop; ��ü ������ tis_shop���� �ο���
	//grant all on memo_seq to tis_shop; 
	public boolean insertMemo(MemoVO memo) {
		try {			
			con=ds.getConnection();
			String sql="insert into scott.memo(name,msg,idx,wdate)"
					+" values(?,?,scott.memo_seq.nextval,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			int cnt=ps.executeUpdate();
			return (cnt>0)? true:false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll();
		}
	}
	
	private void closeAll() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//----------------------------------

	/**�۹�ȣ(PK)�� delete���� �����ϴ� �޼ҵ�*/
	public boolean deleteMemo(int idx) {
		 try {
			 con=ds.getConnection();
			 String sql="delete from scott.memo where idx=?";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, idx);
			 int cnt=ps.executeUpdate();
			 return (cnt>0)? true: false;
		 }catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll();
		}
	}//----------------------------------
	/**update���� �����ϴ� �޼ҵ�*/
	public boolean updateMemo(MemoVO memo) {
		try {
			con=ds.getConnection();
			String sql="update scott.memo set name=?, msg=? where idx=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			ps.setInt(3, memo.getIdx());
			int cnt=ps.executeUpdate();
			return (cnt>0)? true: false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll();
		}
	}//----------------------------------
	
	public ArrayList<MemoVO> selectMemoAll() {
		try {
			con=ds.getConnection();
			String sql="select idx, name, msg, wdate from scott.memo order by idx desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<MemoVO> arrList=makeList(rs);
			
			return arrList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll();
		}
	}//selectMemoAll()--------------------

	private ArrayList<MemoVO> makeList(ResultSet rs) throws SQLException {
		ArrayList<MemoVO> arrList=new ArrayList<>();
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			java.sql.Date wdate=rs.getDate("wdate");
			MemoVO memo=new MemoVO(idx,name,msg,wdate);//�ϳ��� ���ڵ�
			arrList.add(memo);
		}//while----
		return arrList;
	}//makeList()-----------------------------------------

	/**select�� where�� �۹�ȣ�� �˻��ؼ� �ش���� �������� �޼ҵ�*/
	public MemoVO selectMemo(int idx) {
		try {
			con =ds.getConnection();
			String sql="select * from scott.memo where idx=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			ArrayList<MemoVO> arrList=makeList(rs);
			//pk�� �������Ƿ� �����Ͱ� �ִٸ� 1�� ����
			if(arrList!=null && arrList.size()==1) {
				MemoVO memo=arrList.get(0);
				return memo;
			}
			return null;			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll();
		}

	}

	/**select�� where��  like�� �̿�
	 * �޸𳻿�(msg)���� �˻�� ã�� �������� �޼ҵ�
	 * */
	public ArrayList<MemoVO> findMemo(String keyword) {
		try {
			con=ds.getConnection();
			String sql="select * from scott.memo where msg like ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			return makeList(rs);			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll();
		}
	}
}////////////////////////////////////////////////////////////







