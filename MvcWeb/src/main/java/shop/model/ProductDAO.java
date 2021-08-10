package shop.model;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;

public class ProductDAO {
	
	private DataSource ds;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProductDAO() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/myoracle/tis_shop");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//--------------------------------
	
	/**상위 카테고리 목록 가져오기*/
	public List<CategoryVO> getUpCategory() throws SQLException{
		try {
			con=ds.getConnection();
			String sql="select * from upCategory order by 2";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<CategoryVO> arr=new ArrayList<>();
			while(rs.next()) {
				String upCg_code=rs.getString("upCg_code");
				String upCg_name=rs.getString("upCg_name");
				CategoryVO cvo=new CategoryVO(upCg_code, upCg_name, null, null);
				arr.add(cvo);
			}
			return arr;
		} finally {
			close();
		}
	}//---------------------------------------
	/**하위 카테고리 목록 가져오기
	 * @throws SQLException */
	public List<CategoryVO> getDownCategory(String upCode) 
			throws SQLException {
		try {
			con=ds.getConnection();
			String sql="select * from downCategory where upCg_code=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, upCode);
			rs=ps.executeQuery();
			List<CategoryVO> arr=new ArrayList<>();
			while(rs.next()) {
				String downCg_code=rs.getString("downCg_code");
				String downCg_name=rs.getString("downCg_name");
				CategoryVO cvo=new CategoryVO(upCode, null, downCg_code, downCg_name);
				arr.add(cvo);
			}
			return arr;
		} finally {
			close();
		}
	}//---------------------------------------
	
	public int insertProduct(ProductVO item) throws SQLException{
		try {
			con=ds.getConnection();
			StringBuilder buf=new StringBuilder("insert into product values(")
					.append("product_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?)");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, item.getPname());
			ps.setString(2, item.getPcompany());
			ps.setString(3, item.getPimage1());
			ps.setString(4, item.getPimage2());
			ps.setString(5, item.getPimage3());
			
			ps.setInt(6, item.getPqty());
			ps.setInt(7, item.getPrice());
			ps.setInt(8, item.getSaleprice());
			
			ps.setString(9, item.getPspec());
			ps.setString(10, item.getPcontents());
			
			ps.setInt(11, item.getPoint());
			
			ps.setString(12, item.getDownCg_code());
			ps.setString(13, item.getUpCg_code());
			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}//insertProduct()-------------------------
	
	public List<ProductVO> listProducts() throws SQLException {
		try {
			con =ds.getConnection();
			//String sql="select * from product order by pnum desc";
			String sql="SELECT * FROM PRODUCT P left outer JOIN UPCATEGORY U"
					+ " ON P.UPCG_CODE = U.UPCG_CODE"
					+ " left outer JOIN DOWNCATEGORY D"
					+ " ON P.DOWNCG_CODE = D.DOWNCG_CODE"
					+ " ORDER BY PNUM DESC";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			List<ProductVO> pList=makeList(rs);
			return pList;
		} finally {
			close();
		}
	}//---------------------------------------

	public ProductVO getProduct(String pnum) throws SQLException {
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM PRODUCT P left outer JOIN UPCATEGORY U"
					+ " ON P.UPCG_CODE = U.UPCG_CODE"
					+ " left outer JOIN DOWNCATEGORY D"
					+ " ON P.DOWNCG_CODE = D.DOWNCG_CODE"
					+ " WHERE PNUM=?"
					+ " ORDER BY PNUM DESC";
			ps=con.prepareStatement(sql);
			ps.setString(1, pnum);
			rs=ps.executeQuery();
			
			List<ProductVO> pList=makeList(rs);
			if(pList!=null && pList.size()==1) {
				ProductVO item=pList.get(0);
				return item;
			}
			return null;
		} finally {
			close();
		}
	}//---------------------------------------

	private List<ProductVO> makeList(ResultSet rs) throws SQLException{
		List<ProductVO> arr=new ArrayList<>();
		while(rs.next()) {
			String pnum=rs.getString("pnum");
			String pname=rs.getString("pname");
			String pcompany=rs.getString("pcompany");
			String pimage1=rs.getString("pimage1");
			String pimage2=rs.getString("pimage2");
			String pimage3=rs.getString("pimage3");
			
			int pqty=rs.getInt("pqty");
			int price=rs.getInt("price");
			int saleprice=rs.getInt("saleprice");
			
			String pspec=rs.getString("pspec");
			String pcontents=rs.getString("pcontents");
			
			int point=rs.getInt("point");
			java.sql.Date pindate=rs.getDate("pindate");
			String downCg_code=rs.getString("downCg_code");
			String downCg_name=rs.getString("downCg_name");
			
			String upCg_code=rs.getString("upCg_code");
			String upCg_name=rs.getString("upCg_name");
			
			ProductVO item=new ProductVO(upCg_code,upCg_name,downCg_code, downCg_name,pnum,pname,
				pimage1,pimage2,pimage3,price, saleprice,point,pqty, pspec,pcontents,pcompany,pindate);
			
			arr.add(item);
		}//while------------
		return arr;
	}//---------------------------------------
	
	public int deleteProduct(String pnum) throws SQLException{
		try {
			con=ds.getConnection();
			String sql="delete from product where pnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, pnum);			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}//---------------------------------------
	
	/**상품정보 수정*/
	public int updateProduct(ProductVO item) throws SQLException{
		try {
			con=ds.getConnection();
			StringBuilder buf=new StringBuilder("update product set upCg_code=?, downCg_code=?,")
					.append(" pname=?, pimage1=?, pimage2=?, pimage3=?, price=?, saleprice=?,")
					.append(" pqty=?, point=?, pspec=?, pcontents=?, pcompany=?")
					.append(" where pnum=?");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1, item.getUpCg_code());
			ps.setString(2, item.getDownCg_code());
			ps.setString(3, item.getPname());
			ps.setString(4, item.getPimage1());
			ps.setString(5, item.getPimage2());
			ps.setString(6, item.getPimage3());
			
			ps.setInt(7, item.getPrice());
			ps.setInt(8, item.getSaleprice());
			ps.setInt(9, item.getPqty());
			ps.setInt(10, item.getPoint());
			
			ps.setString(11, item.getPspec());
			ps.setString(12, item.getPcontents());
			ps.setString(13, item.getPcompany());
			ps.setString(14, item.getPnum());
			System.out.println("pnum==="+item.getPnum());
			
			return ps.executeUpdate();
		} finally {
			close();
		}
	}


	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
}
