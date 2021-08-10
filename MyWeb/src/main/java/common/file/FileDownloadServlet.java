package common.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/FileDown")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		download(request, response);
	}


	private void download(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		// 1. �ٿ�ε� ���� ���ϸ� �ޱ�
		String fname=req.getParameter("filename");
		System.out.println("fname==="+fname);
		
		//2. �ٿ�ε� ���� ������ ������ ����� (application���尴ü=>ServletContextŸ��)
		ServletContext app=req.getServletContext(); 
		String upDir=app.getRealPath("/Upload");
		
		String path=upDir+File.separator+fname;
		System.out.println("path="+path);
		
		//3. Ŭ���̾�Ʈ �ʿ� �ٿ�ε� â�� ��������.
		//res.setContentType("unknown");
		res.setContentType("application/octet-stream");
		//�������� ����ƮŸ���� ���� ǥ���� �� �ִ� �����̸� �ش� �������� ǥ���ϰ�,
		//�� �𸣰ų� ���̳ʸ� �����̶�� �ٿ�ε� â�� ������� �ٿ�ε� �޵��� ó���Ѵ�.
		
		//4. response����� �ٿ�ε���� ���ϸ��� ������ش�
		//����� ����� �� �ִ� charset�� ISO-8859-1
		//fname�� UTF-8�� ���ڵ� ó���Ǿ ���� �Ķ���� (�ѱ��� �� ó����)
		//������� �ѱ��� �״�� ���� �� �����Ƿ� 8859-1�� ó���ؼ� �ѱ���
		String fname_en=new String(fname.getBytes(),"ISO-8859-1");
		
		String str="attachment; filename="+fname_en;
		res.setHeader("Content-Disposition", str);
		
		//5. FileInputStream�� 2�� ��θ� �����ؼ� ��� ����=>���͸�
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(path));
		
		//6. �������� ����� ��½�Ʈ��(ServletOutputStream)�� ���� Ŭ���̾�Ʈ�ʿ� ��������.
		ServletOutputStream sos=res.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		
		byte[] data=new byte[4000];
		
		int n=0;
		while((n=bis.read(data))!=-1) {
			bos.write(data, 0, n);
			bos.flush();
		}
		//7. �ڿ����� �ݳ�
		bos.close();
		sos.close();
		bis.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		download(request, response);
	}

}
