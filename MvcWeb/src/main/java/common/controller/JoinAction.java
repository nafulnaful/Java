package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		req.setAttribute("msg", "ȸ������ ó�� �Ϸ�");
		
		this.setViewPage("signup.jsp");
		//this.setRedirect(true);//redirect������� �̵�
		this.setRedirect(false);//forward������� �̵�
	}

}
