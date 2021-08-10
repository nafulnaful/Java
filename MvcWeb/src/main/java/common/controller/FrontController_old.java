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
		//1. 클라이언트의 요청 URI를 분석해서 해당 요청을 처리할 SubController(XXXAction) 를 생성하고
		//   execute()를 호출한다.
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
		//execute()는 로직을 수행한 뒤에 뷰페이지, 이동방식을 지정한다.
		
		String viewPage=action.getViewPage();
		boolean isRedirect=action.isRedirect();
		
		if(isRedirect) {
			//redirect방식으로 이동
			response.sendRedirect(viewPage);
		}else {
			//forward방식으로 이동
			System.out.println("viewPage="+viewPage);
			RequestDispatcher disp=request.getRequestDispatcher(viewPage);
			disp.forward(request, response);
			//서버 내부에서 이동. 이 때 request,response를 가져감
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
