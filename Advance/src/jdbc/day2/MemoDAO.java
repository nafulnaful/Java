package jdbc.day2;
import java.sql.*;
import java.util.*;
import jdbc.util.DBUtil;

//���Ӽ�����(Presistence Layer)
//DAO : Data AccessObject
//�����ͺ��̽��� �����ؼ� CRUD ����� �����ϴ� ��ü

public class MemoDAO {
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public boolean insertMemo(MemoVO memo) {
		try {
			con=DBUtil.getCon();
			String sql="insert into memo(name,msg,idx,wdate)"
					+" values(?,?,memo_seq.nextval,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1,  memo.getName());
			ps.setString(2,  memo.getMsg());
			int cnt=ps.executeUpdate();
			return (cnt>0)? true:false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {//���Ϲ��� �־ �ݵ�� �����ϰ� �Ѵ�
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
	}
	/**�۹�ȣ(pk)�� delete���� �����ϴ� �޼ҵ�*/
	public boolean deleteMemo(int idx) {
	try {
		con=DBUtil.getCon();
		String sql="delete from memo where idx=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1,  idx);
		int cnt=ps.executeUpdate();
		
		return( cnt>0)? true: false;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally {
		closeAll();
	}
	}
	
	public boolean updateMemo(MemoVO memo) {
	try {
		con=DBUtil.getCon();
		String sql="update memo set name=?,msg=? where idx=?";
		ps=con.prepareStatement(sql);
		ps.setString(1,  memo.getName());
		ps.setString(2,  memo.getMsg());
		ps.setInt(3,  memo.getIdx());
		int cnt=ps.executeUpdate();
		return (cnt>0)? true:false;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}finally{
		closeAll();
	}
	}	
	
	
	public ArrayList<MemoVO> selectMemoAll() {//������ ���ڵ��϶� select���̸� arrylist�� ��´�
		try {
			con=DBUtil.getCon();
			String sql="select idx, name, msg, wdate from memo order by idx desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<MemoVO> arrList=makeList(rs);
			
			return arrList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
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
			MemoVO memo=new MemoVO(idx, name,msg,wdate);//�ϳ��� ���ڵ�(��)
			arrList.add(memo);
		}//while------
		return arrList;
	}
	/**select�� where�� �۹�ȣ�� �˻��ؼ� �ش���� �������� �޼ҵ�*/
	public MemoVO selectMemo(int idx) {//�ϳ��� ���ڵ常 select���϶�
		try {
			con=DBUtil.getCon();
			String sql="select * from memo where idx=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,  idx);
			rs=ps.executeQuery();
			ArrayList<MemoVO> arrList=makeList(rs);
			//pk�� �������Ƿ� �����Ͱ� �ִٸ� 1�� ����
			if(arrList!=null & arrList.size()==1) {
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
	/**select�� where�� like�� �̿�
	 * �޸𳻿�(msg)���� �˻�� ã�� �������� �޼ҵ�
	 * */
	public ArrayList<MemoVO> findMemo(String keyword) {
		try {
			con=DBUtil.getCon();
			String sql="select * from memo where msg like ?";//setString �������� ''�� �ٴ´�
			ps=con.prepareStatement(sql);
			ps.setString(1, "$"+keyword+"$");
			rs=ps.executeQuery();
			return makeList(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll();
		}
	}
}/////////////////////////////////////////////////
