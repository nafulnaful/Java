package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.SampleDAOMyBatis;

//Sub Controller : 실질적인 업무를 담당함
//AbstractAction추상클래스를 상속받는다.
public class IndexAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("IndexAction의 execute()호출됨...");
		
		SampleDAOMyBatis dao=new SampleDAOMyBatis();
		
		int cnt=dao.getTableCount();
		System.out.println("cnt="+cnt);
		
		//로직 수행
		req.setAttribute("msg", "TIS_SHOP계정의 테이블 수");
		req.setAttribute("count", cnt);
		
		//this.setViewPage("/index.jsp");//뷰페이지 지정
		this.setViewPage("/main.jsp");
		this.setRedirect(false);//false를 주면 forward방식으로 이동		
	}
	

}
