package jdbc.day2;
//select문일때는 ArryList

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MemoEventHandler extends MouseAdapter implements ActionListener {
   
   MemoGui main;
   MemoDAO memoDao;
   public static final int ADD=1;
   public static final int EDIT=2;
   public MemoEventHandler(MemoGui main) {
      this.main =  main;
      memoDao=new MemoDAO();
      listMemo();
   }
   @Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("asdf");
	   //테이블에서 선택한 행의 인덱스번호 받아오기
	   int row=main.memoTable.getSelectedRow();
	   if(row<0) return;
	   //main.setTitle("row="+row);
	   
	   //선택한 글번호(PK) 알아내기
	   Integer idx=(Integer)main.memoTable.getValueAt(row, 0);
	   int idx_int=idx.intValue();
	   
	   MemoVO memo=memoDao.selectMemo(idx_int);
	   if(memo==null) {
		   showMsg("해당 글은 존재하지 않아요");
		   return;
	   }
	   main.showMemo(memo);
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==main.btAdd) {
			addMemo();//글쓰기 한 뒤에
			listMemo();//전체 목록 가져오기
			}else if(o==main.btList) {
				listMemo();
			}else if(o==main.btDel) {
				deleteMemo();
			}else if(o==main.btEdit) {
				editMemo();
			}else if(o==main.btFind) {
				findMemo();
			}
		}//---------------------------------------
	private void findMemo() {
		String keyword=JOptionPane.showInputDialog("메모내용에서 검색할 검색어를 입력하세요");
		if(keyword==null) return;
		
		ArrayList<MemoVO> arr=memoDao.findMemo(keyword);
		if(arr==null) {
			showMsg("검색한 결과가 없습니다.");
			return;
		}
		main.showTable(arr);
	}
	private void editMemo() {
		String idxStr=main.tfIdx.getText();
		if(idxStr==null||idxStr.trim().isEmpty()) {
			showMsg("글목록에서 수정할 글을 선택하세요");
			return;
	}
		MemoVO memo=check(EDIT);
		if(memo!=null) {
			boolean b=memoDao.updateMemo(memo);
			String str=(b)?"수정 처리 완료":"수정 실패";
			showMsg(str);
			if(b)
				listMemo();
		}
	}	
	private void deleteMemo() {
		String idxStr=main.tfIdx.getText();
		if(idxStr==null||idxStr.trim().isEmpty()) {
			showMsg("글목록에서 삭제할 글을 선택하세요");
			return;
		}
		int idx=Integer.parseInt(idxStr.trim());
		
		boolean b=memoDao.deleteMemo(idx);
		String str=(b)?"글 삭제 성공":"글 삭제 실패";
		showMsg(str);
		clearTF();
		listMemo();
	}
	private void listMemo() {
		ArrayList<MemoVO> arr=memoDao.selectMemoAll();
		//System.out.println("arr"+arr);
		if(arr==null) {
			showMsg("데이터베이스에서 오류 발생");
			return;
		}
		main.showTable(arr);
	}//---------------------------

	private void addMemo() {
		MemoVO memo=check(ADD);
		if(memo!=null) {
		boolean b=memoDao.insertMemo(memo);
		//main.setTitle("b="+b);
		String str=(b)?"글이 등록되었어요":"글 등록 실패";//성공:실패
		showMsg(str);
		clearTF();
	}
	}//-----------------------------------
	public void clearTF() {//창 비워주기
		main.tfIdx.setText("");
		main.tfName.setText("");
		main.tfMsg.setText("");
		main.tfName.requestFocus();
	}

	private MemoVO check(int mode) {
		String idx=main.tfIdx.getText();
		String name=main.tfName.getText();
		String msg=main.tfMsg.getText();
		if(mode==EDIT) {
			if(idx==null||idx.trim().isEmpty()) {
				showMsg("수정할 글의 글번호를 입력하세요");
				return null;
			}
		}
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			showMsg("작성자,메모내용을 입력하세요");
			main.tfName.requestFocus();
			return null;
		}
		if(msg.length()>100) {
			showMsg("메모내용은 100자 이내여야 해요");
			main.tfMsg.requestFocus();
			return null;
		}
		int idx_int=(mode==EDIT)?Integer.parseInt(idx):0;
		MemoVO memo=new MemoVO(idx_int,name,msg,null);
		return memo;
	}//----------------------------------------------------------------

	private void showMsg(String string) {
		JOptionPane.showMessageDialog(main, string);
		
	}
}
