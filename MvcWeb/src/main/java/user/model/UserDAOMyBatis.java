package user.model;

import org.apache.ibatis.session.SqlSession;

import common.dao.DAOMyBatis;

public class UserDAOMyBatis extends DAOMyBatis{
	
	private final String NS="shop.mapper.UserMapper";
	private SqlSession ses;
	
	public UserVO loginCheck(String userid, String pwd) throws NotUserException{
		UserVO user = this.selectUserById(userid);
		if(user==null) throw new NotUserException(userid+"�� ���̵� �������� �ʽ��ϴ�.");
		if(!pwd.equals(user.getPwd())) throw new NotUserException("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
		return user; 
	}//------------------------------
	
	public UserVO selectUserById(String userid) {
		try {
			ses=this.getSessionFactory().openSession();
			UserVO user=ses.selectOne(NS+".selectUserById", userid);
			return user;
		} finally {
			close();
		}
	}//------------------------------

}
