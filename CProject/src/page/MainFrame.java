package page;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import db.CarDB;
import handler.CardHandler;

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
	public TalkPage talkF;
	public JoinPage joinF;
	public User_EditPage ueditF;
	public Car_EditPage ceditF;
	public My_LikePage likeF;
	public My_CarinfoPage cinfoF;
	public Buy_info infoF;
	
	public CarClient client;
	// 로그인 x
	public boolean isLogin = false;
	
	CarDB cardb;
	
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
		
		// Panel 옵션
		CarClient cc=new CarClient(this);
		CardHandler ch=new CardHandler(this);
		pCenter.setLayout(card = new CardLayout());// 카드레이아웃
		loginF = new LoginPage(this, cc, ch);
		buyF = new BuyPage(this);
		sellF = new SellPage(this,ch,cc);
		talkF = new TalkPage(this);
		mypageF = new MyPage(this);
		joinF = new JoinPage(this, ch, cc);
		ueditF = new User_EditPage(this);
		ceditF = new Car_EditPage(this);
		likeF = new My_LikePage(this);
		cinfoF = new My_CarinfoPage(this);
		infoF= new Buy_info(this);

		pCenter.add("로그인", loginF);
		pCenter.add("내차구매", buyF);
		pCenter.add("내차팔기", sellF);
		pCenter.add("내차자랑", talkF);
		pCenter.add("마이페이지", mypageF);
		pCenter.add("회원가입", joinF);
		pCenter.add("회원정보수정", ueditF);
		pCenter.add("차량정보수정", ceditF);
		pCenter.add("등록차량조회", cinfoF);
		pCenter.add("관심차량조회", likeF);
		pCenter.add("차량정보조회", infoF);

		// MyHandler 부착-------------------
		CardHandler handler = new CardHandler(this);
		this.lbLogin.addMouseListener(handler);
		this.lbMypage.addMouseListener(handler);
		this.lbBuy.addMouseListener(handler);
		this.lbSell.addMouseListener(handler);
		this.lbLike.addMouseListener(handler);
		loginF.lbJoin.addMouseListener(handler);
		mypageF.lbUserInfo.addMouseListener(handler);
		mypageF.lbCarLike.addMouseListener(handler);
		mypageF.lbCarInfo.addMouseListener(handler);
		mypageF.lbCarLike.addMouseListener(handler);
		buyF.contentsBox.addMouseListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//코드번호 600번 보내는 객체 생성 -- 600번은 자동차전체조회 코드번호
		select();
		// 창크기 고정
		setResizable(false);
		
		
////////////////////////////////////////////////////////////////////////////////////[GUI]////////////
	}// 생성자------
	public void select() {
		CarDB cardb=new CarDB(600);
		sellF.Response(cardb);
	}
	
	
	public void setLabelUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}
	
	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(410, 730);
		my.setVisible(true);
	}

}
