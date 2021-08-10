package FirstProject;

import java.awt.event.*;
import javax.swing.*;

public class CarHandler extends MouseAdapter implements ActionListener {
	MainFrame mainF;

	public CarHandler(MainFrame mainF) {
		this.mainF = mainF;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object o = e.getSource();
		
		//로그인 버튼
		if (o == mainF.lbLogin) {
			mainF.card.show(mainF.pCenter, "로그인");
		//차량 구매 버튼	
		} else if (o == mainF.lbBuy) {
			mainF.card.show(mainF.pCenter, "내차구매");
			mainF.buyF.showCarTable();
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매선택.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			//차량 판매 버튼
		} else if (o == mainF.lbSell) {
			mainF.card.show(mainF.pCenter, "내차팔기");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기선택.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			//차량 관심 버튼
		} else if (o == mainF.lbLike) {
			mainF.card.show(mainF.pCenter, "관심차량");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량선택.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			//마이페이지 버튼
		} else if (o == mainF.lbMypage) {
			mainF.card.show(mainF.pCenter, "마이페이지");
			mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인.png"));
			mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
			mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
			mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
			mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지선택.png"));
		}
		//[로그인하지 않으면 접근불가]///////////////////////////////////////////////////////////////////////////
		if (o == mainF.lbBuy) {
			
			
			if (mainF.isLogin) {
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbSell) {
			
			
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "내차팔기");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbLike) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "관심차량");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			}

		} else if (o == mainF.lbMypage) {
			if (mainF.isLogin) {
				mainF.card.show(mainF.pCenter, "마이페이지");
			} else { 
				mainF.card.show(mainF.pCenter, "로그인");
				JOptionPane.showMessageDialog(mainF.pCenter, "로그인 후 이용가능합니다.");
				mainF.lbLogin.setIcon(new ImageIcon("./pj_img/하단바_로그인선택.png"));
				mainF.lbBuy.setIcon(new ImageIcon("./pj_img/하단바_내차구매.png"));
				mainF.lbSell.setIcon(new ImageIcon("./pj_img/하단바_내차팔기.png"));
				mainF.lbLike.setIcon(new ImageIcon("./pj_img/하단바_관심차량.png"));
				mainF.lbMypage.setIcon(new ImageIcon("./pj_img/하단바_마이페이지.png"));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}