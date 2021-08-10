package my.com;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*������ �ۼ��ϸ� ������ ����ؾ� �Ѵ�.   
 * (1) WEB-INF/web.xml ���Ͽ� ����ϴ� ���
 * (2) Annotation���� ����ϴ� ���=> @WebServlet
 * */
@WebServlet("/Get") //url-pattern�� �ش� ���ؽ�Ʈ ������ unique�ؾ� ��

public class GetServlet extends HttpServlet{
	/*
	 * method����� get����� ���� doGet()�� �������̵� �ؾ� �Ѵ�.
	 * [1] get����� ����ڰ� �Է��� ������ ��ûurl�� ������Ʈ��(query string)���� ���Խ��� �����Ѵ�
	 *     ...?�Ķ���͸�=��&�Ķ���͸�=��&�Ķ���͸�=�� ...
	 * [2] ���,�ֹι�ȣ...���� ���� ���� post������� �����ؾ� �Ѵ�.
	 * [3] get����� ��û���ο� �����͸� ���Խ�Ű�� ������ �������� �����͸� ���۰���..512byte����
	 *     ���� ���Ͼ��ε� ���� �ʿ��ϸ� post����� ����ؾ� �Ѵ�.    
	 * */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=res.getWriter();
		//[1]����ڰ� �Է��� ���� �޾ƺ���.==> req��ü�� �̿��ؼ� �޴´�.
		//String getParameter("��ǲ ����")
		String id=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		
		//[2] ��ȿ�� üũ---
		if(id==null||pwd==null||id.trim().isEmpty()||pwd.trim().isEmpty()) {
			//����ε� ��η� ����������. hello.html���ؼ� �������� �Ѵ�.
			res.sendRedirect("hello.html");
			//hello.html�� ������ �̵��� �Ѵ�. �̵��� �ص� �Ʒ��� �ִ� ������ ��� �����Ѵ�.
			//return���� �ʿ���
			return;
		}
		System.out.println("���⸦ ����...");
		
		//[3]db�� �����ؼ� �ش� ȸ���� �´��� üũ
		pw.println("<h1>Get Test</h1>");
		
		pw.println("<h2>���̵�: "+id+"</h2>");
		pw.println("<h2>��й�ȣ: "+pwd+"</h2>");
		
		pw.close();
	}

}
