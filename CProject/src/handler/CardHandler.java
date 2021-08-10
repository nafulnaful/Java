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
import page.BuyPage;
import page.MainFrame;
import page.SellPage;

public class CardHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;
	CarDAO cDao;

	public CardHandler(MainFrame mainF) {
		this.mainF = mainF;
		cDao=new CarDAO();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		
		//로그인 버튼
		if (o == mainF.lbLogin) {
			mainF.card.show(mainF.pCenter, "로그인");
		}else if(o==mainF.loginF.lbJoin) {
	         mainF.card.show(mainF.pCenter, "회원가입");
		//차량 구매 버튼	
		} else if (o == mainF.lbBuy) {
			mainF.select();
			mainF.card.show(mainF.pCenter, "내차구매");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매선택.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			//차량 판매 버튼
		} else if (o == mainF.lbSell) {
			mainF.card.show(mainF.pCenter, "내차팔기");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기선택.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			//차량 관심 버튼
		} else if (o == mainF.lbLike) {
			mainF.card.show(mainF.pCenter, "내차자랑");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑선택.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			//마이페이지 버튼
		} else if (o == mainF.lbMypage) {
			mainF.card.show(mainF.pCenter, "마이페이지");
			mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
			mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지선택.png"));
		}
		//[로그인하지 않으면 접근불가]///////////////////////////////////////////////////////////////////////////
		if (o == mainF.lbBuy) {
			
			
			if (mainF.isLogin) {
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbSell) {
			
			
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "내차팔기");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbLike) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "내차자랑");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbMypage) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "마이페이지");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("src/images/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("src/images/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("src/images/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("src/images/하단바_내차자랑.png"));
				mainF.lbMypage.setIcon(new ImageIcon("src/images/하단바_마이페이지.png"));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}