package common.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAOMyBatis {
	
	protected SqlSession ses;
	
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
	
	
	public void close() {
		if(ses != null) {
			ses.close();
		}
	}
	
	public boolean transaction(int n) {
		if(n>0) {
			ses.commit();
			return true;
		} else {
			ses.rollback();
			return false;
		}
	}
}
