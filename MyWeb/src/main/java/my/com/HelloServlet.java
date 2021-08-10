package my.com;

import javax.servlet.*; //servlet-api.jar
import javax.servlet.http.*;
import java.io.*;
//Servlet: Server Side Applet
//Servlet Container(WAS)���� ����Ǵ� �� ���ø����̼�
//HttpServletŬ������ ��ӹ޾ƾ� ��
//get��� ��û==> doGet()�޼ҵ带 �������̵� �ؾ� ��
//post��� ��û ==> doPost()�޼ҵ带 �������̵� �ؾ� ��
//������ �����Ű�� ���ؼ���
//[1] MyWeb/WEB-INF/web.xml�� �ش� ������ ����� ���ִ���
/*
 <!-- ���� ��� ====================== -->
  <servlet>
  	<servlet-name>HelloServlet</servlet-name>
  	<servlet-class>my.com.HelloServlet</servlet-class>
  </servlet> 
  <servlet-mapping>
  	<servlet-name>HelloServlet</servlet-name>
  	<url-pattern>/Hello</url-pattern>
  </servlet-mapping>
  
 */


//[2] @WebServlet()�̶�� ������̼��� �ٿ��ִ��� �ؾ� �Ѵ�.

public class HelloServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Hello Servlet</h1>");
		pw.println("<h2>�ȳ� ����</h1>");
		pw.println("</body></html>");
		pw.close();
	}

}
