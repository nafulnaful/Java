package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemoDelete")
public class MemoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		//[1] ������ �۹�ȣ �ޱ�
		String idx=req.getParameter("idx");
		
		//[2] ��ȿ�� üũ 
		if(idx==null||idx.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		}
		//[3] MemoDAO��ü �����ؼ�
		//deleteMemo(�۹�ȣ(int))ȣ���ϱ�
		MemoDAO dao=new MemoDAO();
		boolean b=dao.deleteMemo(Integer.parseInt(idx));
		/*
		String str=(b)?"�� ���� ����":"�� ���� ����";
		String loc="MemoList";
		
		out.println("<script>");
		out.println("alert('"+str+"')");
		out.println("location.href='"+loc+"'");
		out.println("</script>");
		*/
		res.sendRedirect("MemoList");
		out.close();
	}

}




