package shop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.dao.DAOMyBatis;

public class CartDAOMyBatis extends DAOMyBatis {

	private SqlSession ses;
	private final String NS = "shop.mapper.CartMapper";

	// 특정 회원이 담은 특정 상품이 몇개있는지 가져오는 메소드 (회원번호(idx), 상품번호(pnum))
	public int selectCartByPnum(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.selectOne(NS + ".selectCartByPnum", cartVo);
			return cnt;
		} finally {
			close();
		}
	}// -------------------------------------------------------------------------------------

	/** [장바구니 추가 관련] 특정 상품을 장바구니에 추가 */
	public int addCart(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession();
			// mybatis는 openSession()을 호출하면 수동응로 트랙잭션 관리를 해야 한다.(autocommit이 아님)
			// openSession(true);==>자동 커밋이 됨
			int n = ses.insert(NS + ".addCart", cartVo);
			if (n > 0) {
				ses.commit();
			} else {
				ses.rollback();
			}
			return n;
		} finally {
			close();
		}
	}// ---------------------------------------------

	/** [장바구니 추가 관련] 특정 상품의 수량을 수정 */
	public int updateCartOqty(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession(true);
			// ture주면 auto commit
			int n = ses.update(NS + ".updateCartOqty", cartVo);
			return n;
		} finally {
			close();
		} // ------------------------------------------------------------
	}

	public List<CartVO> getCart(String idx) {
		try {
			ses = this.getSessionFactory().openSession();
			List<CartVO> arr = ses.selectList(NS + ".getCart", idx);
			return arr;
		} finally {
			close();
		}
	}// ----------------------------------------------

}