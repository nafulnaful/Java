package page;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import db.CarDAO;
import db.CarDB;
import handler.CardHandler;
import handler.UserHandler;

public class MainFrame extends JFrame {

	public JPanel p = new JPanel(new BorderLayout());
	public JPanel pCenter = new JPanel();
	public JPanel pSouth = new JPanel(new GridLayout(1, 5));
	public JLabel lbBuy, lbSell, lbLike, lbMypage, lbLogin;
	
	// 구매, 팔기, 관심, 마이페이지 창
	public CardLayout card;
	public LoginPage loginF;
	public MyPage mypageF;
	public BuyPage buyF;
	public SellPage sellF;
	public LikePage likeF;
	public JoinPage joinF;
	public User_EditPage ueditF;
	public Car_EditPage ceditF;
	
	// 로그인 x
	public boolean isLogin = true;

	
////////////////////////////////////////////////////////////////////////////////////////
	public MainFrame() {
		super(":: Chachacha ::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");

		// Panel
		p.setBackground(Color.white);
		p.add(pCenter, "Center");
		p.add(pSouth, "South");

		// Label
		lbLogin = new JLabel("", new ImageIcon("src/images/하단바_로그인선택.png"), JLabel.CENTER);
		lbBuy = new JLabel("", new ImageIcon("src/images/하단바_내차구매.png"), JLabel.CENTER);
		lbSell = new JLabel("", new ImageIcon("src/images/하단바_내차팔기.png"), JLabel.CENTER);
		lbLike = new JLabel("", new ImageIcon("src/images/하단바_내차자랑.png"), JLabel.CENTER);
		lbMypage = new JLabel("", new ImageIcon("src/images/하단바_마이페이지.png"), JLabel.CENTER);
		pSouth.add(lbLogin);
		pSouth.add(lbBuy);
		pSouth.add(lbSell);
		pSouth.add(lbLike);
		pSouth.add(lbMypage);
		setLabelUI(lbLogin);
		setLabelUI(lbBuy);
		setLabelUI(lbSell);
		setLabelUI(lbLike);
		setLabelUI(lbMypage);
		
		UserHandler uh=new UserHandler(this);
		
		// Panel 옵션
		pCenter.setLayout(card = new CardLayout());// 카드레이아웃
		loginF = new LoginPage(this, uh);
		buyF = new BuyPage(this, uh);
		sellF = new SellPage(this, uh);
		likeF = new LikePage(this, uh);
		mypageF = new MyPage(this, uh);
		joinF = new JoinPage(this, uh);
		ueditF = new User_EditPage(this, uh);
		ceditF = new Car_EditPage(this, uh);

		pCenter.add("로그인", loginF);
		pCenter.add("내차구매", buyF);
		pCenter.add("내차팔기", sellF);
		pCenter.add("내차자랑", likeF);
		pCenter.add("마이페이지", mypageF);
		pCenter.add("회원가입", joinF);
		pCenter.add("회원정보수정", ueditF);
		pCenter.add("차량정보수정", ceditF);

		// MyHandler 부착-------------------
		CardHandler handler = new CardHandler(this);
		this.lbLogin.addMouseListener(handler);
		this.lbMypage.addMouseListener(handler);
		this.lbBuy.addMouseListener(handler);
		this.lbSell.addMouseListener(handler);
		this.lbLike.addMouseListener(handler);
		loginF.lbJoin.addMouseListener(handler);
		mypageF.lbUserInfo.addMouseListener(handler);
		this.buyF.lbEdit.addMouseListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 창크기 고정
		setResizable(true);
////////////////////////////////////////////////////////////////////////////////////[GUI]////////////
	}// 생성자------

	public void setLabelUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}

	
	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(410, 740);
		my.setVisible(true);
	}

}
