package movie.daogroup;

import common.dao.DAOMyBatis;
import movie.vogroup.UserVO;

public class UserDAO extends DAOMyBatis {

	private final String NS="movie.mapper.UserMapper";
	
	// �α���
	public UserVO login(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			UserVO user = ses.selectOne(NS + ".login", userVo);
			return user;
		}finally {
			close();
		}
	}
	// ȸ������
	public boolean join(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".join", userVo);
			return this.transaction(cnt);
		}finally {
			close();
		}
	}
	
	// ���������� - ����Ʈ, ���ų���, ��ǰ����(store)
	
	// qna
	
	// ���ų��� - ��ȭ��, �̹���, �󿵰�, �ð�
	
	
	
}