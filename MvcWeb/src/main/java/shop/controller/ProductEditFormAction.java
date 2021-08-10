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
		// 1. ��ǰ��ȣ �ޱ�
		String pnum=req.getParameter("pnum");
		System.out.println("pnum=="+pnum);
		
		//2. ��ȿ�� üũ
		if(pnum==null||pnum.trim().isEmpty()) {
			this.setViewPage("prodList.me");
			this.setRedirect(true);
			return;
		}
		
		//3. ���� ī�װ� ��� ��������
		ProductDAO dao=new ProductDAO();
		List<CategoryVO> arr=dao.getUpCategory();
		
		//4. ��ǰ��ȣ(PK)�� ��ǰ���� ��������
		ProductVO item=dao.getProduct(pnum);
		
		
		//5. req�� ����
		req.setAttribute("upCgList", arr);
		req.setAttribute("prod", item);
		
		this.setViewPage("prodEdit.jsp");
		this.setRedirect(false);

	}

}
