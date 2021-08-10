package user.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.pool.ConnectionPoolBean;
import jdbc.util.DAOBase;
import jdbc.util.DBUtil;
import user.domain.UserVO;

public class UserDAO extends DAOBase{
	
	//private ConnectionPoolBean pool;//property
	
	
	public UserDAO() {
		super(); // ds����� ������
		System.out.println("UserDAO()������...");
	}
	
	
//	public ConnectionPoolBean getPool() {
//		return pool;
//	}
//
//	public void setPool(ConnectionPoolBean pool) {
//		this.pool = pool;
//	}




	/**���̵� �ߺ� üũ -SELECT�� ����
	 * WHERE���� USERID�� PK(IDX)�� �����´�
	 * RS�� Ŀ���� �̵����� �� TRUE��ȯ�ϸ� "�ش� ���̵�� �̹� ����==>FALSE�� ��ȯ"
	 * 					  FALSE�� ��ȯ�ϸ� "�ش� ���̵�� ����"==>TRUE�� ��ȯ
	 *  */
	public boolean idCheck(String userid) throws SQLException{
		try {
			//con=DBUtil.getCon();
			//con=pool.getConnection();//Ŀ�ؼ�Ǯ�κ��� �̹� �غ�� Ŀ�ؼ��� �޾ƿ���
			con=ds.getConnection();
			String sql="select idx from member where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			boolean b=rs.next(); //true�� ��ȯ�ϸ� �ش� ���̵� ����
			return !b;
		}finally {
			super.close();
		}
	}
	
//	public void close() {
//		try {
//			if(rs!=null) rs.close();
//			if(ps!=null) ps.close();
//			if(con!=null) pool.returnConnection(con);//con.close()�� �ƴ϶�
//			//Ŀ�ؼ� Ǯ�� �ݳ��� �Ѵ�.
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	/**ȸ������-INSERT�� ����
	 * ȸ����ȣ: MEMBER_SEQ�������� �̿�
	 * �����: SYSDATE�Լ� ���
	 * */
	public int createUser(UserVO user) throws SQLException{
		try {
			//con=DBUtil.getCon();
			//con=pool.getConnection();
			con=ds.getConnection();//DBCPĿ�ؼ� Ǯ���� Ŀ�ؼ� ������
			
			String sql="insert into member values(member_seq.nextval,"
					+"?,?,?,?,?,?,?,?,?,sysdate,1000,0)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getHp1());
			ps.setString(5, user.getHp2());
			ps.setString(6, user.getHp3());
			ps.setString(7, user.getZipcode());
			ps.setString(8, user.getAddr1());
			ps.setString(9, user.getAddr2());
			return ps.executeUpdate();
		}finally {
			close();
		}
	}//-------------------------------------
	/**�� ȸ���� ���ϱ�*/
	public int getTotalUser() throws SQLException{
		try {
			//con=DBUtil.getCon();
			//con=pool.getConnection();
			con=ds.getConnection();
			String sql="select count(idx) from member";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			boolean b=rs.next();
			int cnt=0;
			if(b) {
				cnt=rs.getInt(1);
			}
			return cnt;
		} finally {
			close();
		}
	}//-------------------------------------
	/** �˻��� �� ȸ���� ���ϱ�*/
	public int getTotalUser(String type, String keyword) throws SQLException{
		try {
			String colName="";
			switch(type) {
			case "1": colName="name"; 
				break;
			case "2":  colName="userid";
				break;
			case "3":  colName="hp1||hp2||hp3";
				break;
			}
			
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="select count(idx) from member where "+colName+" like ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			boolean b=rs.next();
			int cnt=0;
			if(b) {
				cnt=rs.getInt(1);
			}
			return cnt;
		} finally {
			close();
		}
	}//-------------------------------------
	
	public List<UserVO> listUser() throws SQLException{
		try {
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="SELECT * FROM MEMBER ORDER BY IDX DESC";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<UserVO> arr=makeList(rs);
			return arr;
		}finally {
			close();
		}
	}//-------------------------------------
	public List<UserVO> listUser(int start, int end) throws SQLException{
		try {
			//con=DBUtil.getCon();
			//con=pool.getConnection();
			con=ds.getConnection();
			String sql="select * from("
					+ "    select rownum rn, a.* from("
					+ "    (select * from member order by idx desc) a"
					+ "    )"
					+ " ) where rn between ? and ?";
			
			ps= con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs=ps.executeQuery();
			List<UserVO> arr=makeList(rs);
			return arr;
		}finally {
			close();
		}
	}//-------------------------------------

	private List<UserVO> makeList(ResultSet rs) throws SQLException{
		List<UserVO> arr=new ArrayList<>();
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String userid=rs.getString("userid");
			String pwd=rs.getString("pwd");
			String hp1=rs.getString("hp1");
			String hp2=rs.getString("hp2");
			String hp3=rs.getString("hp3");
			String zipcode=rs.getString("zipcode");
			String addr1=rs.getString("addr1");
			String addr2=rs.getString("addr2");
			java.sql.Date indate=rs.getDate("indate");
			int mileage=rs.getInt("mileage");
			int mstate=rs.getInt("mstate");
			UserVO user
			=new UserVO(idx,name,userid,pwd,hp1,hp2,hp3,
					zipcode,addr1, addr2,indate,mileage,mstate);
			arr.add(user);
		}//while-------------
		return arr;
	}//-------------------------------------
	/**ȸ����ȣ(idx- pk)�� ȸ������ ��������*/
	public UserVO selectUser(String idx) throws SQLException{
		try {
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="select * from member where idx=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, idx);
			rs=ps.executeQuery();
			
			List<UserVO> arr=makeList(rs);
			if(arr!=null && arr.size()==1) {
				UserVO user=arr.get(0);
				return user;
			}
			return null;			
		} finally {
			close();
		}
	}//-------------------------------------
	
	public int updateUser(UserVO user) throws SQLException{
		try {
					//con=DBUtil.getCon();
				//	String sql="update member set name=?, userid=?, pwd=?, hp1=?, hp2=?, hp3=?";
				//		   sql+=" , zipcode=?, addr1=?, addr2=?, mstate=? where idx=?";
				con=ds.getConnection();
					StringBuilder buf
					=new StringBuilder("update member set name=?, userid=?, pwd=?, hp1=?, hp2=?, hp3=?");
					buf.append(" , zipcode=?, addr1=?, addr2=?, mstate=? where idx=?");
					
					 	

					String sql=buf.toString();
				   //String�� ������ �������� ����. immutable(�Һ���)
				   //���ڿ��� �߰�,����, ���� ���� �۾��� �ؾ� �� ����
				   //StringBuffer/StringBuilder Ŭ������ �̿��ؼ� ���ڿ��� ������ �ڿ�
				   //toString()�޼ҵ带 �̿��ؼ� String���� ���������� ����� ����Ѵ�.
					ps=con.prepareStatement(sql);
					ps.setString(1, user.getName());
					ps.setString(2, user.getUserid());
					ps.setString(3, user.getPwd());
					ps.setString(4, user.getHp1());
					ps.setString(5, user.getHp2());
					ps.setString(6, user.getHp3());
					ps.setString(7, user.getZipcode());
					ps.setString(8, user.getAddr1());
					ps.setString(9, user.getAddr2());
					ps.setInt(10, user.getMstate());
					ps.setInt(11, user.getIdx());
					
					int n=ps.executeUpdate();
					return n;
		}finally {
			close();
		}
	}//---------------------
	
	/**PK�� ȸ������ ���� ó��*/
	public int deleteUser(String idx)  throws SQLException{
		try{
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="delete from member where idx=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, idx);
			int n=ps.executeUpdate();
			return n;
		}finally {
			close();
		}
	}//---------------------
	
	/**ȸ������ �˻� - where ���� like�� ���*/
	public List<UserVO> findUser(String type, String keyword)
	throws SQLException{
		try {
			String colName="";
			switch(type) {
			case "1": colName="name";
				break;
			case "2": colName="userid";
				break;
			case "3": colName="hp1||hp2||hp3";
				break;
			}
			//con =DBUtil.getCon();
			con=ds.getConnection();
			String sql="select * from member where "+colName+" like ?";
			
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			return makeList(rs);
		}finally {
			close();
		}
	}//-----------------------
	
	/**ȸ������ �˻� - where ���� like�� ���, ����¡ ó�� �߰�*/
	public List<UserVO> findUser(String type, String keyword, int start, int end)
	throws SQLException{
		try {
			String colName="";
			switch(type) {
			case "1": colName="name";
				break;
			case "2": colName="userid";
				break;
			case "3": colName="hp1||hp2||hp3";
				break;
			}
			//con =DBUtil.getCon();
			//String sql="select * from member where "+colName+" like ?";
			con=ds.getConnection();
			String sql="select * from( "
					+ "    select rownum rn, a.* from( "
					+ "    (select * from member  "
					+ "    where "+colName+" like ? "
					+ "    order by idx desc) a "
					+ "    ) "
					+ ") where rn between ? and ?";
			
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			rs=ps.executeQuery();
			return makeList(rs);
		}finally {
			close();
		}
	}//-----------------------
	
	/**�α��� üũ*/
	public UserVO loginCheck(String id, String pwd) 
			throws SQLException,NotUserException{
		UserVO user = this.selectUserById(id);
		if(user==null) {
			//���̵� �������� �ʴ� ��� ==> ���� �߻� ����
			throw new NotUserException(id+"�� ���̵�� �������� �ʾƿ�"); 
		}
		
		//��� üũ
		String dbPwd=user.getPwd();
		if(!pwd.equals(dbPwd)) {
			//��� ����ġ���
			throw new NotUserException("��й�ȣ�� ��ġ���� �ʾƿ�");
		}
		
		//ȸ���� �´ٸ�
		return user;		
	}

	/*Ż��ȸ��(-1)�� ������ �Ϲ�ȸ��(0), ����ȸ��(1)���� �����͸� ������ �ִ� member_view��
	 * ���� �α��� üũ�� ����.
	 * create or replace view member_view
	 * as
	 * select * from member where mstate>-1;
	 * */
	public UserVO selectUserById(String id)  throws SQLException{
		try {
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="select * from member_view where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			List<UserVO> arr=this.makeList(rs);
			
			if(arr!=null && arr.size()==1) {
				UserVO user=arr.get(0);
				return user;
			}
			return null;			
		} finally {
			close();
		}
	}//-------------------------------
	public List<UserVO> zipCheck(String zipcode) throws SQLException {
		try {
			//con=DBUtil.getCon();
			con=ds.getConnection();
			String sql="select * from zipcode where doro_kor||bld_origin_num like ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+zipcode+"%");			
			rs=ps.executeQuery();
			List<UserVO> arr=this.makeZiplist(rs);						
			return arr;
		} finally {
			close();
		}
	}
	
	private List<UserVO> makeZiplist(ResultSet rs) throws SQLException {
		List<UserVO> arr=new ArrayList<>();
		while(rs.next()) {
			String zipcode=rs.getString("new_post_code");
			String addr1=rs.getString("sido_kor");
			String addr2=rs.getString("sigungu_kor");
			String addr3=rs.getString("doro_kor");
			String addr4=rs.getString("bld_origin_num");
			if(addr2==null) {
				addr2="";
			}
			
			UserVO user=new UserVO();
			user.setZipcode(zipcode);
			user.setAddr1(addr1+" "+addr2+" "+addr3+" "+addr4);
			System.out.println(user.getAddr1());
			arr.add(user);
		}//while-------------
		return arr;
	}
}//////////////////////////////////












