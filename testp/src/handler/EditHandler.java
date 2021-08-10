package handler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import exception.AuthenException;
import page.Car_EditPage;
import page.JoinPage;
import page.MainFrame;
import page.User_EditPage;

public class EditHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	User_EditPage ueditF;
	Car_EditPage ceditF;

	public EditHandler(MainFrame mainF) {
		this.mainF=mainF;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}// -----
	
	//마우스 커서 이동시 공백처리
	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.ueditF.lbDone) {
			try {
				mainF.ueditF.userUpdate(); //회원정보수정
			} catch (AuthenException e1) {
				System.out.println("회원수정 예외: "+e1.getMessage());
			}
		} else if (o == mainF.ueditF.lbDel) {
			mainF.ueditF.deleteUser(); //회원탈퇴
		} else if (o == mainF.ueditF.tfTel) {
			mainF.ueditF.tfTel.setText("");
			mainF.ueditF.tfTel.setForeground(Color.black);
		} else if (o == mainF.ueditF.tfEmail) {
			mainF.ueditF.tfEmail.setText("");
			mainF.ueditF.tfEmail.setForeground(Color.black);
		}
		
		if(o == mainF.ceditF.lbDone) {
			try {
				mainF.ceditF.carUpdate();
			} catch (Exception e2) {
				System.out.println("차량수정 예외: "+e2.getMessage());
			}
			
		}
	}// -----
}
