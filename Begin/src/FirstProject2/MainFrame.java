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

	ObjectOutputStream out;// ��ü�� ���Ϸ� ������ �� �ִ� Ŭ����
	ObjectInputStream in;
	FileOutputStream fout;
	FileInputStream fin;
	
	// ����, �ȱ�, ����, ���������� â
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
			
			// Panel �ɼ�
			pCenter.setLayout(card = new CardLayout());// ī�巹�̾ƿ�
			

			pCenter.add("�α���", loginF);
			pCenter.add("��������", buyF);
			pCenter.add("�����ȱ�", sellF);
			pCenter.add("��������", likeF);
			pCenter.add("����������", mypageF);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������------

	public static void main(String[] args) {
		MainFrame my = new MainFrame();
		my.setSize(390, 650);
		my.setVisible(true);
	}

}
