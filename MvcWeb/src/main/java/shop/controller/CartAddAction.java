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
		// 1.상품번호, 수량 받기
		String pnum=req.getParameter("pnum");
		String oqty=req.getParameter("oqty");
		System.out.println(pnum+"/"+oqty);
		//2. 유효성 체크
		if(pnum==null||oqty==null||pnum.trim().isEmpty()||oqty.trim().isEmpty()) {
			this.setRedirect(true);
			this.setViewPage("../index.me");
			return;
		}
		//로그인하지 않으면 들어오지 못하도록 막을 예정-------------->Filter작성해서 막을 예정
		//3. 회원번호 알아내기
		HttpSession ses=req.getSession();
		UserVO loginUser=(UserVO) ses.getAttribute("loginUSer");
		int idx=loginUser.getIdx();//회원번호
		
		CartVO cartVo=new CartVO(null,Integer.parseInt(oqty),String.valueOf(idx),pnum,null);
		
		//4. CartDAOMyBatis생성
		CartDAOMyBatis dao=new CartDAOMyBatis();
		
		int count=dao.selectCartByPnum(cartVo);
		System.out.println("count==="+count);
		int n=0;
		if(count==0) {
			//	[2] 새로 담는 상품이라면=> cart테이블에 (insert문 수행)
			 n=dao.addCart(cartVo);
		}else {
			//	[1] 장바구니에 담은 상품이 이미 담겨있는 상품이라면 => 수량만 수정 (update문 수행)
			n=dao.updateCartOqty(cartVo);
		}
		
		
		//5. 회원의 장바구니 목록 가져와서 req에 저장하기
		List<CartVO> cartArr=dao.getCart(idx+"");
		
		req.setAttribute("cartArr", cartArr);
		
		this.setViewPage("cartList.jsp");
		this.setRedirect(false);
	}

}
