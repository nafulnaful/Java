package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;

public class LogoutAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		//세션 얻어오기
		HttpSession session=req.getSession();
		
		//세션변수 모두 무효화
		session.invalidate();
		
		String loc=req.getContextPath()+"/index.me";
		this.setRedirect(true);
		this.setViewPage(loc);
		
	}

}
