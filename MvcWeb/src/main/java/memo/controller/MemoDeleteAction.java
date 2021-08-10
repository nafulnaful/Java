package memo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import memo.persistence.MemoDAO;

public class MemoDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//1. 삭제할 글번호 받기
		String idx=req.getParameter("idx");
		//2. 유효성 체크 (redirect로 memoList.me로 이동)
		if(idx==null||idx.trim().isEmpty()) {
			this.setViewPage("memoList.me");
			//this.setViewPage("memo/list.jsp");[x]
			this.setRedirect(true);
			return;
		}
		
		//3. MemoDAO 생성 deleteMemo()호출하기
		MemoDAO dao=new MemoDAO();
		boolean b=dao.deleteMemo(Integer.parseInt(idx));
		
		//4. 실행결과 message, loc 저장=> "삭제 성공", 이동경로: "memoList.me"
		String str="", loc="memoList.me";
		if(b) {
			str="삭제 성공";			
		}else {
			str="삭제 실패";
		}
		req.setAttribute("message", str);
		req.setAttribute("loc", loc);

		//5. 뷰페이지 지정 => msg.jsp
		this.setViewPage("msg.jsp");
		//6. 이동방식 지정=> forward이동
		this.setRedirect(false);

	}

}
