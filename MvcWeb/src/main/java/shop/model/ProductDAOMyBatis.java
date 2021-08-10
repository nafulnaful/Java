package shop.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProductDAOMyBatis {

	private SqlSession ses;
	private final String NS="shop.mapper.ProductMapper";
	
	public SqlSessionFactory getSessionFactory() {
		//¼³°èµµ
		String resource="common/config/mybatis-config.xml";
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream(resource);
		}catch (IOException e) {
			e.printStackTrace();			
		}
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		return factory;
	}//
	
	public List<ProductVO> selectByPspec(String pspec){
		try {
			ses=this.getSessionFactory().openSession();
			List<ProductVO> arr=ses.selectList(NS+".selectByPspec", pspec);
			return arr;
		} finally {
			close();
		}
	}//---------------------------------

	private void close() {
		if(ses!=null) ses.close();
	}

	public ProductVO selectByPnum(String pnum) {
		try {
			ses=this.getSessionFactory().openSession();
			ProductVO prod=ses.selectOne(NS+".selectByPnum", pnum);
			return prod;
		} finally {
			close();
		}
	}//--------------------------------
	
}///////////////////////////////////////////////////





