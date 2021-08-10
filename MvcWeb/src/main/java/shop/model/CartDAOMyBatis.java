package shop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.dao.DAOMyBatis;

public class CartDAOMyBatis extends DAOMyBatis {

	private SqlSession ses;
	private final String NS = "shop.mapper.CartMapper";

	// Ư�� ȸ���� ���� Ư�� ��ǰ�� ��ִ��� �������� �޼ҵ� (ȸ����ȣ(idx), ��ǰ��ȣ(pnum))
	public int selectCartByPnum(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession();
			int cnt = ses.selectOne(NS + ".selectCartByPnum", cartVo);
			return cnt;
		} finally {
			close();
		}
	}// -------------------------------------------------------------------------------------

	/** [��ٱ��� �߰� ����] Ư�� ��ǰ�� ��ٱ��Ͽ� �߰� */
	public int addCart(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession();
			// mybatis�� openSession()�� ȣ���ϸ� �������� Ʈ����� ������ �ؾ� �Ѵ�.(autocommit�� �ƴ�)
			// openSession(true);==>�ڵ� Ŀ���� ��
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

	/** [��ٱ��� �߰� ����] Ư�� ��ǰ�� ������ ���� */
	public int updateCartOqty(CartVO cartVo) {
		try {
			ses = this.getSessionFactory().openSession(true);
			// ture�ָ� auto commit
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