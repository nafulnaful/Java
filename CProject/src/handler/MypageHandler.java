package handler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import db.CarDAO;
import db.CarDB;
import db.UserDAO;
import db.UserDB;
import page.MainFrame;

public class MypageHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	
	CarDB cdb=new CarDB();
	CarDAO cdao=new CarDAO();
	UserDAO udao=new UserDAO();

	public MypageHandler(MainFrame mainF) {
		this.mainF = mainF;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if(o==mainF.mypageF.lbUserInfo) {
			mainF.card.show(mainF.pCenter, "ȸ����������"); 
			try {
				mainF.ueditF.userDBload();
				mainF.ueditF.tfTel.setForeground(Color.black);
				mainF.ueditF.tfEmail.setForeground(Color.black);
				
			} catch (Exception e1) {
				System.out.println("�����˻� ����:"+e1.getMessage());
				e1.printStackTrace();
			}
		}else if(o==mainF.mypageF.lbCarInfo) {
			mainF.cinfoF.regCar();
			mainF.card.show(mainF.pCenter, "���������ȸ");
			
		}else if (o == mainF.mypageF.lbCarLike) {
			mainF.likeF.likecar();
			mainF.card.show(mainF.pCenter, "����������ȸ"); 
			
		} else if (o == mainF.mypageF.lbTalk) {
			System.out.println("1:1����");
		} else if (o == mainF.mypageF.lbLogout) {
			System.out.println("�α׾ƿ�");
			
			mainF.card.show(mainF.pCenter,"�α���");
			JOptionPane.showMessageDialog(mainF.pCenter, "�α׾ƿ� �Ǿ����ϴ�.");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/�ϴܹ�_��������.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/�ϴܹ�_����������.png"));
			mainF.isLogin=false;
			mainF.setTitle(":: Chachacha ::");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
