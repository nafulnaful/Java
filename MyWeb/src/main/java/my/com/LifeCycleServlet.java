package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycleServlet extends HttpServlet{
	
	int count;
	
	public LifeCycleServlet() {
		//super();
		System.out.println("LifeCycleServlet()������....");
	}
	 /**Ŭ���̾�Ʈ ù ��û�� ���� �� �� �ѹ��� ȣ��Ǵ� �޼ҵ�.
     * ������� �ʱ�ȭ ���� �۾��� ���⼭ �Ѵ�.
     * */
	@Override
	public void init() throws ServletException{
		super.init();
		count=0;
		System.out.println("init() ȣ���...");
	}
	
	
	/**service()�޼ҵ�� �����忡 ���� ȣ��Ǵ� �޼ҵ��.
     * ù ��û�� init()ȣ��ǰ� �� �Ŀ� �ٷ� service()�� ȣ��ȴ�.
     * �ι�° ��û���ʹ� init()�� ��ġ�� �ʰ� �ٷ� service()�� ȣ��ȴ�.
     * service()�޼ҵ忡���� ��û �޼ҵ带 �м��ؼ� get����� ��û�̸� doGet()�� ȣ���ϰ�
     * post=> doPost(), put��� => doPut(), delete���=> doDelete() ���� �޼ҵ带 ȣ���Ѵ�.
     * 
     * String method = req.getMethod();
     * if(method.equals("GET")){
     * 		doGet(req,res);
     * }else if(method.equals("POST")){
     * 	    doPost(req,res);
     * }else if(method.equals("DELETE")){
     * 		doDelete(req,res);     * 		
     * }...
     * 
     * */
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		//super.service(req, res);
		System.out.println("service()ȣ���...");
		count++;
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		out.println("<h1> Life Cycle Servlet</h1>");
		out.println("<h1 style='color:red'>"+count+"</h1>");
		
		//���� ���� ���� ������ �̸� �˾Ƴ���
		//�������� ����ϱ�
		Thread tr=Thread.currentThread();
		out.println("<h2>���� ���� ���� ������: "+tr.getName()+"</h2>");
		//���� �޸�
		Runtime rt=Runtime.getRuntime();
		long memory=rt.freeMemory();
		out.println("<h3>��� ���� �޸�: "+memory+"bytes </h3>");
		
		//count�� 10�� �ʰ��ϸ� Garbage Collector�� ȣ���غ���.
		if(count>10) {
			System.gc();
			memory=rt.freeMemory();
			out.println("<hr color='blue'>");
			out.println("<h3>GCȣ���� ��� ���� �޸�: "+memory+"bytes </h3>");
			count=0;
		}
		
		out.close();
	}
	
	/**������ shutdown�� �� �� �ѹ� ȣ��ȴ�. ���������� ����� �� �� �ѹ� ȣ����*/
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy()ȣ���...");
	}

}//////////////////////////////////////







