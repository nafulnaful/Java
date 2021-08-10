package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import shop.model.CartDAOMyBatis;
import shop.model.CartVO;
import user.model.UserVO;

public class CartAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1.��ǰ��ȣ, ���� �ޱ�
		String pnum=req.getParameter("pnum");
		String oqty=req.getParameter("oqty");
		System.out.println(pnum+"/"+oqty);
		//2. ��ȿ�� üũ
		if(pnum==null||oqty==null||pnum.trim().isEmpty()||oqty.trim().isEmpty()) {
			this.setRedirect(true);
			this.setViewPage("../index.me");
			return;
		}
		//�α������� ������ ������ ���ϵ��� ���� ����-------------->Filter�ۼ��ؼ� ���� ����
		//3. ȸ����ȣ �˾Ƴ���
		HttpSession ses=req.getSession();
		UserVO loginUser=(UserVO) ses.getAttribute("loginUSer");
		int idx=loginUser.getIdx();//ȸ����ȣ
		
		CartVO cartVo=new CartVO(null,Integer.parseInt(oqty),String.valueOf(idx),pnum,null);
		
		//4. CartDAOMyBatis����
		CartDAOMyBatis dao=new CartDAOMyBatis();
		
		int count=dao.selectCartByPnum(cartVo);
		System.out.println("count==="+count);
		int n=0;
		if(count==0) {
			//	[2] ���� ��� ��ǰ�̶��=> cart���̺� (insert�� ����)
			 n=dao.addCart(cartVo);
		}else {
			//	[1] ��ٱ��Ͽ� ���� ��ǰ�� �̹� ����ִ� ��ǰ�̶�� => ������ ���� (update�� ����)
			n=dao.updateCartOqty(cartVo);
		}
		
		
		//5. ȸ���� ��ٱ��� ��� �����ͼ� req�� �����ϱ�
		List<CartVO> cartArr=dao.getCart(idx+"");
		
		req.setAttribute("cartArr", cartArr);
		
		this.setViewPage("cartList.jsp");
		this.setRedirect(false);
	}

}
