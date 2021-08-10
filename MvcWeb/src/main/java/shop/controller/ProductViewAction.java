package shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.ProductDAOMyBatis;
import shop.model.ProductVO;

public class ProductViewAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pnum=req.getParameter("pnum");
		if(pnum==null||pnum.trim().isEmpty()) {
			this.setViewPage("index.me");
			this.setRedirect(true);
			return;
		}
		
		ProductDAOMyBatis dao=new ProductDAOMyBatis();
		
		ProductVO item=dao.selectByPnum(pnum);
		System.out.println("item="+item);
		
		req.setAttribute("item", item);
		
		this.setViewPage("shop/productDetail.jsp");
		this.setRedirect(false);
		
	}

}
