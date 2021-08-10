package shop.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.controller.AbstractAction;
import shop.model.ProductDAO;
import shop.model.ProductVO;

public class ProductEditAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. ��ǰ�̹��� ���ε� ó��-���ε��� ���丮�� ������ ���ϱ�
				//application.getRealPath("/product_images");
				ServletContext app=req.getServletContext();
				String upDir=app.getRealPath("/product_images");
				System.out.println(upDir);
				
				//2. cos.jar�� MultipartRequest�� ����
				DefaultFileRenamePolicy df=new DefaultFileRenamePolicy();
				MultipartRequest mr=new MultipartRequest(req,upDir,100*1024*1024,"UTF-8", df);
				System.out.println("���ε� ����");
				
				//3. �Ķ���Ͱ� �ޱ�
				String pnum=mr.getParameter("pnum");
				
				String upCg_code=mr.getParameter("upCg_code");
				String downCg_code=mr.getParameter("downCg_code");
				
				String pname=mr.getParameter("pname");
				String pcompany=mr.getParameter("pcompany");
				String pspec=mr.getParameter("pspec");
				String pcontents=mr.getParameter("pcontents");
				
				int price=Integer.parseInt(mr.getParameter("price"));
				int saleprice=Integer.parseInt(mr.getParameter("saleprice"));
				int pqty=Integer.parseInt(mr.getParameter("pqty"));
				int point=Integer.parseInt(mr.getParameter("point"));
				
				//���ε� ���ϸ�
				String pimage1=mr.getFilesystemName("pimage1");
				String pimage2=mr.getFilesystemName("pimage2");
				String pimage3=mr.getFilesystemName("pimage3");
				////////////////////////////////////////////
				if(pimage1==null) {
					//÷�������� ���ٸ�
					pimage1=mr.getParameter("old_pimage1");
				}
				if(pimage2==null) {
					pimage2=mr.getParameter("old_pimage2");
				}
				if(pimage3==null) {
					pimage3=mr.getParameter("old_pimage3");
				}
				
				//////////////////////////////////////////////
				
				//4. ProductVO�� ����ֱ�
				ProductVO item=new ProductVO(upCg_code,null,downCg_code, null,pnum, 
					pname,pimage1,pimage2,pimage3,price, saleprice,point, pqty, pspec,pcontents,pcompany, null);
				
				//5. ProductDAO���� insertProduct()ȣ���ϱ�
				ProductDAO dao=new ProductDAO();
				 
				int n=dao.updateProduct(item);
				
				String str=(n>0)?"��ǰ ���� ����":"��ǰ ���� ����";
				String loc=(n>0)?"prodList.me":"javascript:history.back()";
				
				//6. ����� �޾Ƽ� �޽���,�̵���� req�� ����
				req.setAttribute("message", str);
				req.setAttribute("loc", loc);
				
				//7. ��������, �̵���� ����
				this.setViewPage("../msg.jsp");
				this.setRedirect(false);
	}

}
