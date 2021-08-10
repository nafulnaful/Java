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
	// Command.properties���Ͽ� ������ ������ �ؽ��ʿ� �ű� ����

	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println("init()ȣ���...");
		String props = conf.getInitParameter("config");
		System.out.println("props=" + props);

		Properties pr = new Properties();
		try {
			FileReader fr = new FileReader(props);
			pr.load(fr);
			// Command.properties ������ Properties�� �ű��.
			if (fr != null)
				fr.close();
			// System.out.println(pr.getProperty("/index.me"));

			Set<Object> set = pr.keySet();

			for (Object key : set) {
				String cmd = key.toString(); // /index.me, /join.me
				String className = pr.getProperty(cmd);// common.controller.IndexAction,...
				if (className != null) {
					className = className.trim();// �� �� ��������
				}
				// className�� �ν��Ͻ�ȭ
				Class<?> cls = Class.forName(className);
				Object cmdInstance = cls.newInstance();
				// �ش� Ŭ������ ��ü�� �޸𸮿� �÷��ش�.
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
		// 1. Ŭ���̾�Ʈ�� ��û URI�� �м��ؼ� �ش� ��û�� ó���� SubController(XXXAction) �� �����ϰ�
		// execute()�� ȣ���Ѵ�.
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
			System.out.println("Action�� null");
			throw new ServletException("Action�� null�Դϴ�");
		}
		System.out.println("instance=="+instance);
		
		AbstractAction action=(AbstractAction)instance;
		/////////////////////////////////////////////////
		try {
			action.execute(request, response);
			// execute()�� ������ ������ �ڿ� ��������, �̵������ �����Ѵ�.

			String viewPage = action.getViewPage();
			boolean isRedirect = action.isRedirect();

			if (isRedirect) {
				// redirect������� �̵�
				response.sendRedirect(viewPage);
			} else {
				// forward������� �̵�
				System.out.println("viewPage=" + viewPage);
				RequestDispatcher disp = request.getRequestDispatcher(viewPage);
				disp.forward(request, response);
				// ���� ���ο��� �̵�. �� �� request,response�� ������
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
