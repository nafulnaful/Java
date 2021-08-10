package shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import shop.model.ProductDAO;

public class ProductRemoveAction extends AbstractAction {

	@Override 
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. ������ ��ǰ��ȣ(pnum)�� �޾ƿ���
		String pnum=req.getParameter("pnum");
		// 2. ��ȿ�� üũ => prodList.me�� redirect�̵�
		if(pnum==null||pnum.trim().isEmpty()) {
			this.setViewPage("prodList.me");
			this.setRedirect(true);
			return;
		}
		 
		//3. ProductDAO���� deleteProduct(pnum)ȣ��
		ProductDAO dao=new ProductDAO();
		int n=dao.deleteProduct(pnum);
		
		//4. ������ message, loc �� req�� ����
		String str=(n>0)?"���� ����":"���� ����";
		
		req.setAttribute("message", str);
		req.setAttribute("loc", "prodList.me");
		
		this.setViewPage("../msg.jsp");
		this.setRedirect(false);

	}

}
