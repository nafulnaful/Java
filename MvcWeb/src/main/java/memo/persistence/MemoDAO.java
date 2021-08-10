package memo.persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import memo.domain.MemoVO;
import javax.naming.*;
import javax.sql.*;

//영속성계층(Persistence Layer)
//DAO : Data Access Object
//데이터베이스에 접근해서 CRUD 기능을 수행하는 객체
public class MemoDAO {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public MemoDAO() {
		//ds룩업하기
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/myoracle/tis_shop");
			System.out.println("ds룩업 성공");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	//scott계정에서 
	//grant all on memo to tis_shop; 객체 권한을 tis_shop에게 부여함
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

	/**글번호(PK)로 delete문을 수행하는 메소드*/
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
	/**update문을 수행하는 메소드*/
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
			MemoVO memo=new MemoVO(idx,name,msg,wdate);//하나의 레코드
			arrList.add(memo);
		}//while----
		return arrList;
	}//makeList()-----------------------------------------

	/**select문 where절 글번호로 검색해서 해당글을 가져오는 메소드*/
	public MemoVO selectMemo(int idx) {
		try {
			con =ds.getConnection();
			String sql="select * from scott.memo where idx=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			ArrayList<MemoVO> arrList=makeList(rs);
			//pk로 가져오므로 데이터가 있다면 1개 있음
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

	/**select문 where절  like절 이용
	 * 메모내용(msg)에서 검색어를 찾아 가져오는 메소드
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







