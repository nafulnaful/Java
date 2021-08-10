package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import db.UserDAO;
import db.UserDB;
import page.MainFrame;

public class MypageHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	
	UserDB udb=new UserDB();
	UserDAO userdao=new UserDAO();

	public MypageHandler(MainFrame mainF) {
		this.mainF = mainF;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.mypageF.lbUserInfo) {
			System.out.println("회원정보수정");
		} else if (o == mainF.mypageF.lbCarInfo) {
			System.out.println("관심차량조회");
		} else if (o == mainF.mypageF.lbTalk) {
			System.out.println("1:1문의");
		} else if (o == mainF.mypageF.lbLogout) {
			System.out.println("로그아웃");
			mainF.mypageF.logout();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
