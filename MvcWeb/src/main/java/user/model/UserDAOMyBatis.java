package user.model;

import org.apache.ibatis.session.SqlSession;

import common.dao.DAOMyBatis;

public class UserDAOMyBatis extends DAOMyBatis{
	
	private final String NS="shop.mapper.UserMapper";
	private SqlSession ses;
	
	public UserVO loginCheck(String userid, String pwd) throws NotUserException{
		UserVO user = this.selectUserById(userid);
		if(user==null) throw new NotUserException(userid+"란 아이디가 존재하지 않습니다.");
		if(!pwd.equals(user.getPwd())) throw new NotUserException("비밀번호가 일치하지 않습니다");
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
