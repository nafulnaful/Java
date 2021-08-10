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
		// 1. 상품이미지 업로드 처리-업로드할 디렉토리의 절대경로 구하기
				//application.getRealPath("/product_images");
				ServletContext app=req.getServletContext();
				String upDir=app.getRealPath("/product_images");
				System.out.println(upDir);
				
				//2. cos.jar의 MultipartRequest를 생성
				DefaultFileRenamePolicy df=new DefaultFileRenamePolicy();
				MultipartRequest mr=new MultipartRequest(req,upDir,100*1024*1024,"UTF-8", df);
				System.out.println("업로드 성공");
				
				//3. 파라미터값 받기
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
				
				//업로드 파일명
				String pimage1=mr.getFilesystemName("pimage1");
				String pimage2=mr.getFilesystemName("pimage2");
				String pimage3=mr.getFilesystemName("pimage3");
				////////////////////////////////////////////
				if(pimage1==null) {
					//첨부파일이 없다면
					pimage1=mr.getParameter("old_pimage1");
				}
				if(pimage2==null) {
					pimage2=mr.getParameter("old_pimage2");
				}
				if(pimage3==null) {
					pimage3=mr.getParameter("old_pimage3");
				}
				
				//////////////////////////////////////////////
				
				//4. ProductVO에 담아주기
				ProductVO item=new ProductVO(upCg_code,null,downCg_code, null,pnum, 
					pname,pimage1,pimage2,pimage3,price, saleprice,point, pqty, pspec,pcontents,pcompany, null);
				
				//5. ProductDAO생성 insertProduct()호출하기
				ProductDAO dao=new ProductDAO();
				 
				int n=dao.updateProduct(item);
				
				String str=(n>0)?"상품 수정 성공":"상품 수정 실패";
				String loc=(n>0)?"prodList.me":"javascript:history.back()";
				
				//6. 결과값 받아서 메시지,이동경로 req에 저장
				req.setAttribute("message", str);
				req.setAttribute("loc", loc);
				
				//7. 뷰페이지, 이동방식 지정
				this.setViewPage("../msg.jsp");
				this.setRedirect(false);
	}

}
