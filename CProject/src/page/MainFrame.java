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
	
	// ����, �ȱ�, ����, ���������� â
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
	// �α��� x
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
		lbLogin = new JLabel("", new ImageIcon("src/images/�ϴܹ�_�α��μ���.png"), JLabel.CENTER);
		lbBuy = new JLabel("", new ImageIcon("src/images/�ϴܹ�_��������.png"), JLabel.CENTER);
		lbSell = new JLabel("", new ImageIcon("src/images/�ϴܹ�_�����ȱ�.png"), JLabel.CENTER);
		lbLike = new JLabel("", new ImageIcon("src/images/�ϴܹ�_�����ڶ�.png"), JLabel.CENTER);
		lbMypage = new JLabel("", new ImageIcon("src/images/�ϴܹ�_����������.png"), JLabel.CENTER);
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
		
		// Panel �ɼ�
		CarClient cc=new CarClient(this);
		CardHandler ch=new CardHandler(this);
		pCenter.setLayout(card = new CardLayout());// ī�巹�̾ƿ�
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

		pCenter.add("�α���", loginF);
		pCenter.add("��������", buyF);
		pCenter.add("�����ȱ�", sellF);
		pCenter.add("�����ڶ�", talkF);
		pCenter.add("����������", mypageF);
		pCenter.add("ȸ������", joinF);
		pCenter.add("ȸ����������", ueditF);
		pCenter.add("������������", ceditF);
		pCenter.add("���������ȸ", cinfoF);
		pCenter.add("����������ȸ", likeF);
		pCenter.add("����������ȸ", infoF);

		// MyHandler ����-------------------
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
		
		
		//�ڵ��ȣ 600�� ������ ��ü ���� -- 600���� �ڵ�����ü��ȸ �ڵ��ȣ
		select();
		// âũ�� ����
		setResizable(false);
		
		
////////////////////////////////////////////////////////////////////////////////////[GUI]////////////
	}// ������------
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
