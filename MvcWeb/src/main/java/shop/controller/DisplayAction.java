package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.ProductDAOMyBatis;
import shop.model.ProductVO;

public class DisplayAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ProductDAOMyBatis dao=new ProductDAOMyBatis();
		List<ProductVO> pList=dao.selectByPspec("HIT");
		
		List<ProductVO> pList2=dao.selectByPspec("NEW");
		
		System.out.println(pList2);
		
		req.setAttribute("pspec1", "HIT");
		req.setAttribute("hitList", pList);
		
		req.setAttribute("pspec2", "NEW");
		req.setAttribute("newList", pList2);
		
		
		//this.setViewPage("/shop/mallHit.jsp");
		this.setViewPage("/main.jsp");
		this.setRedirect(false);

	}

}
