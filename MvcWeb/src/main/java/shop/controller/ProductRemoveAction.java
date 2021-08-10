package shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.ProductDAO;

public class ProductRemoveAction extends AbstractAction {

	@Override 
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. 삭제할 상품번호(pnum)값 받아오기
		String pnum=req.getParameter("pnum");
		// 2. 유효성 체크 => prodList.me로 redirect이동
		if(pnum==null||pnum.trim().isEmpty()) {
			this.setViewPage("prodList.me");
			this.setRedirect(true);
			return;
		}
		 
		//3. ProductDAO생성 deleteProduct(pnum)호출
		ProductDAO dao=new ProductDAO();
		int n=dao.deleteProduct(pnum);
		
		//4. 실행결과 message, loc 를 req에 저장
		String str=(n>0)?"삭제 성공":"삭제 실패";
		
		req.setAttribute("message", str);
		req.setAttribute("loc", "prodList.me");
		
		this.setViewPage("../msg.jsp");
		this.setRedirect(false);

	}

}
