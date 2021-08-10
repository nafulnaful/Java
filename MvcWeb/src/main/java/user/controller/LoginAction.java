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
		//1. ���̵�, ��� �ޱ�
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String saveId=req.getParameter("saveId");//���̵� ���� üũ�ڽ� ��
		//2. ��ȿ�� üũ
		if(userid==null||pwd==null||userid.trim().isEmpty()||pwd.trim().isEmpty()) {
			String str="���̵�� ��й�ȣ�� �Է��ؾ� �ؿ�";
			String loc=req.getContextPath()+"/index.me";
			
			CommonUtil.addMsgLoc(req, str, loc);
			this.setViewPage("msg.jsp");
			this.setRedirect(false);
			return;//���� ���� ���̴� ���ȭ�ϴ°� ���ϴ�
		}
		//3. UserDAOMyBatis��ü ���� loginCheck()ȣ���ϱ�
		UserDAOMyBatis userDao=new UserDAOMyBatis();
		
		try {
			UserVO loginUser=userDao.loginCheck(userid, pwd);
			//loginUser�� null�� �ƴ϶�� => ȸ������ ���� ��.
			//���ܰ� �߻��ߴٸ� => ���� ������ ��
			if(loginUser!=null) {
				//���� ���ͼ� loginUser�� ��������
				HttpSession session=req.getSession();
				session.setAttribute("loginUser", loginUser);
				Cookie ck=new Cookie("uid", loginUser.getUserid());
				if(saveId!=null) {
					//���̵� ���忡 üũ�ߴٸ�
					ck.setMaxAge(7*24*60*60);
				}else {
					ck.setMaxAge(0);//��Ű ����
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






