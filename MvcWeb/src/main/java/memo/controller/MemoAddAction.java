package memo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import memo.domain.MemoVO;
import memo.persistence.MemoDAO;

public class MemoAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. ����ڰ� �Է��� �� ����
		String name=req.getParameter("name");
		String msg=req.getParameter("msg");
		
		//2. ��ȿ�� üũ
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			this.setRedirect(true);
			this.setViewPage("memo.me");
			//redirect������� �۾��� �� �������� �̵�
			return;
		}
		
		//3. MemoVO�� ���
		MemoVO memo=new MemoVO(0,name, msg, null);
		
		//4. MemoDAO���� insertMemo()ȣ��
		MemoDAO dao=new MemoDAO();
		
		boolean b=dao.insertMemo(memo);
		
		//5. req�� message, loc ����
		String str="", loc="";
		if(b) {
			str="�޸� ��� ����";
			loc="memoList.me";
		}else {
			str="�޸� ��� ����";
			loc="javascript:history.back()";
		}
		req.setAttribute("message", str);
		req.setAttribute("loc", loc);
		
		//6. �������� ����
		this.setViewPage("msg.jsp");
		//7. �̵���� ����
		this.setRedirect(false);
	}

}
