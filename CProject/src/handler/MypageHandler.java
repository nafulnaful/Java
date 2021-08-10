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
			mainF.card.show(mainF.pCenter, "회원정보수정"); 
			try {
				mainF.ueditF.userDBload();
				mainF.ueditF.tfTel.setForeground(Color.black);
				mainF.ueditF.tfEmail.setForeground(Color.black);
				
			} catch (Exception e1) {
				System.out.println("차량검색 예외:"+e1.getMessage());
				e1.printStackTrace();
			}
		}else if(o==mainF.mypageF.lbCarInfo) {
			mainF.cinfoF.regCar();
			mainF.card.show(mainF.pCenter, "등록차량조회");
			
		}else if (o == mainF.mypageF.lbCarLike) {
			mainF.likeF.likecar();
			mainF.card.show(mainF.pCenter, "관심차량조회"); 
			
		} else if (o == mainF.mypageF.lbTalk) {
			System.out.println("1:1문의");
		} else if (o == mainF.mypageF.lbLogout) {
			System.out.println("로그아웃");
			
			mainF.card.show(mainF.pCenter,"로그인");
			JOptionPane.showMessageDialog(mainF.pCenter, "로그아웃 되었습니다.");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			mainF.isLogin=false;
			mainF.setTitle(":: Chachacha ::");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
