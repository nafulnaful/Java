package memo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import memo.domain.MemoVO;
import memo.persistence.MemoDAO;

public class MemoAddAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 사용자가 입력한 값 받자
		String name=req.getParameter("name");
		String msg=req.getParameter("msg");
		
		//2. 유효성 체크
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			this.setRedirect(true);
			this.setViewPage("memo.me");
			//redirect방식으로 글쓰기 폼 페이지로 이동
			return;
		}
		
		//3. MemoVO에 담기
		MemoVO memo=new MemoVO(0,name, msg, null);
		
		//4. MemoDAO생성 insertMemo()호출
		MemoDAO dao=new MemoDAO();
		
		boolean b=dao.insertMemo(memo);
		
		//5. req에 message, loc 저장
		String str="", loc="";
		if(b) {
			str="메모 등록 성공";
			loc="memoList.me";
		}else {
			str="메모 등록 실패";
			loc="javascript:history.back()";
		}
		req.setAttribute("message", str);
		req.setAttribute("loc", loc);
		
		//6. 뷰페이지 지정
		this.setViewPage("msg.jsp");
		//7. 이동방식 지정
		this.setRedirect(false);
	}

}
