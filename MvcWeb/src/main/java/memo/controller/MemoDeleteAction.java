package memo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import memo.persistence.MemoDAO;

public class MemoDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. ������ �۹�ȣ �ޱ�
		String idx=req.getParameter("idx");
		//2. ��ȿ�� üũ (redirect�� memoList.me�� �̵�)
		if(idx==null||idx.trim().isEmpty()) {
			this.setViewPage("memoList.me");
			//this.setViewPage("memo/list.jsp");[x]
			this.setRedirect(true);
			return;
		}
		
		//3. MemoDAO ���� deleteMemo()ȣ���ϱ�
		MemoDAO dao=new MemoDAO();
		boolean b=dao.deleteMemo(Integer.parseInt(idx));
		
		//4. ������ message, loc ����=> "���� ����", �̵����: "memoList.me"
		String str="", loc="memoList.me";
		if(b) {
			str="���� ����";			
		}else {
			str="���� ����";
		}
		req.setAttribute("message", str);
		req.setAttribute("loc", loc);

		//5. �������� ���� => msg.jsp
		this.setViewPage("msg.jsp");
		//6. �̵���� ����=> forward�̵�
		this.setRedirect(false);

	}

}
