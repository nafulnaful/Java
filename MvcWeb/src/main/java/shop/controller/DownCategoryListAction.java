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
		
		//���� ī�װ��� �ش��ϴ� ���� ī�װ� ��� ��������
		ProductDAO dao=new ProductDAO();
		List<CategoryVO> dList=dao.getDownCategory(upCode);
		
		req.setAttribute("downCgList", dList);
		req.setAttribute("upCode", upCode);
		
		this.setViewPage("/shop/downCategory.jsp");
		this.setRedirect(false);
	}

}
