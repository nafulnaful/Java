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
		// �ֱ� ����� ��ǰ������ ��ǰ��� ��������
		ProductDAO dao=new ProductDAO();
		
		List<ProductVO> pList=dao.listProducts();
		
		req.setAttribute("prodList", pList);
		
		this.setViewPage("products.jsp");
		this.setRedirect(false);

	}

}
