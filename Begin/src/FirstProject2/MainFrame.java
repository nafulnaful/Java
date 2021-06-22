package FirstProject2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import FirstProject.BuyPage;
import FirstProject.Car;
import FirstProject.Join;
import FirstProject.LikePage;
import FirstProject.Login;
import FirstProject.MyPage;
import FirstProject.SellPage;

public class MainFrame extends JFrame {
	
	JPanel p = new JPanel(new BorderLayout());
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel(new GridLayout(1, 5));
	JLabel lbBuy, lbSell, lbLike, lbMypage, lbLogin;

	ObjectOutputStream out;// 객체를 파일로 저장할 수 있는 클래스
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;
	
	// 구매, 팔기, 관심, 마이페이지 창
		CardLayout card;
		Login loginF;
		MyPage mypageF;
		BuyPage buyF;
		SellPage sellF;
		LikePage likeF;
		Join joinF;
		Car carF;

		public MainFrame() {
			super(":: Chachacha ::");
			Container cp = this.getContentPane();
			cp.add(p, "Center");

			// Panel
			p.setBackground(Color.white);
			p.add(pCenter, "Center");
			p.add(pSouth, "South");

			// Label
			lbLogin = new JLabel("", new ImageIcon("./pj_img/하단바_로그인선택.png"), JLabel.CENTER);
			lbBuy = new JLabel("", new ImageIcon("./pj_img/하단바_내차구매.png"), JLabel.CENTER);
			lbSell = new JLabel("", new ImageIcon("./pj_img/하단바_내차팔기.png"), JLabel.CENTER);
			lbLike = new JLabel("", new ImageIcon("./pj_img/하단바_관심차량.png"), JLabel.CENTER);
			lbMypage = new JLabel("", new ImageIcon("./pj_img/하단바_마이페이지.png"), JLabel.CENTER);
			pSouth.add(lbLogin);
			pSouth.add(lbBuy);
			pSouth.add(lbSell);
			pSouth.add(lbLike);
			pSouth.add(lbMypage);
			
			// Panel 옵션
			pCenter.setLayout(card = new CardLayout());// 카드레이아웃
			

			pCenter.add("로그인", loginF);
			pCenter.add("내차구매", buyF);
			pCenter.add("내차팔기", sellF);
			pCenter.add("관심차량", likeF);
			pCenter.add("마이페이지", mypageF);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자------

	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(390, 650);
		my.setVisible(true);
	}

}
