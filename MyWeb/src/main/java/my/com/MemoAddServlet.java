package my.com;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.util.*;
import java.sql.*;

@WebServlet("/MemoAdd") //url-pattern (���� ���)
public class MemoAddServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String msg=req.getParameter("msg");
		
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			res.sendRedirect("memo/index.html");
			return;
		}
		
		//name,msg���� MemoVO��ü �����ؼ� ����ֱ�.
		MemoVO memo=new MemoVO(0,name,msg, null);
	
		//MemoDAO��ü �����ؼ�
		MemoDAO dao=new MemoDAO();
		//insertMemo(vo��ü)ȣ���ϱ�
		boolean b=dao.insertMemo(memo);
		
		//=> true�� �������� "�Է� ����", false=> "�Է� ����" ����ϱ�
		String str=(b)?"�� ��� ����":"�� ��� ����";
		String loc=(b)?"MemoList":"memo/index.html";
		
		//out.println(str);
		out.println("<script>");
		out.println("alert('"+str+"')");
		out.println("location.href='"+loc+"'");		
		out.println("</script>");
		out.close();
	}

	
	
	
	
	
	
}
