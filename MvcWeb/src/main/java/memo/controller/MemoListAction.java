package memo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import memo.domain.MemoVO;
import memo.persistence.MemoDAO;

public class MemoListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		MemoDAO dao=new MemoDAO();
		
		ArrayList<MemoVO> arr=dao.selectMemoAll();
		System.out.println("arr="+arr);
		
		req.setAttribute("memoArr", arr);
		
		this.setViewPage("memo/list.jsp");
		this.setRedirect(false);
	}

}
