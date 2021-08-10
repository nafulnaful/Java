package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.CategoryVO;
import shop.model.ProductDAO;

public class DownCategoryListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String upCode=req.getParameter("upCode");
		System.out.println("upCode="+upCode);
		
		//상위 카테고리에 해당하는 하위 카테고리 목록 가져오기
		ProductDAO dao=new ProductDAO();
		List<CategoryVO> dList=dao.getDownCategory(upCode);
		
		req.setAttribute("downCgList", dList);
		req.setAttribute("upCode", upCode);
		
		this.setViewPage("/shop/downCategory.jsp");
		this.setRedirect(false);
	}

}
