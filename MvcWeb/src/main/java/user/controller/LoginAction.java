package user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.NotUserException;
import user.model.UserDAOMyBatis;
import user.model.UserVO;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 아이디, 비번 받기
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String saveId=req.getParameter("saveId");//아이디 저장 체크박스 값
		//2. 유효성 체크
		if(userid==null||pwd==null||userid.trim().isEmpty()||pwd.trim().isEmpty()) {
			String str="아이디와 비밀번호를 입력해야 해요";
			String loc=req.getContextPath()+"/index.me";
			
			CommonUtil.addMsgLoc(req, str, loc);
			this.setViewPage("msg.jsp");
			this.setRedirect(false);
			return;//자주 쓰는 아이는 모듈화하는게 편하다
		}
		//3. UserDAOMyBatis객체 생성 loginCheck()호출하기
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		
		try {
			UserVO loginUser=userDao.loginCheck(userid, pwd);
			//loginUser가 null이 아니라면 => 회원인증 받은 것.
			//예외가 발생했다면 => 인증 못받은 것
			if(loginUser!=null) {
				//세션 얻어와서 loginUser를 저장하자
				HttpSession session=req.getSession();
				session.setAttribute("loginUser", loginUser);
				Cookie ck=new Cookie("uid", loginUser.getUserid());
				if(saveId!=null) {
					//아이디 저장에 체크했다면
					ck.setMaxAge(7*24*60*60);
				}else {
					ck.setMaxAge(0);//쿠키 삭제
				}
				ck.setPath("/");
				res.addCookie(ck);
				
				String loc=req.getContextPath()+"/index.me";
				this.setViewPage(loc);
				this.setRedirect(true);
			}
		
		}catch(NotUserException e) {
			String str=e.getMessage();
			String loc=req.getContextPath()+"/index.me";
			CommonUtil.addMsgLoc(req, str, loc);
			this.setRedirect(false);
			this.setViewPage("/msg.jsp");
			
		}
		
	}

}






