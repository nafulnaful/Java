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
	
	//���콺 Ŀ�� �̵��� ����ó��
	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.ueditF.lbDone) {
			try {
				mainF.ueditF.userUpdate(); //ȸ����������
			} catch (AuthenException e1) {
				System.out.println("ȸ������ ����: "+e1.getMessage());
			}
		} else if (o == mainF.ueditF.lbDel) {
			mainF.ueditF.deleteUser(); //ȸ��Ż��
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
				System.out.println("�������� ����: "+e2.getMessage());
			}
			
		}
	}// -----
}
