package common.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FronController
 */
@WebServlet(urlPatterns = { "*.me" }, initParams = {
		@WebInitParam(name = "config", 
value = "C:\\MyJava\\Workspace\\MvcWeb\\src\\main\\webapp\\WEB-INF\\Command.properties") })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> cmdMap = new HashMap<>();
	// Command.properties파일에 설정된 값들을 해쉬맵에 옮길 예정

	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println("init()호출됨...");
		String props = conf.getInitParameter("config");
		System.out.println("props=" + props);

		Properties pr = new Properties();
		try {
			FileReader fr = new FileReader(props);
			pr.load(fr);
			// Command.properties 내용을 Properties로 옮긴다.
			if (fr != null)
				fr.close();
			// System.out.println(pr.getProperty("/index.me"));

			Set<Object> set = pr.keySet();

			for (Object key : set) {
				String cmd = key.toString(); // /index.me, /join.me
				String className = pr.getProperty(cmd);// common.controller.IndexAction,...
				if (className != null) {
					className = className.trim();// 앞 뒤 공백제거
				}
				// className을 인스턴스화
				Class<?> cls = Class.forName(className);
				Object cmdInstance = cls.newInstance();
				// 해당 클래스의 객체를 메모리에 올려준다.
				///////////////////////////////
				cmdMap.put(cmd, cmdInstance);
				////////////////////////////////

			} // for-------
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}//init()---------------------------------------------

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트의 요청 URI를 분석해서 해당 요청을 처리할 SubController(XXXAction) 를 생성하고
		// execute()를 호출한다.
		/*
		 * String cmd=request.getRequestURI(); System.out.println("cmd=="+cmd);//
		 * "/MvcWeb/index.do" String ctx=request.getContextPath(); // "/MvcWeb"; int
		 * len=ctx.length(); //7 cmd=cmd.substring(len);
		 * System.out.println("cmd2=="+cmd);
		 */
		String cmd = request.getServletPath();
		System.out.println("cmd: " + cmd);

		
		////////////////////////////////////////////
		Object instance =cmdMap.get(cmd);
		if(instance==null) {
			System.out.println("Action이 null");
			throw new ServletException("Action이 null입니다");
		}
		System.out.println("instance=="+instance);
		
		AbstractAction action=(AbstractAction)instance;
		/////////////////////////////////////////////////
		try {
			action.execute(request, response);
			// execute()는 로직을 수행한 뒤에 뷰페이지, 이동방식을 지정한다.

			String viewPage = action.getViewPage();
			boolean isRedirect = action.isRedirect();

			if (isRedirect) {
				// redirect방식으로 이동
				response.sendRedirect(viewPage);
			} else {
				// forward방식으로 이동
				System.out.println("viewPage=" + viewPage);
				RequestDispatcher disp = request.getRequestDispatcher(viewPage);
				disp.forward(request, response);
				// 서버 내부에서 이동. 이 때 request,response를 가져감
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}
