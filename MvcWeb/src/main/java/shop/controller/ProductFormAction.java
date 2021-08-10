package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.controller.AbstractAction;
import shop.model.CategoryVO;
import shop.model.ProductDAO;

public class ProductFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//���� ī�װ� ��� ��������
		ProductDAO dao=new ProductDAO();
		List<CategoryVO> upCgList=dao.getUpCategory();
		System.out.println(upCgList);
		
		req.setAttribute("upCgList", upCgList);
		
		this.setViewPage("/admin/prodForm.jsp");
		this.setRedirect(false);

	}

}
