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

	ObjectOutputStream out;// ��ü�� ���Ϸ� ������ �� �ִ� Ŭ����
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;

	Hashtable<String, User> userTable = new Hashtable<>();
	Vector<Car> carVector = new Vector<>();

	// ����, �ȱ�, ����, ���������� â
	CardLayout card;
	Login loginF;
	MyPage mypageF;
	BuyPage buyF;
	SellPage sellF;
	LikePage likeF;
	Join joinF;
	Car carF;

	// �α��� x
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
		lbLogin = new JLabel("", new ImageIcon("./pj_img/�ϴܹ�_�α��μ���.png"), JLabel.CENTER);
		lbBuy = new JLabel("", new ImageIcon("./pj_img/�ϴܹ�_��������.png"), JLabel.CENTER);
		lbSell = new JLabel("", new ImageIcon("./pj_img/�ϴܹ�_�����ȱ�.png"), JLabel.CENTER);
		lbLike = new JLabel("", new ImageIcon("./pj_img/�ϴܹ�_��������.png"), JLabel.CENTER);
		lbMypage = new JLabel("", new ImageIcon("./pj_img/�ϴܹ�_����������.png"), JLabel.CENTER);
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
		pCenter.setLayout(card = new CardLayout());// ī�巹�̾ƿ�
		loginF = new Login(this);
		buyF = new BuyPage(this);
		sellF = new SellPage(this);
		likeF = new LikePage(this);
		mypageF = new MyPage(this);

		pCenter.add("�α���", loginF);
		pCenter.add("��������", buyF);
		pCenter.add("�����ȱ�", sellF);
		pCenter.add("��������", likeF);
		pCenter.add("����������", mypageF);

		// MyHandler ����-------------------
		CarHandler handler = new CarHandler(this);
		this.lbLogin.addMouseListener(handler);
		this.lbMypage.addMouseListener(handler);
		this.lbBuy.addMouseListener(handler);
		this.lbSell.addMouseListener(handler);
		this.lbLike.addMouseListener(handler);
		this.sellF.lbDone.addMouseListener(handler);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ȸ�� ������ ��������-
		readFile("src/FirstProject/user.txt");

		// âũ�� ����
		setResizable(false);
////////////////////////////////////////////////////////////////////////////////////[GUI]////////////
	}// ������------

	private void readFile(String fileName) {
		try {
			fin = new FileInputStream(fileName);
			in = new ObjectInputStream(fin);
			Object obj = in.readObject();
			userTable = (Hashtable<String, User>) obj;
			System.out.println("���� ȸ�� ��: " + userTable.size());
		} catch (Exception e) {
			System.out.println("���� �д� �� ����: " + e.getMessage());
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
			System.out.println(fileName + "�� ���� �Ϸ�!");
			System.out.println(fileName + "�� ���� �Ϸ�!");
		} catch (IOException e) {
			System.out.println("���� ���� �� ���� �߻�: " + e.getMessage());
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
