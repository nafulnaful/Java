package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.CategoryVO;
import shop.model.ProductDAO;
import shop.model.ProductVO;

public class ProductEditFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. 상품번호 받기
		String pnum=req.getParameter("pnum");
		System.out.println("pnum=="+pnum);
		
		//2. 유효성 체크
		if(pnum==null||pnum.trim().isEmpty()) {
			this.setViewPage("prodList.me");
			this.setRedirect(true);
			return;
		}
		
		//3. 상위 카테고리 목록 가져오기
		ProductDAO dao=new ProductDAO();
		List<CategoryVO> arr=dao.getUpCategory();
		
		//4. 상품번호(PK)로 상품정보 가져오기
		ProductVO item=dao.getProduct(pnum);
		
		
		//5. req에 저장
		req.setAttribute("upCgList", arr);
		req.setAttribute("prod", item);
		
		this.setViewPage("prodEdit.jsp");
		this.setRedirect(false);

	}

}
