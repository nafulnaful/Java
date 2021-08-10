package movie.daogroup;

import common.dao.DAOMyBatis;
import movie.vogroup.UserVO;

public class UserDAO extends DAOMyBatis {

	private final String NS="movie.mapper.UserMapper";
	
	// 로그인
	public UserVO login(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			UserVO user = ses.selectOne(NS + ".login", userVo);
			return user;
		}finally {
			close();
		}
	}
	// 회원가입
	public boolean join(UserVO userVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.insert(NS+".join", userVo);
			return this.transaction(cnt);
		}finally {
			close();
		}
	}
	
	// 마이페이지 - 포인트, 예매내역, 상품내역(store)
	
	// qna
	
	// 예매내역 - 영화명, 이미지, 상영관, 시간
	
	
	
}