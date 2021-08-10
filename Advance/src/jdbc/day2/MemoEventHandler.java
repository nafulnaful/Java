package jdbc.day2;
//select���϶��� ArryList

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
	   //���̺��� ������ ���� �ε�����ȣ �޾ƿ���
	   int row=main.memoTable.getSelectedRow();
	   if(row<0) return;
	   //main.setTitle("row="+row);
	   
	   //������ �۹�ȣ(PK) �˾Ƴ���
	   Integer idx=(Integer)main.memoTable.getValueAt(row, 0);
	   int idx_int=idx.intValue();
	   
	   MemoVO memo=memoDao.selectMemo(idx_int);
	   if(memo==null) {
		   showMsg("�ش� ���� �������� �ʾƿ�");
		   return;
	   }
	   main.showMemo(memo);
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==main.btAdd) {
			addMemo();//�۾��� �� �ڿ�
			listMemo();//��ü ��� ��������
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
		String keyword=JOptionPane.showInputDialog("�޸𳻿뿡�� �˻��� �˻�� �Է��ϼ���");
		if(keyword==null) return;
		
		ArrayList<MemoVO> arr=memoDao.findMemo(keyword);
		if(arr==null) {
			showMsg("�˻��� ����� �����ϴ�.");
			return;
		}
		main.showTable(arr);
	}
	private void editMemo() {
		String idxStr=main.tfIdx.getText();
		if(idxStr==null||idxStr.trim().isEmpty()) {
			showMsg("�۸�Ͽ��� ������ ���� �����ϼ���");
			return;
	}
		MemoVO memo=check(EDIT);
		if(memo!=null) {
			boolean b=memoDao.updateMemo(memo);
			String str=(b)?"���� ó�� �Ϸ�":"���� ����";
			showMsg(str);
			if(b)
				listMemo();
		}
	}	
	private void deleteMemo() {
		String idxStr=main.tfIdx.getText();
		if(idxStr==null||idxStr.trim().isEmpty()) {
			showMsg("�۸�Ͽ��� ������ ���� �����ϼ���");
			return;
		}
		int idx=Integer.parseInt(idxStr.trim());
		
		boolean b=memoDao.deleteMemo(idx);
		String str=(b)?"�� ���� ����":"�� ���� ����";
		showMsg(str);
		clearTF();
		listMemo();
	}
	private void listMemo() {
		ArrayList<MemoVO> arr=memoDao.selectMemoAll();
		//System.out.println("arr"+arr);
		if(arr==null) {
			showMsg("�����ͺ��̽����� ���� �߻�");
			return;
		}
		main.showTable(arr);
	}//---------------------------

	private void addMemo() {
		MemoVO memo=check(ADD);
		if(memo!=null) {
		boolean b=memoDao.insertMemo(memo);
		//main.setTitle("b="+b);
		String str=(b)?"���� ��ϵǾ����":"�� ��� ����";//����:����
		showMsg(str);
		clearTF();
	}
	}//-----------------------------------
	public void clearTF() {//â ����ֱ�
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
				showMsg("������ ���� �۹�ȣ�� �Է��ϼ���");
				return null;
			}
		}
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			showMsg("�ۼ���,�޸𳻿��� �Է��ϼ���");
			main.tfName.requestFocus();
			return null;
		}
		if(msg.length()>100) {
			showMsg("�޸𳻿��� 100�� �̳����� �ؿ�");
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
