package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.ProductDAO;
import shop.model.ProductVO;

public class ProductListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 최근 등록한 상품순으로 상품목록 가져오기
		ProductDAO dao=new ProductDAO();
		
		List<ProductVO> pList=dao.listProducts();
		
		req.setAttribute("prodList", pList);
		
		this.setViewPage("products.jsp");
		this.setRedirect(false);

	}

}
