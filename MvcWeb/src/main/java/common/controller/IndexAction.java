package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.SampleDAOMyBatis;

//Sub Controller : �������� ������ �����
//AbstractAction�߻�Ŭ������ ��ӹ޴´�.
public class IndexAction extends AbstractAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("IndexAction�� execute()ȣ���...");
		
		SampleDAOMyBatis dao=new SampleDAOMyBatis();
		
		int cnt=dao.getTableCount();
		System.out.println("cnt="+cnt);
		
		//���� ����
		req.setAttribute("msg", "TIS_SHOP������ ���̺� ��");
		req.setAttribute("count", cnt);
		
		//this.setViewPage("/index.jsp");//�������� ����
		this.setViewPage("/main.jsp");
		this.setRedirect(false);//false�� �ָ� forward������� �̵�		
	}
	

}
