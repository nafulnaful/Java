package common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController_old extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		//1. Ŭ���̾�Ʈ�� ��û URI�� �м��ؼ� �ش� ��û�� ó���� SubController(XXXAction) �� �����ϰ�
		//   execute()�� ȣ���Ѵ�.
		/*
		String cmd=request.getRequestURI();
		System.out.println("cmd=="+cmd);// "/MvcWeb/index.do"
		String ctx=request.getContextPath(); //  "/MvcWeb";
		int len=ctx.length(); //7
		cmd=cmd.substring(len);
		System.out.println("cmd2=="+cmd);
		*/
		String cmd=request.getServletPath();
		System.out.println("cmd: "+cmd);
		
		AbstractAction action=null;
		
		if(cmd.equals("/index.do")) {
			action=new IndexAction();
		}else if(cmd.equals("/join.do")) {
			action=new JoinAction();
		}
		
		
		try {
		action.execute(request, response);
		//execute()�� ������ ������ �ڿ� ��������, �̵������ �����Ѵ�.
		
		String viewPage=action.getViewPage();
		boolean isRedirect=action.isRedirect();
		
		if(isRedirect) {
			//redirect������� �̵�
			response.sendRedirect(viewPage);
		}else {
			//forward������� �̵�
			System.out.println("viewPage="+viewPage);
			RequestDispatcher disp=request.getRequestDispatcher(viewPage);
			disp.forward(request, response);
			//���� ���ο��� �̵�. �� �� request,response�� ������
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
