package common.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAOMyBatis {
	
	protected SqlSession ses;//��ӹ��� �ڽĿ��Ե� ���� �ҷ��� protected

	public SqlSessionFactory getSessionFactory() {
		//���赵
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
		if(ses!=null) ses.close();
	}
}
