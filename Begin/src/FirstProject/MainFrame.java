package FirstProject;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import FirstProject.Car;

public class MainFrame extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel(new GridLayout(1, 5));
	JLabel lbBuy, lbSell, lbLike, lbMypage, lbLogin;

	ObjectOutputStream out;// 객체를 파일로 저장할 수 있는 클래스
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	Hashtable<String, User> userTable = new Hashtable<>();
	Vector<Car> carVector = new Vector<>();

	// 구매, 팔기, 관심, 마이페이지 창
	CardLayout card;
	Login loginF;
	MyPage mypageF;
	BuyPage buyF;
	SellPage sellF;
	LikePage likeF;
	Join joinF;
	Car carF;

	// 로그인 x
	boolean isLogin = false;
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
		setLabelUI(lbLogin);
		setLabelUI(lbBuy);
		setLabelUI(lbSell);
		setLabelUI(lbLike);
		setLabelUI(lbMypage);

		// Panel 옵션
		pCenter.setLayout(card = new CardLayout());// 카드레이아웃
		loginF = new Login(this);
		buyF = new BuyPage(this);
		sellF = new SellPage(this);
		likeF = new LikePage(this);
		mypageF = new MyPage(this);

		pCenter.add("로그인", loginF);
		pCenter.add("내차구매", buyF);
		pCenter.add("내차팔기", sellF);
		pCenter.add("관심차량", likeF);
		pCenter.add("마이페이지", mypageF);

		// MyHandler 부착-------------------
		CarHandler handler = new CarHandler(this);
		this.lbLogin.addMouseListener(handler);
		this.lbMypage.addMouseListener(handler);
		this.lbBuy.addMouseListener(handler);
		this.lbSell.addMouseListener(handler);
		this.lbLike.addMouseListener(handler);
		this.sellF.lbDone.addMouseListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 회원 데이터 가져오기-
		readFile("src/FirstProject/user.txt");

		// 창크기 고정
		setResizable(false);
////////////////////////////////////////////////////////////////////////////////////[GUI]////////////
	}// 생성자------

	private void readFile(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			userTable = (Hashtable<String, User>) obj;
			System.out.println("현재 회원 수: " + userTable.size());
		} catch (Exception e) {
			System.out.println("파일 읽는 중 에러: " + e.getMessage());
		}
	}// ----------------------------

	public void saveFile(String fileName) {
		try {
			fout = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fout);
			out.writeObject(userTable);
			out.flush();
			out.close();
			fout.close();
			System.out.println(fileName + "에 저장 완료!");
			System.out.println(fileName + "에 저장 완료!");
		} catch (IOException e) {
			System.out.println("파일 저장 중 에러 발생: " + e.getMessage());
			e.printStackTrace();
		}

	}// -------------------

	public void setLabelUI(JLabel lb) {
		lb.setOpaque(true);
		lb.setBackground(Color.white);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
	}

	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(390, 650);
		my.setVisible(true);
	}

}
