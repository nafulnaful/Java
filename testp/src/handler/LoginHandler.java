package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import db.CarDAO;
import db.CarDB;
import db.UserDB;
import exception.AuthenException;
import page.MainFrame;

public class LoginHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
//	UserDB udb=new UserDB();
//	CarDAO cDao;

	public LoginHandler(MainFrame mainF) {
		this.mainF = mainF;
//		cDao=new CarDAO();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		if (o == mainF.loginF.lbLogin) {
		try {
			mainF.loginF.LoginCheck();
			mainF.buyF.contentsBox.removeAll();
//			ArrayList<CarDB> list=cDao.selectCar();
//			mainF.buyF.showItem(list);
		}catch(Exception e1) {
			System.out.println("로그인 데이터 보내는 중 예외: "+e1);
		}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
