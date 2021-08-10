package shop.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SampleDAOMyBatis {
	
	//어떤 mapper를 사용할지 지정(네임스페이스 지정 필수)
	private final String NS="shop.mapper.SampleMapper";
	private SqlSession ses;
	
	public SqlSessionFactory getSessionFactory() {
		//설계도
		String resource="common/config/mybatis-config.xml";
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream(resource);
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			return factory;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}//
	
	public int getTableCount() {
		ses=this.getSessionFactory().openSession();
		int count=ses.selectOne(NS+".totalCount");
		if(ses!=null) ses.close();
		return count;
	}
	
}
